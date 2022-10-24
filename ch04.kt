// #4 타입추론과 함수

package space.doky.ch04

fun main() {

  // 1. 타입추론
  var str1 = "asdf"
  var str2: String = "asdf"

  var arr1 = arrayOf(1, 2, 3)
  var arr2: Array<Int> = arrayOf(1, 2, 3)

  println(str1)
  println(str2)
  println(arr1)
  println(arr2)

  // -> 선언 시 할당된 값을 기반으로 타입을 추론함!
  // 단, 최초 결정된 타입은 변경이 불가함
  // str11 = 123 -> 에러

  // 2. 함수
  println(add1(2, 3, 4))
  println(add2(2, 3, 4))
}

// JS 함수 호이스팅처럼 반드시 맨 위에 할 필요는 없음
fun add1(a: Int, b: Int, c: Int): Int {
  return a + b + c
}

// 단일 표현식 함수
// 반환형 생략 가능!
fun add2(a: Int, b: Int, c: Int): Int = a + b + c

// 함수 -> 자료형이 결정된 변수의 느낌으로 보면 됨
// 함수형 언어!
