import org.rapdogfood._

val t1 = Timer.startNew

t1 match {
  case rt:RunningTimer => print("Timer has been running for " + rt.runningFor + " seconds")
  case _               => print("This was unexpected :-(")
}


t1 match {
  case rt:RunningTimer => {
    val t2 = rt.stoppedNow
    t2 match {
      case st:StoppedTimer => print("Stopped timer has counted " + st.overallTime + " seconds overall")
      case _               => print("We expected a stopped timer here")
    }
  }
  case _ => print("This was unexpected :-(")
}



val rt:RunningTimer = Timer.startNew.asInstanceOf[RunningTimer]
val rtPersisted = rt.toPersistentString
RunningTimer.fromPersistentString(rtPersisted)
StoppedTimer.fromPersistentString(rtPersisted)

Timer.fromPersistentString(rtPersisted)

