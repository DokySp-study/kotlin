// #13 변수, 함수, 클래스의 접근범위와 접근제한자

package space.doky.ch13

// 1. 스코프
// 패키지, 클래스, 함수 단위로 스코프 동작
// 스코프 3가지 규칙
// 1. 스코프 외부에서 내부 멤버를 '참조 연산자(.)'로만 참조 가능!
// 2. 동일 스코프 내에서 멤버 공유 가능
// 3. 하위 스코프에서 상위 스코프 멤버 재정의 가능

// 2번 예제
var a = "var in package scope"

class B {
  var a = "qwer"
  fun print() {
    print(a)
  }
}

// 3번 예제
class C {
  var a = "qwer"
  fun print() {
    print(a)
  }
}

fun main() {
  // var a = "asdf"
  println(a)
  B().print()
  C().print()
}

// 2. 접근제한자
// 스코프 외부에서 내부로 접근할 때 접근 제한하는 기능
// public internal private protected
// 클래스, 함수, 변수 모두에 붙일 수 있음
//
//                  package scope                  class scope
// - public         (기본)모든 패키지에서 접근      (기본)asd
// - internal       같은 모듈 내에서만              -
// - private        같은 파일 내에서만              클래스 내부에서만
// - protected      -                              클래스 자신 및 **상속받은 클래스에서만**
