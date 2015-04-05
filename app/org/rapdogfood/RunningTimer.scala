package org.rapdogfood

class RunningTimer(startedAt:Long = System.currentTimeMillis()) extends Timer {

  /**
   * @return seconds counted since start
   */
  def runningFor:Long = (System.currentTimeMillis() - startedAt) / 1000

  def stoppedNow:Timer = new StoppedTimer(startedAt)

  def toPersistentString:String = "RunningTimer-" + startedAt

}


object RunningTimer {
  def fromPersistentString(str:String):Option[RunningTimer] = {
    val pattern = "RunningTimer-([0-9]+)".r
    pattern.findFirstMatchIn(str) match {
      case Some(m) => Some(new RunningTimer(m.group(1).toLong))
      case None    => None
    }
  }
}