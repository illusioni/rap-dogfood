package org.rapdogfood

import scala.util.Random

class Timer {

  def start() = {
    println("Timer was started")
  }

  /**
   * @return the timer's up-time since it was started in seconds
   */
  def runningSince = {
    //TODO implement this
    new Random().nextInt(scala.math.pow(2, 16).toInt)
  }
}
