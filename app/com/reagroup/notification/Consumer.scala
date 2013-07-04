package com.reagroup.notification

import play.api.mvc.Controller
import play.api.mvc.Action

object Consumer extends Controller {
  def count(consumerId: String) = Action(Ok(consumerId))
}
