import sbt._
import Keys._
import play.Project._
 
object ApplicationBuild extends Build {
 
  val appName         = "MyAccount"
  val appVersion      = "0.1"
  val appDependencies = List(
      "mysql" % "mysql-connector-java" % "5.1.6")
 
  val main = play.Project(
    appName, appVersion, appDependencies) 
 
}
