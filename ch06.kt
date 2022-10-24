// #6 반복문과 증감연산자

package space.doky.ch06

fun main() {

  // 1. 반복문
  // 증감연산자 동일하게 사용 가능
  var a = 0

  while (a < 5) {
    print(a++)
  }
  println("")

  // 2. do...while
  // 동일하게 사용 가능
  a = 0

  do {
    print(a++)
  } while (a < 5)
  println("")

  // 3. for
  // in을 사용하여 쓸 수 있음.

  for (i in 0..9) {
    print(i)
  }
  println("")

  for (i in 0..9 step 3) {
    print(i)
  }
  println("")

  for (i in 9 downTo 0) {
    print(i)
  }
  println("")

  for (i in 9 downTo 0 step 3) print(i)
  println("")

  // char형에도 사용 가능
  for (i in 'a'..'e') {
    print(i)
  }
  println("")

  // 이런 식으로는 사용할 수 없음
  // var i = 0
  // for(i=0;i<10; i++){
  //     print(i)
  // }

}
