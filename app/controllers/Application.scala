package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.rapdogfood.Timer

object Application extends Controller {

  val dateFormatter = DateTimeFormat.forPattern("HH:mm:ss")
  val randomNumberGenerator = new scala.util.Random

    def index = Action {
    //computation here
    Ok(views.html.index("Hi, let's dogfood! :-)"))
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

  def startTimer = Action {
    //"timer" is the model
    val timer = new Timer()
    Ok(views.html.timerStatus(timer))
  }


  // () parentheses
  // [] (square) brackets
  // {} braces (curly brackets)
  // <> chevrons (angle brackets)

}