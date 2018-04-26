package hello

object TrySomeLoops {
  def main(args: Array[String]): Unit = {
    var x = 0
    while (x < 10) {
      println(s"x is $x")
      x += 1
    }

    println("---------------------")
    for {
      x <- 0 to 10 by 2
    } {
      println(s"x is $x")
    }

    val result = for {
      x <- 0 to 10
      if x % 3 == 0
      y <- 0 to x
    } yield (x, y)

    val len = result.length
    var idx = 0;
    while (idx < len) {
      println(s"> ${result(idx)}")
      idx += 1
    }
  }
}
