// #30. 비트연산

package space.doky.ch30

fun main() {

  // 1. 비트연산
  // 2진법 연산 기술
  // shift 연산 등
  // 비트 단위로 저장하여 경제성을 높이는 방법으로 많이 사용
  // ex> 앞 7비트 / 뒤 25비트 나누어서 저장 등
  // ex> 플래그 값(0, 1) 처리 / 네트워크 프로토콜 데이터 양 최적화 등

  // 코틀린은 모든 자료형이 signed임 -> 최상위 비트가 항상 부호비트!!

  // bitwise shift op.
  // shl shr : 부호비트 제외 좌우로 밀어줌
  // ushr    : 부호비트 포함 우측으로 밀어줌

  // bitwise op.
  // and: 원하는 위치 비트 확인, 0으로 만들 때 (clear)
  // or : 비트를 1로 만들 때 (set)
  // xor: 비교할 두 값이 비트별로 동일한지 확인
  // inv(): 비트 반전

  var bitData: Int = 0b10000

  // 1 shl 2 => 0b100
  // or연산: 3번째 bit가 set됨!
  bitData = bitData or (1 shl 2)

  println(bitData)
  println(bitData.toString(2)) // 2..36 진수로 표현 가능
  println()

  var result = bitData and (1 shl 4)
  println(result.toString(2))
  println()

  println(result shr 4)
  println()

  // 4번째 1 clear
  bitData = bitData and ((1 shl 4).inv()) // 0b01111
  println(bitData.toString(2))
  println()

  println(bitData.toString(2))
  println(0b10100.toString(2))
  println((bitData xor (0b10100)).toString(2))
  // 10100, 100 은 10000 비트가 다름!
  println()

  // 비트 연산 -> 특수한 경우에 많이 사용

}
