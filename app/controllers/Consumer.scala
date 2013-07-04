package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json
import play.api.libs.json.JsNull
import org.joda.time.DateTime
import model.NotificationDAO
import model.Notification

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
    val json = NotificationDAO.findByEmail(consumerId)
    	.map((notify => Map(
    			"message" -> notify.message,
    			"body" -> notify.body,
    			"url" -> notify.url)));
    
    Ok(Json.toJson(json)).withHeaders(
      "Access-Control-Allow-Origin" -> "*",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Host, Api-Token"
    )
    
  }
}
