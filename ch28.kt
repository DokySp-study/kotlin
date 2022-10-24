// #28. 컬렉션 함수 #2

package space.doky.ch28

fun main() {

  // 1. associateBy
  // 아이템에서 key 추출해서 map으로 바꿔줌
  //
  // var list = listOf(
  //     Person("AAA", 23),
  //     Person("BBB", 48),
  //     Person("CCC", 23)
  // )
  //
  // -> list.associateBy { it.name }
  // => map으로 변환하여 return!
  // => *value가 배열이 아니므로 중복 시 기존 값을 덮어씌움!!

  // 2. groupBy
  // 특정한 값을 key로 지정하여 해당 값을 가진
  // 객체끼리 묶은 배열을 value로 하는 map을 생성
  //
  // -> list.groupBy { it.age }
  // => {
  //      23 = [Person("AAA", 23), Person("CCC", 23)],
  //      48 = [Person("BBB", 48)],
  //    }

  // 3. partition
  // 아이템에 조건을 걸면 두 개의 컬랙션으로 나눠줌
  // -> list.partition { it.age > 30 }
  // => Pair {
  //      first = [Person("AAA", 23), Person("CCC", 23)],
  //      second = [Person("BBB", 48)],
  //    }
  //
  // -> val (over30, under30) = collection.partition { it.age > 30 }
  //    이런 식으로 받을 변수명을 지정할 수도 있음!

  data class Person(val name: String, val age: Int)

  val personList =
      listOf(
          Person("AAA", 31),
          Person("BBB", 29),
          Person("AAA", 23),
          Person("DDD", 19),
      )

  println(personList)
  println()

  println(personList.associateBy { it.name })
  println(personList.associateBy { it.age })
  println()

  println(personList.groupBy { it.name })
  println()

  val (over25, under25) = personList.partition { it.age > 25 }
  println(over25)
  println(under25)

  // 4. flatMap
  // 아이템마다 새로운 아이템을 생성하면, 이를 합쳐서 새로운 컬렉션을 생성함.
  //
  // -> val collection = listOf(1,2,3)
  //    val aa = collection.flatMap {
  //        listOf(it * 3, it + 3)
  //    }
  // => [3, 4, 6, 5, 9, 6]

  // 5. getOrElse
  // -> collection.getOrElse(2){100}
  // => 2
  // -> collection.getOrElse(5){100}
  // => 100

  // 6. zip
  // 두 컬렉션을 Pair로 만들어 List로 반환
  // 작은 쪽의 길이에 맞추어 긴 리스트를 잘라버림

  val numbers = listOf(-3, 7, 2, -10, 1)

  println(numbers.flatMap { listOf(it * 10, it + 10) })
  println()

  println(numbers.getOrElse(1) { 100 })
  println(numbers.getOrElse(10) { 100 })
  println()

  val names = listOf("A", "B", "C", "D", "E", "F")

  println(numbers zip names)

  // 데이터 조작을 용이하게 할 수 있음!

}
