package com.reagroup.myaccount

import play.api.mvc.{Action, Controller}
import play.api.libs.json.JsError

/**
 * Created with IntelliJ IDEA.
 * User: steven_bearzatto
 * Date: 4/07/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
object Notifications extends Controller {
  def create(messageType: String) = Action(parse.json) { request =>
    Ok(request.body \ "message")
  }
}
