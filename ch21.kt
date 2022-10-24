// #21. 문자열을 다루는 법

package space.doky.ch21

fun main() {

  // 1) 기본 기능
  val test1 = "Literal.Test.String"

  println(test1.length)

  println(test1.lowercase())
  println(test1.uppercase())

  // 자바와 달리, split에 일반 텍스트를 넣어도 동작함
  val test2 = test1.split(".")
  println(test2)

  println(test2.joinToString())
  println(test2.joinToString("-"))

  println(test1.substring(0..3))
  println()

  // ------------------------------------------

  // 2) 문자열이 비어있는지 확인해보기
  val nullString: String? = null
  val emptyString = ""
  val blankString = " "
  val normalString = "A"

  println(nullString.isNullOrEmpty())
  println(emptyString.isNullOrEmpty())
  println(blankString.isNullOrEmpty())
  println(normalString.isNullOrEmpty())
  println()

  // 공백문자만 있을 경우도 empty로 표시
  // space, tab, CR, LF
  println(nullString.isNullOrBlank())
  println(emptyString.isNullOrBlank())
  println(blankString.isNullOrBlank())
  println(normalString.isNullOrBlank())
  println()

  // ------------------------------------------

  // 3) 특정 문자열 찾기
  var test3 = "kotlin.kt"
  var test4 = "java.java"

  println(test3.startsWith("java"))
  println(test4.startsWith("java"))

  println(test3.endsWith(".kt"))
  println(test4.endsWith(".kt"))

  println(test3.contains("lin"))
  println(test4.contains("lin"))
}
