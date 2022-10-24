// #10 클래스의 상속(3)

package space.doky.ch10

fun main() {

  var a = Animal("Startrek", 12, "CAT")
  var b = Dog("Bee", 13)

  a.introduce()
  b.introduce()

  b.bark()

  var c = Cat("name", 13)
  c.meow()
}

// 1. 상속
// super class -> sub class
// 규칙 1. super 클래스에 있는 proerty 이름으로 동일하게 자식에서 선언할 수 없음.
// 규칙 2. sub 클래스 생성 시, super 클래스의 생성자도 호출

// *코틀린은 기본적으로 모든 class가 final이다. (상속 금지가 디폴트)
//  따라서, open으로 상속을 허용하는 키워드를 적어야 한다.
//  - https://marlboroyw.tistory.com/497

// 상속 -> 구조화 면에서 장점이지만, 남용할 경우, 구조가 오히려 복잡해질 수 있음

open class Animal(var name: String, var age: Int, var type: String) {
  fun introduce() {
    println("type: ${type}, name: ${name}, age: ${age}")
  }
}

// Dog가 Animal을 상속받음
class Dog(name: String, age: Int) : Animal(name, age, "DOG") {
  fun bark() {
    println("Woof")
  }
}

// Cat가 Animal을 상속받음
class Cat(name: String, age: Int) : Animal(name, age, "CAT") {
  fun meow() {
    println("Meow")
  }
}
