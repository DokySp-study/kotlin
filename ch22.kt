// #22. null 값을 처리하는 방법? 동일한지 확인하는 방법?

package space.doky.ch22

fun main() {

  // 1. nullable인 경우, null check를 해주어야 함
  // ?.   : null safe operator            : 참조연산자 실행 시, null인 경우 참조 X
  // ?:   : elvis operator                : 참조연산자 실행 시, :뒤로 대체하여 사용
  // !!.  : non-null assertion operator   : 컴파일 시 null 여부 검사 X

  var a: String? = null
  println(a?.uppercase())

  println(a ?: "default".uppercase())

  // println(a!!.uppercase())  // -> error

  a?.let {
    println(it.uppercase())
    println(it.lowercase())
  }
  // a가 null 이기 때문에 scope 함수가 실행되지 않음!

  a = "asdf"

  a?.let {
    println(it.uppercase())
    println(it.lowercase())
  }
  // -> 이렇게 작성하면 별도의 if문으로 null check를 하지 않아도 된다!
  println()

  // 2. 변수의 동일성 체크
  // 내용 동일성: 래퍼런스가 가리키는 값이 같은 경우
  // 객체 동일성: 래퍼런스값이 같은 경우

  // 내용 동일성 ==   : Any(최상위 클래스)의 equals() 로 판단
  // 객체 동일성 ===

  var b1 = Product("Coke", 1000)
  var b2 = Product("Cider", 1000)
  var b3 = b1
  var b4 = Product("Coke", 1000)

  println(b1 == b2)
  println(b1 == b3)
  println(b1 == b4)
  println()

  println(b1 === b2)
  println(b1 === b3)
  println(b1 === b4)
  println()

  b1.price = 2000
  println(b1.price)
  println(b3.price)
  println()
  // 래퍼런스가 같기 때문에 당연히 b1을 수정하면 b3도 수정된다.

}

class Product(val name: String, var price: Int) {
  override fun equals(other: Any?): Boolean {
    if (other is Product) return other.name == name && other.price == price
    return false
  }
}
