// #14 고차함수와 람다함수

// 고차함수?
//  -> 함수를 인스턴스처럼 취급하는 방식
//  -> 함수를 파라미터로 넘기거나 값의 형태로 반환받을 수도 있음

fun main() {
    
    // 고차함수 형태로 넘길 경우, 함수 이름 앞에 :: 를 붙여서 사용
    b(::a)


    // 2. 람다함수
    // 함수를 람다식으로 표현
    // 이름이 없어도 함수 표현을 사용할 수 있음!
    // 람다 함수는 그 자체로 고차함수임
    
    val c: (String) -> Unit = { str -> println("${str} 람다함수") } // str은 타입추론이 됨
    val d = { str:String -> println("${str} 람다함수") } // (String) -> Unit 을 타입추론함!

    val e: (String, String) -> Unit = { 
        str1: String, str2: String -> 
            println("${str1}, $str2 람다함수")
            10
    }

    

    // 람다식은 그 자체로 고차함수이기 때문에 :: 를 생략할 수 있음
    b(c)
    b(d)
    println(e("123", "234"))

    // 람다함수 -> 컬랙션 및 스코프 함수에서 유용하게 사용 가능
    
}


fun a (str: String) {
    println("$str 함수 A")
}

// Unit -> 반환값이 없다는 의미
fun b (function: (String) -> Unit) {
    var result = function("B가 호출함")
    // println("리턴값: $result")
}

