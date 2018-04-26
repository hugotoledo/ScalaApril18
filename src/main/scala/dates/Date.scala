package dates

object Date {
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

object TryDate {
  def main(args: Array[String]): Unit = {
    val dow = Date.getDayOfWeek(26, 4, 2018)
    println(s"day is number $dow and is called ${Date.dayName(dow)}")
  }
}