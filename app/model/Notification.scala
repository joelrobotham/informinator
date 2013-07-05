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
  def findByEmail(email: String) = find(MongoDBObject("email"->email, "acknowledged" -> false)).toList
  def acknowledge(id: String) = update(MongoDBObject("_id"-> new ObjectId(id)), MongoDBObject("acknowledged" -> true))
}






