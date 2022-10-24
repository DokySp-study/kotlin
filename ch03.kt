// #3 형변환과 배열

package space.doky.ch03

fun main() {

  // 1. 형변환(Type casting)
  // 기본 자료형들은 "형변환함수"를 지원함

  var a: Int = 123
  var b: Long = 456

  // a = b
  // error: type mismatch:
  // inferred type is Long but Int was expected\
  // -> 암묵적 형변환 지원 X
  // -> 명시적 형병환만 지원함!
  a = b.toInt()

  print(a)

  // 2. 배열

  // 배열 만들기
  var arr = arrayOf(1, 2, 3)

  // 빈 배열 만들기
  var arrN = arrayOfNulls<Int>(5)

  print(arr[0])
  print(arrN[0])

  // 배열의 크기는 변경할 수 없다.

}
