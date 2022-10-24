// #23. 함수의 argument를 다루는 방법과 infix 함수

package space.doky.ch23

fun main() {

  // 1. 함수 overloading
  // 자료형 or 개수가 다른 경우 다른 함수로 취급

  read(7)
  read("Hello")

  defaultArg("Tom")
  defaultArg("Tom", 10)
  defaultArg("Tom", 10, "School")

  // 3. named argument
  // defaultArg("Tom", , "School")  -> X
  // defaultArg("Tom", "School")    -> X
  defaultArg("Tom", dest = "School")

  // vararg
  sum(1, 2, 3, 4, 5)

  // infix func
  println(6 mult 4)
  println(6 mult (4))
}

fun read(x: Int) {
  println(x)
}

fun read(x: String) {
  println(x)
}

// 2. default arguments
// 파라미터의 기본값을 설정해주는 것.
fun defaultArg(name: String, count: Int = 1, dest: String = "House") {
  println("name: $name, count: $count, dest: $dest")
}

// 4. vararg (variable number of arguments)
// 개수 상관없이 파라미터를 받을 수 있음.
// 단, 다른 파라미터와 쓸 경우, 맨 마지막에 사용해야 함!
fun sum(vararg numbers: Int) {
  var sum = 0

  for (item in numbers) sum += item

  println(sum)
}

// 5. infix function
// 연산자처럼 사용할 수 있음.
infix fun Int.mult(x: Int): Int = this * x
//        함수가 적용될 자료형
//        -> 객체에서 infix func. 제작할 경우, 따로 작성하지 않아도 됨 (객체 자신이 자동으로 입력됨)
//                          반환타입
//                                연산될 내용
