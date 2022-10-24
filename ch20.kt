// #20. 리스트

package space.doky.ch20

fun main() {

  // 1. 리스트
  // 데이터 모아 관리하는 Collection 상속받음
  // 제일 단순한 형태 (Set, Map 도 존재)

  // List<out T>      : 생성 시 넣은 객체를... 대체/추가/삭제 불가
  // MutableList<T>   :         ..                  ..      가능

  // 1) 리스트 생성
  // listOf("a", "b", "c")
  // mutableListOf(1,2,3)

  val a = listOf(1, 2, 3)
  println(a)
  println(a[1])

  for (i in a) {
    print(i)
  }

  // a[1] = 3 // Error
  println()

  // 2) mutable list
  // add, remove, removeAt, shuffle, sort 등의 기능 사용
  // 각 아이템을 수정할 수도 있음!

  var b = mutableListOf(6, 3, 1)
  println(b)

  b.add(4)
  println(b)

  b.add(2, 8)
  println(b)

  b.removeAt(1)
  println(b)

  b.shuffle()
  println(b)

  b.sort()
  println(b)

  b[1] = 100
  println(b)
}
