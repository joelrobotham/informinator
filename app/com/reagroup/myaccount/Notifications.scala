package com.reagroup.myaccount

import play.api.mvc.{Action, Controller}

/**
 * Created with IntelliJ IDEA.
 * User: steven_bearzatto
 * Date: 4/07/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
object Notifications extends Controller {
  def create(messageType: String) = Action {
    Ok("It works " + messageType)
  }
}
