package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json
import play.api.libs.json.JsNull
import org.joda.time.DateTime

object Consumer extends Controller {
  def details(consumerId: String) = Action { request =>
    val results = Map(
      "count" -> Json.toJson(request.uri + "/count"),
      "recent" -> Json.toJson(request.uri + "/recent"))
    Ok(Json.toJson(results))
  }
  
  def count(consumerId: String) = Action(Ok(consumerId))

  def recent(consumerId: String) = Action { request =>
    val results = Seq(
        Json.toJson(
          Map(
            "creation" -> Json.toJson(DateTime.now.toString("YYYYMMdd HH:mmZ")),
            "expiry" -> Json.toJson(DateTime.now.toString("YYYYMMdd HH:mmZ")),
            "acknowledged" -> Json.toJson(true),
            "type" -> Json.toJson("PROPERTY_CHANGED"),
            "message" -> Json.toJson("Listing has been updated"),
            "body" -> Json.toJson("Some opaque structure that might differ depending on the message type"))),
        Json.toJson(
          Map(
            "creation" -> Json.toJson(DateTime.now.minusDays(2).toString("YYYYMMdd HH:mmZ")),
            "expiry" -> Json.toJson(DateTime.now.plusDays(1).toString("YYYYMMdd HH:mmZ")),
            "acknowledged" -> Json.toJson(false),
            "type" -> Json.toJson("PROPERTY_CHANGED"),
            "message" -> Json.toJson("Listing has been updated"),
            "body" -> Json.toJson("Some opaque structure")))
            )
    Ok(Json.toJson(results))
  }
}
