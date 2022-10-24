// #19. 제너릭

package space.doky.ch19

fun main() {

  // 1. 제너릭
  // 클래스 외부에서 내부 자료형을 지정해주는 기능

  // B가 A를 상속했다고 가정 시,
  // fun castingExample(var a: A){}
  // castingExample(B())
  // -> 코드 실행 가능!
  //    캐스팅 연산 -> 프로그램 속도 저하 원인!

  // 타입 파라미터<T,U,V>로 받아서 타입을 받아 사용!
  // 특정 super class로 제한 시, <T:SuperCalssName> 이렇게 사용

  // 함수에 제너릭을 사용한 경우,
  // fun <T> aaa(var param: T) {}
  // aaa(1)
  // -> 자동으로 Int로 타입추론해줌

  // 클래스에 제너릭을 사용한 경우,
  // class AAA<T>
  // AAA<Int>() // 수동지정

  // class BBB<T>(var pref:T) // 생성자에 제너릭 사용된 경우
  // BBB(1)                   // 지정하지 않아도 자동으로 추론됨!

  // 1) 클래스 제너릭
  UsingGeneric(A()).doShout() // 아래와 같이 사용 가능하지만, 생성자에 있는 A() 를 통해 타입추론됨!
  UsingGeneric<A>(A()).doShout()

  UsingGeneric(B()).doShout()
  UsingGeneric(C()).doShout()

  // 2) 함수 제너릭
  doShoutFunc(B())
  doShoutFunc<A>(C())
}

open class A {
  open fun shout() {
    println("Shout A")
  }
}

open class B : A() {
  override fun shout() {
    println("Shout B")
  }
}

open class C : A() {
  override fun shout() {
    println("Shout C")
  }
}

class UsingGeneric<T : A>(val t: T) {
  fun doShout() {
    t.shout()
  }
}

fun <T : A> doShoutFunc(t: T) {
  t.shout()
}
