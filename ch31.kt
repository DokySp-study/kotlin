// #31. 코루틴을 통한 비동기 처리

package doky.space.ch31

import kotlinx.coroutines.*

fun main() {

  // 1. 비동기 처리 coroutine
  // 비동기로 여러 개의 루틴을 처리

  // 제어범위 -> scope
  // - GlobalScope    : 어디에서나 제어 및 동작 가능
  // - CoroutineScope : 특정 목적의 Dispatcher를 지정하여 제어 및 동작

  // 2. CoroutineScope dispatcher
  // Dispatchers.Default : 기본적인 백그라운드 동작
  // Dispatchers.IO      : I/O에 최적화된 동작
  // Dispatchers.Main    : 메인(UI) 스레드
  // 지원되는 플랫폼별로 다름!

  // launch : 반환값 없는 Job 객체
  // -> launch {
  //        ....
  //    }

  // async  : 반환값 있는 Differed 객체
  // -> async {
  //        ....
  //        result
  //    }

  val scope = GlobalScope

  scope.launch {
    for (i in 1..5) {
      println("1: " + i)
    }
  }

  // 결과 안나옴
  // -> 메인 함수가 실행 즉시 종료되고 코루틴도 같이 끝나버림
  // => runBlocking {} 으로 감싸주면, 코루틴 동작할 동안에는 안끝남!
  //   *안드로이드 메인 쓰레드에서 블록 걸어주면... ANR 발생/강제종료!

  runBlocking {
    val a = launch {
      for (i in 1..5) {
        println("2: " + i)
      }
    }

    val b = async { "end async" }

    println("wait async")
    println(b.await())

    // println("wait launch")
    // a.join()
    println("cancel launch")
    a.cancel()

    println("end launch")
  }

  // delay()
  // 밀리세컨 단위로 잠시 정지시킴

  // Job.join()
  // job 실행이 종료되기 전까지 구동

  // Deferred.await()
  // Deffered 종료되기 전까지 구동 & Differed 결과 반환

  // cancel()
  // 진행 도중 중단됨
  // 1) delay(), yield() 까지 구동 후 종료
  // 2) cancel()하면 isActive => false가 되기 때문에 코드로 수동 종료

  // waitTimeoutOrNull()
  // 제한시간 내에 구동되면 결과값을, 아닌경우 null 반환
  // blocking 함수

  runBlocking {
    var result =
        withTimeoutOrNull(110) { // 50ms면 null 반환
          for (i in 1..10) {
            println(i)
            delay(10)
          }
          "Finish"
        }

    println(result)
  }
}
