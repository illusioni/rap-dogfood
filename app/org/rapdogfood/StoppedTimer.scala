package org.rapdogfood

class StoppedTimer(startedAt:Long = System.currentTimeMillis(), stoppedAt:Long = System.currentTimeMillis()) extends Timer {

  /**
   * @return seconds counted since start
   */
  def overallTime:Long = (stoppedAt - startedAt) / 1000

  def toPersistentString = "StoppedTimer-" + startedAt + "-" + stoppedAt

}


object StoppedTimer {
  def fromPersistentString(str:String):Option[StoppedTimer] = {
    val pattern = "StoppedTimer-([0-9]+)-([0-9]+)".r
    pattern.findFirstMatchIn(str) match {
      case Some(m) => Some(new StoppedTimer(m.group(1).toLong, m.group(2).toLong))
      case None    => None
    }
  }
}