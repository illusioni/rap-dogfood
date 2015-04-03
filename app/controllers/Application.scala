package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class BasicTimer {
  var message = ""
  def reset() {message = "Please give this timer a try!"}
  def start() {message = "Timer started, now get to work!"}
  def pause() {message = "Timer paused. Enjoy your break."}
  def check = message
}

object Application extends Controller {

  def index = Action {
    //computation here
    Ok(views.html.index("Hi, let's dogfood! :-)"))
  }

  val myTimer = new BasicTimer

  def kibbles = Action {
    myTimer.reset()
    Ok(views.html.kibbles(myTimer.check))
  }

  def startTimer = Action {
    myTimer.start()
    Ok(views.html.kibbles(myTimer.check))
  }

  def pauseTimer = Action {
    myTimer.pause()
    Ok(views.html.kibbles(myTimer.check))
  }


  val dateFormatter = DateTimeFormat.forPattern("HH:mm:ss")

  def time = Action {
    val time = new DateTime()
    Ok(views.html.time(dateFormatter.print(time)))
  }


  val randomNumberGenerator = new scala.util.Random

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