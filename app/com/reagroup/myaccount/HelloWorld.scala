package com.reagroup.myaccount

import play.api.mvc.Controller
import play.api.mvc.Action

object HelloWorld extends Controller {
  val hello = Action(Ok("Hello world!"))
}