// #29. 변수의 고급 기술, 상수, lateinit, lazy

package space.doky.ch27

fun main() {

  // 1. const
  // val 사용 시, 할당된 인스턴스 래퍼런스 변경 X,
  // 인스턴스 내부 정보는 변경 O
  // (기본 자료형은 해당안됨)
  //
  // const val CONSTA = 10
  // 기본 자료형만 const 사용 가능!
  // 클래스 속성, 지역변수 사용 X
  // companion obj로만 사용해야 함! (static)

  // -> const 사용 시, 인스턴스 생성 안하고 메모리에 값을 고정시켜둘 수가 있음!

  val foodCourt = FoodCourt()

  foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
  foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
  foodCourt.searchPrice(FoodCourt.FOOD_BBQ)
  println()

  // lateInit
  var li = LateInitSample()
  println(li.getLateInitText())

  li.text = "new value"
  println(li.getLateInitText())
  println()

  // 3. lazy delegate properties
  // 지연 대리자 속성
  // val a: Int by lazy { 7 }
  // 코드에서 선언 시, 객체 생성 및 즉시 변수 초기화 형태
  // 실제 런타임 -> 변수 사용 시에 초기화 진행 => 실행시간 최적화

  // * 람다함수로 초기화 => 여러 구문 추가할 수 있고,
  //   마지막 값이 자동으로 return 됨!

  val number: Int by lazy {
    println("do init")
    10
  }

  println("start code")
  println(number)
  println(number)

  // 상수, 늦은 초기화, 초기화 지연
  // 변수 사용 방법을 세세하게 조절할 수 있다는 장점!

}

class FoodCourt {
  fun searchPrice(foodName: String) {
    val price =
        when (foodName) {
          FOOD_PIZZA -> 20000
          FOOD_BBQ -> 30000
          FOOD_STEAK -> 40000
          else -> 0
        }
    println("$foodName price -> $price")
  }

  companion object {
    const val FOOD_PIZZA = "pizza"
    const val FOOD_BBQ = "bbq"
    const val FOOD_STEAK = "steak"
  }
}

class LateInitSample {

  // 2. lateinit
  lateinit var text: String
  // -> 기본 자료형에는 사용 X

  fun getLateInitText(): String {
    if (::text.isInitialized) {
      return text
    } else {
      return "default"
    }
  }
}
