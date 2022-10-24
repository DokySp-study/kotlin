// #17. 익명객체와 옵저버 패턴

package space.doky.ch17

fun main() {

  EventPrinter().start()
  println()
  EventPrinter2().start()
}

// 1. 옵저버 패턴
// 1) 개념
// 특정 이벤트가 일어나는 것을 감시하는 감시자
// ex> 안드로이드 키 입력, 데이터 들어옴 등등...
//     여러 이벤트가 들어오고 이에 대해 반응하도록 함
//
// 2) 구조
// 이벤트 수신부, 이벤트 발생 및 전달부
// 이벤트 수신부에서 버튼을 생성하게 되면...
// -> 수신부에서 버튼에 참조 가능하지만, 버튼에서는 수신부 참조가 안됨 => 전달할 방법이 없음!
//
// 버튼이 Interface를 끼워넣어 공개 -> 이벤트 수신부에서 이를 구현하면, 버튼이 구현된 것을 사용하는 형태로 사용 가능! (Flutter 에서 많이 사용했던 패턴)
// 인터페이스 -> observer, listener
// 이벤트를 넘기는 것 -> callback

interface EventListener {
  fun onEvent(count: Int)
}

// 버튼 역할
class Counter(var listener: EventListener) {

  fun count() {
    for (i in 1..100) {
      if (i % 5 == 0) listener.onEvent(i)
    }
  }
}

// 버튼 끌어다 쓰는 역할
class EventPrinter : EventListener {
  override fun onEvent(count: Int) {
    print("${count}-")
  }

  fun start() {
    val counter = Counter(this)
    counter.count()
  }
}

class EventPrinter2 {

  fun start() {
    val counter =
        Counter(
            // 2. 익명 객체
            // 이런 식으로 익명 객체를 넘길 수도 있음!
            object : EventListener {
              override fun onEvent(count: Int) {
                print("${count}-")
              }
            }
        )
    counter.count()
  }
}
