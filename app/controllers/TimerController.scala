package controllers

import play.api.mvc._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.rapdogfood.{StoppedTimer, RunningTimer, Timer}
import views.html.time

object TimerController extends Controller {

  val COOKIE_NAME = "timer"

  def timerStatus = Action { implicit request =>
    request.cookies.get(COOKIE_NAME) match {
      case Some(cookie) => {
        val timer = Timer.fromPersistentString(cookie.value)
        Ok(views.html.timerStatus(timer))
      }
      case None => Ok(views.html.timerStatusNoTimer())
    }
  }

  def startTimer = Action {
    val timer = Timer.startNew
    Ok(views.html.timerStatus(timer)).withCookies(Cookie(COOKIE_NAME, timer.toPersistentString))
  }

  def stopTimer = Action { implicit request =>
    request.cookies.get(COOKIE_NAME) match {
      case Some(cookie) => {
        val timer = Timer.fromPersistentString(cookie.value)
        timer match {
          case rt:RunningTimer => {
            val stoppedTimer = rt.stoppedNow
            Ok(views.html.timerStatus(stoppedTimer)).withCookies(Cookie(COOKIE_NAME, stoppedTimer.toPersistentString))
          }
          case st:StoppedTimer => {
            Ok(views.html.timerStatus(st))
          }
        }
      }
      case None => Ok(views.html.timerStatusNoTimer())
    }
  }

}