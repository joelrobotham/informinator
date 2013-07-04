package controllers

import play.api.mvc.Controller
import play.api.mvc.Action
import com.mongodb.casbah.Imports._

object HelloWorld extends Controller {
  
  val mongoClient = MongoClient("localhost", 27017)
  val db = mongoClient("test")
  val coll = db("test")
  var count = coll.count()
  
  // Push something into mongodb
  if ( count == 0 ) {
	  val a = MongoDBObject("hello" -> "world")
	  val b = MongoDBObject("language" -> "scala")
	
	  coll.insert( a )
	  coll.insert( b )
  }
  count = coll.count()
  
  val hello = Action(Ok("Hello world - mongo collection count: " + count))
}