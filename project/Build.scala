import sbt._
import Keys._
import play.Project._
 
object ApplicationBuild extends Build {
 
  val appName         = "MyAccount"
  val appVersion      = "0.1"
  val appDependencies = List(
      "mysql" % "mysql-connector-java" % "5.1.6",
      "com.github.nscala-time" %% "nscala-time" % "0.4.2",
      "org.mongodb" %% "casbah" % "2.6.2",
      "com.novus" %% "salat" % "1.9.2-SNAPSHOT")
 
  val main = play.Project(
    appName, appVersion, appDependencies).settings(
	    routesImport += "se.radley.plugin.salat.Binders._",
	    templatesImport += "org.bson.types.ObjectId",
	    resolvers += Resolver.sonatypeRepo("snapshots")
    )
 
  /*   val main = play.Project(appName, appVersion, appDependencies).settings(
    routesImport += "se.radley.plugin.salat.Binders._",
    templatesImport += "org.bson.types.ObjectId",
      resolvers += Resolver.sonatypeRepo("snapshots")
     )*/
}
