// #11 오버라이딩과 추상화(4)

package space.doky.ch11

fun main() {

  println("Overriding")
  var a = Animal1()
  a.eat()

  var b = Tiger()
  b.eat()

  println("Interface")
  var c = Lion()
  c.run()
  c.eat()
}

open class Animal1 {

  // 클래스와 마찬가지로 역시 open으로 열어야 override 가능!
  open fun eat() {
    println("eating...")
  }
}

// 1. overriding
class Tiger() : Animal1() {
  override fun eat() {
    println("meet...")
  }
}

// 2. abstraction
// 추상함수: 선언부만 있고 기능은 없는 함수
// 추상클래스: 추상함수를 포함하고 있음

// 추상 클래스의 경우, 추상함수를
// 상속받은 클래스에서 필수적으로 구현해야 함.
abstract class Animal2 {
  abstract fun eat()
  fun sniff() {
    println("cunk")
  }
}

class Rabbit : Animal2() {
  override fun eat() {
    println("eating carrot")
  }
}

// 3. Interface
// 다른언어: 순수 추상화 기능 (추상함수로만 이루어져 있음)
// 코틀린: 속성, 함수, 추상함수 다 가질 수 있음
//  - Interface: 생성자 X
//               구현부O: open
//               구현부X: abstract
//               -> 별도 키워드를 입력하지 않아도, 상속받는 클래스에서 전부 수정 가능!
//  - 한번에 여러 인터페이스를 상속받을 수 있음!

interface Runner {
  fun run()

  fun eat() {
    println("eating RUNNING...")
  }
}

interface Eater {
  fun eat() {
    println("eating...")
  }
}

class Lion : Runner, Eater {

  override fun run() {
    println("running...")
  }

  // 이런 식으로 기존 함수를 변경 가능
  override fun eat() {
    super<Eater>.eat()
    println("eating meat...")
  }
}

// *상속받는 클래스들에서 동일한 함수 이름/형태의 함수가 있다면
//  오버라이딩으로 수정해주어야 함
// *super의 경우, 제네릭을 사용해서 무슨 인터페이스를 상속받는지를 명시해주어야 함
