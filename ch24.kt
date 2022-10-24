// #24. 중첩클래스와 내부클래스

package space.doky.ch24

fun main() {

  Outer.Nested().Introduce()

  val outer = Outer()
  val inner = outer.Inner()

  inner.introduceInner()
  inner.introduceOuter()

  outer.text = "Changed outer class"
  inner.introduceOuter()
  // inner class의 경우, outer와 연결되어 있기 때문에
  // outer의 영향을 받는다.

}

// 1. Nested class
// 내부 클래스가 외부 클래스의 강력하게 연결되어 있다는 의미를 전달
// inner class도 사용할 수 있음
// -> 단, 외부 클래스 객체가 있어야 생성/사용이 가능

// 코드 가동성 및 편의성 증가 기대

class Outer {

  var text = "Outer Class"

  class Nested {

    fun Introduce() {
      println("Nested class")
    }

    // 일반적인 nested class의 경우, outer를 참조할 수 없음
    // fun introduceOuter() {
    //     println(this@Outer.text)
    // }

    class Nested2 {}
  }

  inner class Inner {

    var text = "Inner class"

    fun introduceInner() {
      println(text)
    }

    fun introduceOuter() {
      // text가 outer에도 있어
      // this@Outer 이런 식으로 명시해줌.
      println(this@Outer.text)
    }
  }
}
