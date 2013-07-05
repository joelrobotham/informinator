package model

import play.api.Play.current
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoConnection
import se.radley.plugin.salat._
import salatcontext._
import java.util.Date
import java.lang.Boolean

case class Notification(_id: ObjectId = new ObjectId, 
  message: Option[String] = None,
  email: Option[String] = None,
  url: Option[String] = None,
  body: Option[String] = None,
  creation: Date = new Date() ,
  expiry: Option[Date] = None,
  acknowledged: java.lang.Boolean = false,
  msgType: String)

object NotificationDAO extends SalatDAO[Notification, String](collection = mongoCollection("notification_coll")) {
  def findByEmail(email: String) = find(MongoDBObject("email"->email, "acknowledged" -> false)).sort(orderBy = MongoDBObject("creation" -> -1)).toList
  def acknowledge(id: String) {
    val notification = findOne(MongoDBObject("_id"->new ObjectId(id)))
    val updatedNotification = new Notification(_id=notification.get._id, message=notification.get.message,
      email=notification.get.email,
      url=notification.get.url,
      body=notification.get.body,
      creation=notification.get.creation,
      expiry=notification.get.expiry, 
      acknowledged=true,
      msgType=notification.get.msgType)

    update(MongoDBObject("_id"-> new ObjectId(id)), updatedNotification, false, false, new WriteConcern)
  }
  def findByDistinctMsgType(messageType: String) = collection.distinct("msgType").toList
  def findByDistinctEmailByMsgType(messageType: String): List[String] = {
    val anyList = collection.distinct("email", MongoDBObject("msgType" -> messageType)).toList
    anyList.map(_.asInstanceOf[String])
  }

  def findAllByEmail(email: String) = find(MongoDBObject("email"->email)).sort(orderBy = MongoDBObject("creation" -> -1)).toList
}






