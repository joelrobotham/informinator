package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.JsError
import play.api.libs.json.Json
import model.Notification
import model.NotificationDAO
/**
 * Created with IntelliJ IDEA.
 * User: steven_bearzatto
 * Date: 4/07/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
object Notifications extends Controller {
  def create(messageType: String) = Action(parse.json) { 
    request =>
    val notification = new Notification(Json.stringify(request.body\"email"), Json.stringify(request.body\"message"))
    val id = NotificationDAO.insert(notification)
    Ok("test")
  }
}
