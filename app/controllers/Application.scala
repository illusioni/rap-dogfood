package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object Application extends Controller {

  val dateFormatter = DateTimeFormat.forPattern("HH:mm:ss")

  def index = Action {
    //computation here
    Ok(views.html.index("Hi, let's dogfood! :-)"))
  }

  def time = Action {
    val time = new DateTime()
    Ok(views.html.index(dateFormatter.print(time)))
  }

  // [] square brackets
  // () parenthesis
  // <>
  // {} braces (curly brackets)

}