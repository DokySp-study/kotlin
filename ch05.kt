// # 조건문과 비교연산자

package space.doky.ch05

fun main() {

  // 1. if statement
  var a = 7

  if (a > 10) {
    println("a > 10")
  } else if (a == 10) {
    println("a == 10")
  } else {
    println("a < 10")
  }

  // 2. is, !is 연산자
  // 해당 클래스가 맞는지 검사 (클래스에서 자세히 다룸)
  // 기본 자료형의 경우, 정적분석도구에 의해 걸러짐
  println(a is Int)
  // println(a is Double)

  // 3. when statement
  fun doWhen(a: Any): String { // Any -> 최상위 자료형 (모두 호환)
    when (a) {
      // 여러 조건문을 사용할 수 있음
      // 등호, 부등호 사용불가
      // 가장 먼저 만족하는 조건만 실행!
      1 -> {
        println("11: asdf")
        println("11: 123")
      }
      "Test" -> println("Test code")
      is Long -> println("Long type")
      !is Long -> println("Not Long type")
      else -> println("Not above")
    }

    // 표현식
    var res: String =
        when (a) {
          1 -> "val - 11: asdf"
          "Test" -> "val - Test code"
          is Long -> "val - Long type"
          !is Long -> "val - Not Long type"
          else -> "val - Not above"
        }

    return res
  }

  doWhen("1")
  doWhen(1)
  print(doWhen(1234L))
}
