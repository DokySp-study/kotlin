// #7 흐름제어와 논리연산자

package space.doky.ch07

fun main() {

  // 1. break, continue
  // 자바와 동일하게 사용 가능

  // 2. label
  // - 기존 언어에서는 2번 스코프에서 1번 스코프 종료하려면
  //   별도의 조건문을 두어야 했지만, 코틀린에서는 라벨을 붙이고
  //   break@[라벨이름] 을 하면 해당 스코프 기준으로 break가 실행된다.
  // - continue도 동일하게 라벨을 붙여 사용 가능!

  // 1번 스코프
  outer@ for (i in 0..9) {
    // 2번 스코프
    for (j in 0..9) {
      print(i)
      println(j)
      if (j == 3 && i == 1) break@outer
    }
  }

  // 3. 논리연산자
  // 자바와 동일하게 사용 가능

}
