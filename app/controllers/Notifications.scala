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
  
  def createMessageTypeNotifications(messageType: String) = Action(parse.json) {
    request =>
    val subscribers = NotificationDAO.findByDistinctEmailByMsgType(messageType)
    
    for( subscriber <- subscribers ){
    	val notification = new Notification(email=Some(subscriber), message=(request.body\"message").asOpt[String], msgType=messageType, url=(request.body\"url").asOpt[String], body=(request.body\"body").asOpt[String])
    	val id = NotificationDAO.insert(notification)
    }   
    Ok("test")
  }

  def index(email: String) = Action {
    val notifications = NotificationDAO.findByEmail(email)
    Ok(html.notifications.index(email,notifications))
  }
  
  def msgTypeSubscribers(messageType: String) = Action {
    val subscribers = NotificationDAO.findByDistinctEmailByMsgType(messageType)
    Ok(html.notifications.subscribers(messageType, subscribers))
  }
}
