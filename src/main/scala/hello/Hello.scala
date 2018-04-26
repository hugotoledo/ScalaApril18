package hello

import java.time.LocalDate

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    // val is "immutable" value...
    // literally **names** cannot be reassigned
    // my array is NOT immutable
    val names: Array[String] = new Array(3)
    println(s"size of array is ${names.length}")
    println(s"element zero is ${names(0)}")
//    names = new Array(2)

//    names(0) = "Albert"
    names.update(0, "Albert")
    names(1) = "James"
    println(s"element zero is ${names.apply(0)}")
    println(s"element one is ${names(1)}")

    val moreNames = Array/*.apply*/("Fred", "Jim", "Sheila")
    println(s"element one of moreNames is ${moreNames(1)}")

    val threeThings = (1, "Banana", LocalDate.now())
    println(s"date part is ${threeThings._3}")
    val (n, m, _) = threeThings
    println(s"thing part is $m")

  }
}
