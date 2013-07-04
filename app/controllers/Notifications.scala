package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.JsError
import play.api.libs.json.Json
import model.Notification
import model.NotificationDAO
import views.html

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
    val notification = new Notification(email=(request.body\"email").asOpt[String], message=(request.body\"message").asOpt[String], msgType=messageType, url=(request.body\"url").asOpt[String], body=(request.body\"body").asOpt[String])
    val id = NotificationDAO.insert(notification)
    Ok("test")
  }

  def index(email: String) = Action {
    //val notifications = Array(new Notification("safdjk", "A message"), new Notification("safdjk", "2 message"))
    
	//def findOneByEmail(notificationId: String): Option[Notification] = dao.findOne(MongoDBObject("notificationId" -> notificationId))
    //Ok(html.notifications.index(email, notifications))
  Ok("test")
  }
}
