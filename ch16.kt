// #16. 오브젝트

package space.doky.ch16

fun main() {

  // 1. 오브젝트
  // 생성자 없이 직접 객체를 만들 수 있음
  // 클래스: 생성자를 통해 실제하는 인스턴스 객체를 만들어야 했음
  // 싱글톤 패턴을 언어적 치원에서 지원하는 것!!

  println(Counter)
  println(Counter.count)

  Counter.countUp()
  Counter.countUp()
  Counter.countUp()
  println(Counter.count)

  Counter.clear()
  println(Counter.count)
  println("========")

  var a = FoodPoll("AAA")
  var b = FoodPoll("BBB")

  a.vote()
  a.vote()
  b.vote()
  b.vote()
  b.vote()

  println(a.count)
  println(b.count)
  println(FoodPoll.total)
}

// 인스턴스를 생성하지 않기 때문에 생성자를 만들지는 않음
// -> 오브젝트 이름에 직접 참조연산자 사용 가능!
// -> 최초 사용 시 자동 생성되며, 프로그램 종료 전까지 지워지지 않음!
object Counter {
  var count = 0

  fun countUp() {
    count++
  }

  fun clear() {
    count = 0
  }
}

// 2. companion object
// 기존 클래스 안에 오브젝트를 생성할 수 있는 기능
// instance 간의 공용으로 사용할 수 있는 object를 의미
// 기존 언어의 static과 동일한 기능을 함!

class FoodPoll(val name: String) {
  companion object {
    var total = 0
  }

  var count = 0

  fun vote() {
    total++
    count++
  }
}
