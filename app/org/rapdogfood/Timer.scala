package org.rapdogfood

abstract class Timer {

  def toPersistentString:String

}


object Timer {

  def startNew:Timer = {
    new RunningTimer
  }

  def fromPersistentString(str:String):Timer = {
    RunningTimer.fromPersistentString(str).getOrElse(StoppedTimer.fromPersistentString(str).get)
  }

}