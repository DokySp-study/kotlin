// #26. 컬랙션2, Set과 Map

package space.doky.ch26

fun main() {

  // 1. Set
  // 순서 없고 중복 허용이 되지 않음.
  // index로 접근 안되고 contains() 사용해야 함

  // Set<T>, MutableSet<T>

  // add(), remove()

  val a = mutableSetOf("A", "B", "C")

  for (item in a) println("$item")

  a.add("D")
  println(a)

  a.remove("B")
  println(a)

  // 없으면 무시
  a.remove("b")
  println(a)

  println(a.contains("A"))
  println(a.contains("E"))

  // 2. Map
  // key-value 형태 데이터
  // MutableMap.MutableEntry 구조

  // Map, MutableMap
  // put(), remove()

  val map =
      mutableMapOf(
          123 to "aaa",
          234 to "bbb",
          345 to "ccc",
      )

  for (entry in map) println("${entry.key} - ${entry.value}")

  map.put(456, "ddd")
  println(map)

  map.remove(123)
  println(map)

  println(map[234])
  println(map[123]) // 값이 없는 경우, null 반환
}
