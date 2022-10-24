// #18. 클래스의 다형성

package space.doky.ch18

fun main() {

  // 1. 다형성
  // 콜라를 음료라고 볼 수도 있다
  // 상위 개념의 클래스로도 자식 클래스를 볼 수도 있게 하는 것
  // Up-Casting   -> var a: Beverage = Cola()
  // Down-Casting -> var a: Cola = Beverage()
  //                 (X) => 캐스팅 연산자 필요!

  // as 호환되는 자료형으로 변형해줌
  // is 자료형 변환 전 검사 코드 실행

  var a = Beverage()
  a.drink()

  var b: Beverage = Coke()
  b.drink()

  // * "업캐스팅"되었기 때문에 호출이 불가함
  // b.washDishes()

  // 1) is 연산자
  println(b is Coke)

  if (b is Coke) {
    b.washDishes()
    // b가 Coke일 경우 조건문 실행
    // 조건문 안에서는 b가 Coke로 다운캐스팅 됨!
  }

  // 2) as 연산자
  var c = b as Coke
  b.washDishes()
  c.washDishes()
  // as 연산자 사용 시, 바로 b도 바뀌고,
  // 바뀐 타입의 인스턴스를 리턴도 해줌!

  // 정리
  // Super class가 같은 클래스들을 관리
  // 인터페이스 구현 시에도 사용?

}

open class Beverage {
  var name = "Bev."

  open fun drink() {
    println("Drink $name")
  }
}

class Coke : Beverage() {

  var type = "Coke"

  override fun drink() {
    println("Drink Bev. (${type})")
  }

  fun washDishes() {
    println("Wash dishes with ${type}")
  }
}
