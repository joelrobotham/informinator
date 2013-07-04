package com.reagroup.notification

import play.api.mvc.Controller
import play.api.mvc.Action
import play.api.libs.json.Json
import play.api.libs.json.JsNull

object Consumer extends Controller {
  def details(consumerId: String) = Action { request =>
    val results = Map(
      "count" -> Json.toJson(request.uri + "/count"),
      "recent" -> Json.toJson(request.uri + "/recent"))
    Ok(Json.toJson(results))
  }
  
  def count(consumerId: String) = Action(Ok(consumerId))

  def recent(consumerId: String) = Action { request =>
    val results = Map(
      "users" -> Seq(
        Json.toJson(
          Map(
            "name" -> Json.toJson("Bob"),
            "age" -> Json.toJson(31),
            "email" ->Json.toJson("bob@gmail.com"))),
        Json.toJson(
          Map(
            "name" -> Json.toJson("Kiki"),
            "age" -> Json.toJson(25),
            "email" -> JsNull))))
    Ok(Json.toJson(results))
  }
}
