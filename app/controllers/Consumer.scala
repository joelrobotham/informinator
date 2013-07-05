package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json
import model.NotificationDAO
import java.text.SimpleDateFormat

object Consumer extends Controller {
  def details(consumerId: String) = Action { request =>
    val results = Map(
      "count" -> Json.toJson(request.uri + "/count"),
      "recent" -> Json.toJson(request.uri + "/recent"))
    Ok(Json.toJson(results))
  }
  
  def count(consumerId: String) = Action(
		  Ok(NotificationDAO.findByEmail(consumerId).length.toString))

  def recent(consumerId: String) = Action { request =>
    val dateFormat = new SimpleDateFormat("d MMMM yyyy hh:mm")
    val json = NotificationDAO.findByEmail(consumerId)
    	.map((notify => Map(
          "id" -> Some(notify._id.toString),
    			"message" -> notify.message,
    			"body" -> notify.body,
    			"creation" -> Some(dateFormat.format(notify.creation)),
    			"url" -> notify.url)));
    
    Ok(Json.toJson(json)).withHeaders(
      "Access-Control-Allow-Origin" -> "*",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Host, Api-Token"
    )
    
  }
}
