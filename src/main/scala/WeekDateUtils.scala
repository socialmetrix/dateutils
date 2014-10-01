import org.joda.time.format._
import org.joda.time._
import WeekDateUtils._

object WeekDateUtils {
  val fmtWeek = DateTimeFormat.forPattern("yyyy'w'ww")
  val fmtDate = DateTimeFormat.forPattern("yyyy-MM-dd")
}

object Week2Date extends App {
  if (args.size != 1) {
    println("Usage: Week2Date yyyy'w'ww")
    println("	Week2Date 2014w30")
    sys.exit(1)
  }

  val input = args(0)

  val initialDate = fmtWeek.parseDateTime(input).withZoneRetainFields(DateTimeZone.UTC)
  val finalDate = initialDate.plusWeeks(1).minusSeconds(1).withZoneRetainFields(DateTimeZone.UTC)

  print(s"${input}")
  print(" " * 7)
  print(s"${initialDate.toDateTimeISO}")
  print(" " * 7)
  print(s"${finalDate.toDateTimeISO}")
  println
}

object Date2Week extends App {
  if (args.size != 1) {
    println("Usage: Date2Week yyyy-mm-dd")
    println("	Date2Week 2014-08-30")
    sys.exit(1)
  }

  val input = args(0)

  val initialDate = fmtDate.parseDateTime(input).withZoneRetainFields(DateTimeZone.UTC)
  val weekDate = fmtWeek.print(initialDate)

  print(s"${input}")
  print(" " * 7)
  print(s"${weekDate}")
  println
}