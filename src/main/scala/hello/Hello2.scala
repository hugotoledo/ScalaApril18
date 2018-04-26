package hello

// object defines a class, and makes ONE instance.
object Hello2 {
  // program entry point is called main
  // "Unit" means "returns nothing" like void in other languages
  // Unit has one singleton value ()
  // Scala uses square brackets for "generic type information"
  def main(args: Array[String]): Unit = {
//    val name: String = "Fred"
    // "type inferencing"
    var name = "Fred"
    name = "Jim" // reassignement permitted for var declaration but not for val
//    name = 3
    // Strictly println is a method on the Console object..
//    Console.println("Hello, world!")
    // But Console is already imported and "implicit"
    println("Hello, world!")
    // "Infix" format
    Console println "Hello, world!"
//    println "Hello, world!"
    // or for number type objects
    val sum = 1 + 2
    val sumAgain = (1).+(2)
    val pi = math.Pi

//    val text = "the value of sum is " + sum
//    val text = s"the value of sum is ${sum + 0}"
    val text = s"the value of sum is $sum"
    println(f"the value of pi is ${pi}%6.4f")
    print(
      """Hello there
        |this is several lines
        |of text
      """.stripMargin)
    val re = raw"\W+".r
  }
}

/*
// pretend javascript
var x = "Fred"
// OK to reassign to different type
x = 99
*/
