package controllers

import play.api._
import play.api.mvc._
import org.joda.time.DateTime

object Application extends Controller {

  def index = Action {
    //computation here
    Ok(views.html.index("Hi, let's dogfood! :-)"))
  }

  def time = Action {
    val time = new DateTime()
    Ok(views.html.index(time.toString()))
  }
  
  // [] square brackets
  // () parenthesis
  // <> 
  // {} braces (curly brackets)

}