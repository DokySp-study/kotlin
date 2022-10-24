// #9 클래스의 생성자(2)

package space.doky.ch09

fun main() {

  var a: Person = Person("name", 1231)
  a.name

  var b: Person = Person("name")
  println("${b.name}, ${b.birth}")
}

// 1. 기본 생성자
// 아래 소괄호 안에 내용이 생성자이다.
//  1) 인스턴스 초기화 및 필요 기능 추가
//  2) constructor -> init {} 으로 작성
class Person(var name: String, val birth: Int) {

  init {
    println("constructor")
  }

  // 2. 보조 생성자
  // - 아래와 같이 생성자 파라미터를 두개가 아닌
  //   이름만 받는 새로운 생성자를 둘 수 있음.
  // - 단, 기본 생성자 이후 보조 생성자가 실행됨을 인지할 것.
  // - this: 자기 자신 인스턴스를 가리키는 것
  constructor(name: String) : this(name, 1997) {
    println("sec constr.")
  }
}
