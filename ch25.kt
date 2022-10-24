// #25. Data Class와 Enum Class

package space.doky.ch25

fun main() {

  // 1. Data class
  // 5가지 기능을 내부적으로 자동생성해줌

  // equals()
  // hashcode(): 인스턴스 고유 hash 리턴
  // toString()
  // copy()    : 객체를 복사하여 리턴 / 일부 속성 변경 가능
  // componentX: 속성을 순서대로 리턴 component1(), component2() ...
  //             -> 배열/리스트에 클래스가 담긴 경우, 이를 자동으로 꺼내쓰기 위한 기능에서 사용

  val a = General("Tony", 212)
  println(a == General("Luda", 234))
  println(a.hashCode())
  println(a)
  println()

  val b = Data("Ken", 523)
  println(b == Data("Luda", 234))
  println(b.hashCode())
  println(b)
  println()

  println(b.copy())
  println(b.copy("Anna"))
  println(b.copy(id = 618))
  println()

  val list =
      listOf(
          Data("Tony", 212),
          Data("Anna", 123),
          Data("Ken", 563),
          // General("Ken", 563),
          // -> 얘는 componentX가 구현되어있지 않아 사용 X
          )

  for ((aa, bb) in list) {
    // 내부적으로는 component1, component2로 호출함!
    println("$aa, $bb")
  }
  println()

  // Enum
  var state = State.SING
  println(state)

  state = State.SLEEP
  println(state.isSleeping())

  state = State.EAT
  println(state.msg)
}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)

// 2. Enumerated Type
// 상태를 구분하기 위한 객체를 여러개 만들어두고 그 중 하나를 선택!
// 각 객체는 생성자를 통해 고유 속성/함수를 가질 수 있음

enum class State(val msg: String) {
  SING("Singing"),
  // EAT(2), -> X
  EAT("eating"),
  SLEEP("sleep");
  // 뒤에 함수 정의 시, 마지막 enum에는 ;을 붙여서 끝 표시를 해줌

  fun isSleeping() = this == State.SLEEP
}

// 위 두 클래스 형태는 일반 클래스에서 제공하지 않는 특정 기능을 제공함
