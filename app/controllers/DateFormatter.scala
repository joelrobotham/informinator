package controllers

import play.api.libs.json.Json.toJson
import play.api.libs.json.JsValue
import play.api.libs.json.Format

import java.util.Date
import java.text.SimpleDateFormat

object DateFormatter {

  implicit object JsonDateFormatter extends Format[Option[Date]] {

    val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")

    def writes(date: Option[Date]): JsValue = {
      toJson(
        date.map(
          date => dateFormat.format(date)
        ).getOrElse(
        ""
      )
  )
   }
   def reads(j: JsValue): Option[Date] = {
     try {
       Some(dateFormat.parse(j.as[String]))
     } catch {
       case e => None
     }
   }

 }

                                                                        }

