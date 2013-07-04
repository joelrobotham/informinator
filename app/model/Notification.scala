import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoConnection

case class Notification(@Key("notificationId") id: String, message: String)

object NotificationDAO extends SalatDAO[Notification, String] (collection = MongoConnection() ("notification_db")("notification_coll"))



