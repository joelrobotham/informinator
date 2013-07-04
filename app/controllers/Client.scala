package controllers

import play.api.mvc.{Controller, Action}
import views.html
import play.api.data.Form

/**
 * Created with IntelliJ IDEA.
 * User: steven_bearzatto
 * Date: 4/07/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
object Client extends Controller{
  def index = Action {
     Ok(html.client.index())
  }
}
