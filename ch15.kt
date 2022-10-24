// #15. 스코프 함수

package space.doky.ch15

fun main() {

  // *람다함수의 특별한 케이스
  // 1) 람다함수도 여러 구문을 수행할 수 있다.
  //  - 이럴 경우, 마지막 구문이 자동으로 return 된다!
  // 2) 파라미터가 없는 경우 중괄호 안에 파라미터 말고 실행할 구문만 입력하면 된다!
  //  - val a: () -> Unit = { println("파라미터 없음") }
  // 3) 파라미터가 1개면 `it`을 사용
  //  - val c: (String) -> Unit = { println("${it}값이 들어옴") }

  // 1. 스코프 함수
  // 람다 함수를 이용한 특수 기능
  // 함수형 언어의 특징을 쉽게 사용할 수 있도록 하는 기능
  // scope 함수로 인스턴스를 전달할 경우, 속성/함수를 쉽게 사용할 수 있도록 하는 것.

  // 1) apply : 인스턴스 생성 시, 구동할 람다함수를 붙일 수 있음 (참조연산자 필요 없음)
  var a =
      Book("Book name", 10000).apply {
        name = "[Title] " + name
        discount()
      }

  println(a.name)
  println(a.price)

  // 2) run   :
  // 람다함수처럼 사용가능
  // 인스턴스를 반환하는 것이 아닌, 람다함수의 리턴값을 반환함!
  // -> 인스턴스 생성 시, 인스턴스 내의 속성/함수를 사용할 때 유용

  val result1 =
      a.run {
        println("1. ${name} / ${price}")
        "2. ${name} / ${price}"
      }
  println(result1)

  // 3) with  :
  // run과 동일한 기능을 하지만
  // 인스턴스를 참조연산자가 아닌 파라미터를 받는다는 것 말고는 동일함.
  val result2 =
      with(a) {
        println("3. ${name} / ${price}")
        "4. ${name} / ${price}"
      }
  println(result2)

  // 4) also / let  :
  // also ~~ apply 과 비슷
  // let ~~ run 과 비슷
  // apply, run -> 참조연산자 사용 안해도 사용 가능
  // also, run -> it을 통해서 인스턴스 접근이 가능
  // *같은 이름의 함수 및 변수가 스코프 내 중복된 경우를 방지하기 위함!
  var price: Int = 5000

  a.run { println("5. ${name} / ${price}") }

  // 이렇게 할 경우, 8000원이 아닌 5000원이 나오게 됨
  // 스코프 우선순위가 현재 함수가 우선임
  // 이럴 때 let을 사용!

  a.let { println("6. ${it.name} / ${it.price}") }

  // 스코프 내에서 인스턴스 속성/함수를 호출하지 않고 분리해서 사용 가능하므로
  // 코드의 가독성을 높여줄 수 있다!

}

class Book(var name: String, var price: Int) {
  fun discount() {
    this.price -= 2000
  }
}
