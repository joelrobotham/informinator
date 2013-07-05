package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json
import model.{Notification, NotificationDAO}
import java.text.SimpleDateFormat

object Consumer extends Controller {
  def details(consumerId: String) = Action { request =>
    val results = Map(
      "count" -> Json.toJson(request.uri + "/count"),
      "recent" -> Json.toJson(request.uri + "/recent"))
    Ok(Json.toJson(results))
  }
  
  def count(consumerId: String) = Action (
  
		  Ok(NotificationDAO.findByEmail(consumerId).length.toString).withHeaders(
      "Access-Control-Allow-Origin" -> "*",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Host, Api-Token"
    )
)

  def recent(consumerId: String) = Action { request =>
    val json = NotificationDAO.findByEmail(consumerId)
    	.map(jsonMapper());
    
    Ok(Json.toJson(json)).withHeaders(
      "Access-Control-Allow-Origin" -> "*",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Host, Api-Token"
    )
  }

  def all(consumerId: String) = Action { request =>
    val json = NotificationDAO.findAllByEmail(consumerId)
      .map(jsonMapper());

    Ok(Json.toJson(json)).withHeaders(
      "Access-Control-Allow-Origin" -> "*",
      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Host, Api-Token"
    )
  }

  def jsonMapper(): (Notification) => Map[String, Option[String]] = {
    val dateFormat = new SimpleDateFormat("d MMMM yyyy hh:mm")
    (notify => Map(
      "id" -> Some(notify._id.toString),
      "message" -> notify.message,
      "body" -> notify.body,
      "creation" -> Some(dateFormat.format(notify.creation)),
      "acknowledged" -> Some(notify.acknowledged.toString),
      "url" -> notify.url))
  }
}
