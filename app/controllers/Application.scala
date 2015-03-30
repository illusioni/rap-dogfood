package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object Application extends Controller {

  val dateFormatter = DateTimeFormat.forPattern("HH:mm:ss")
  val randomNumberGenerator = new scala.util.Random

    def index = Action {
    //computation here
    Ok(views.html.index("Hi, let's dogfood! :-)"))
  }

  def kibbles = Action {
    Ok(views.html.kibbles("Some kibbles (i.e. bits of the dogfood app) will go here."))
  }

  def time = Action {
    val time = new DateTime()
    Ok(views.html.time(dateFormatter.print(time)))
  }

  def jbs = Action {
    //Jeremy's page which displays a random number between 0 and 'randomCeiling'
    val randomCeiling = scala.math.pow(2, 16).toInt
    Ok(views.html.jbs(randomNumberGenerator.nextInt(randomCeiling).toString()))
  }

  // () parentheses
  // [] (square) brackets
  // {} braces (curly brackets)
  // <> chevrons (angle brackets)

}