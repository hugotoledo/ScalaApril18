package dates

import java.sql.SQLException

import scala.annotation.tailrec
import scala.util.Try

//class Date(d:Int, m: Int, y: Int) {
//  println(s"making a date with $d, $m, $y")
////  var day: Int = _
////  var month: Int = _
////  var year: Int = _
//  val day: Int = d
//  val month: Int = m
//  val year: Int = y
//}

class Date protected/*private*/(
    /*private */ val day:Int, val month: Int, val year: Int) {
  println(s"making a date with $day, $month, $year")
  @tailrec // not needed
  final def +/*addDays*/(days: Int): Date = {
    val daysInMonth = 31 // CHEATING!!!!
    val daysLeftInMonth = daysInMonth - day
    if (days <= daysLeftInMonth) new Date(day + days, month, year)
    else new Date(1, this.month + 1, this.year) + (days - daysLeftInMonth - 1)
  }

  def tomorrow: Date = this + 1
//  def tomorrow: Date = new Date(day + 1, month, year)
//  import Date._
  import Date.{dayName, getDayOfWeek}
  def dayOfWeek: String = dayName(getDayOfWeek(day, month, year))

  override def toString: String =
    s"Date representing $dayOfWeek $day/$month/$year"
}

object Date {
//  def makeADate(d: Int, m: Int, y: Int): Date = new Date(d,m,y)
  def apply(d: Int, m: Int, y: Int): Date = {
    if (d < 1 || m < 1 || y < 1) throw new RuntimeException("Bad values!")
    new Date(d,m,y)
  }

  def getDayOfWeek(day: Int, month: Int, year: Int): Int = {
    // if month < 3, calculate new month and year, being month + 12 and year - 1
    val (m, y) = if (month < 3) (month + 12, year - 1) else (month, year)
    (day + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y /400) % 7
  }

  def dayName(dNum: Int): String = dNum match {
    case 0 => "Saturday"
    case 1 => "Sunday"
    case 2 => "Monday"
    case 3 => "Tuesday"
    case 4 => "Wednesday"
    case 5 => "Thursday"
    case 6 => "Friday"
    case x => s"$x is not a meaningful weekday"
//    case _ => "BAD"
  }

  def monthName(idx: Int): String = // expression... blocks ARE expressions in Scala
    /*return */if (idx == 1) "January"
    else if (idx == 2) "February"
    else if (idx == 3) "March"
    else if (idx == 4) "April"
    else if (idx == 5) "May"
    else if (idx == 6) "June"
    else if (idx == 7) "July"
    else if (idx == 8) "August"
    else if (idx == 9) "September"
    else if (idx == 10) "October"
    else if (idx == 11) "November"
    else if (idx == 12) "December"
    else "BAD!!!"
}

class Holiday(d: Int, m: Int, y: Int, val name: String)
  extends Date(d/* + 1*/, m, y) {
  override def toString: String =
    super.toString + ", a holiday called " + name
}

object TryDate {
  def main(args: Array[String]): Unit = {
    val dow = Date.getDayOfWeek(26, 4, 2018)
    println(s"day is number $dow and is called ${Date.dayName(dow)}")
//    val d = new Date(26, 4, 2018)
//    val d = Date.makeADate(26, 4, 2018)
    val d = Date(26, 4, 2018)
    println(s"day is ${d}")
    println(s"tomorrow is ${d.tomorrow}")
    println(s"day is ${d}")

    println(s"class of d is ${d.getClass.getName} " +
      s"class of Date is ${Date.getClass.getName}")

    val waffleDay: Date = new Holiday(1, 2, 2018, "Waffle Day")
    println(s"waffle day is $waffleDay")
//    println(s"waffle day is $waffleDay and is called ${waffleDay.name}")

    val dateMaybe = Try(Date(1, -1, 1))
    dateMaybe.foreach(println(_))

    try {
      val d1 = Date(0, 1, 1)
      println(s"date is $d1")
    } catch {
      case _: SQLException => println("Really, got an SQL exception??")
      case x: RuntimeException => // case like this does "instanceof and cast"
        println(s"That didn't work, report is ${x.getMessage}")
    }

//    val inTwoMonths = d.+(62)
    val inTwoMonths = d + 62
    println(s"today: $d two months ish $inTwoMonths")
  }
}