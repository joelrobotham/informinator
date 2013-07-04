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

case class Notification(_id: ObjectId = new ObjectId, 
  message: Option[String] = None,
  email: Option[String] = None,
  url: Option[String] = None,
  body: Option[String] = None,
  msgType: String)

object NotificationDAO extends SalatDAO[Notification, String](collection = mongoCollection("notification_coll")) {}






