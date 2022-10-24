// #27. 컬랙션 함수 #1

package space.doky.ch27

fun main() {

  // 컬렉션에 사용할 수 있는 유용한 함수들

  // 1. 컬랙션 함수
  // for문으로 컬랙션의 아이템을 꺼내어 사용할 수 있음.
  // 코틀린은 함수형 언어이므로, 컬랙션 함수를 사용하여 더욱 다양하게 사용 가능

  // 예시>
  // collection = [1,2,3]
  //
  // collection.forEach {
  //     println(it)
  // }
  // => 1,2,3 출력
  //
  // collection.filter {
  //     it < 4
  // }
  // => 1,2 콜랙션 반환
  //
  // collection.map {
  //     it * 2
  // }
  // => 2,4,6 콜랙션 반환

  // any { it == 0 }  : 하나라도 조건 맞으면 true
  // all { it == 0 }  : 모두 조건 맞아야 true
  // none { it == 0 } : 모두가 조건 맞지 않으면 true

  // first()     : 첫번째 아이템 반환
  // first { it > 3 } : 조건에 맞는 첫번째 아이템 반환
  // find()

  // last()     : 뒤에서부터 첫번째 아이템 반환
  // last { it > 3 } : 뒤에서부터 조건에 맞는 첫번째 아이템 반환
  // findLast()

  // *NoSuchElementError
  // firstOrNull(), lastOrNull() -> 해당 객체 없는경우 null

  // count { it > 7 } : 조건에 맞는 아이템 개수 반환

  // **이렇게 컬랙션 함수 사용 시, 조건/반복문을 줄일 수 있음!!**

  val nameList = listOf("Ae", "Bc", "Ac", "De", "Be")

  nameList.forEach({ print(it + " ") })
  // -> 소괄호는 생략 가능!

  println()
  println(nameList.filter { it.startsWith("A") })
  println(nameList.map { "name: " + it })

  println(nameList.any { it == "Ac" })
  println(nameList.all { it.length == 2 })
  println(nameList.none { it.startsWith("D") })

  println(nameList.first { it.startsWith("B") })
  println(nameList.last { it.startsWith("B") })

  println(nameList.count { it.contains("c") })
}
