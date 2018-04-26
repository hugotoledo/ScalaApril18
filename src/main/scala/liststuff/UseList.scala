package liststuff

import scala.annotation.tailrec

object UseList {
  @tailrec
  def showList[T](l: List[T]) : Unit = l match {
    case Nil /* List() */ => ()
    case h :: t => println(h); showList(t)
  }

  @tailrec
  def processList[T](l: List[T])(implicit op: T => Unit) : Unit = l match {
//  def processList[T](l: List[T], op: T => Unit) : Unit = l match {
    case Nil /* List() */ => ()
    case h :: t => op(h); processList(t)
  }

  def main(args: Array[String]): Unit = {
    val l = List("Fred", "Jim", "Sheila")
    val h = l.head
    val t = l.tail
    println(s"head is $h, tail is $t")
    println("entire list is:")
    showList(l)

//    processList(l, (i: String) => println(s"an item is $i"))
    processList(l)(i => println(s"an item is $i"))
    implicit val op: String => Unit = x => println(s"An implicit?? x is $x")
    processList(l)

    println("------------------------")
    l.foreach(op)
    println("------------------------")
    l.
      filter(x => x.length > 3).
      foreach(op)
    println("------------------------")
    l.
      filter(x => x.length > 3).
      map(x => x.toUpperCase).
      foreach(op)
    println("------------------------")
    l.foreach(op)
    println("------------------------")
    l.
      filter(x => x.length > 3).
      map(x => x.toUpperCase).
      flatMap(x => x.toCharArray.map(y => "" + y)).
      foreach(op)
  }
}
