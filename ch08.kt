// #8 클래스의 기본구조(1)

package space.doky.ch08

fun main() {

  // 2. 인스턴스 생성

  var p1 = Person("Hong", 1942)
  var p2 = Person("Tony", 1996)
  var p3 = Person("Park", 1512)

  p1.introduce()
  println(p2.name)
  println(p3.birth)
}

// 클래스 구현
// 1. 아래와 같이 작성하면 property만 가지는 객체 생성 가능
// class Person(var name: String, val birth: Int)

class Person(var name: String, val birth: Int) {
  fun introduce() {
    println("p1: ${this.name}, ${this.birth}")
  }
}
