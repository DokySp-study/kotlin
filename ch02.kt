package space.doky.ch02

fun main() {

  // 1. 주석
  // 주석은 기존 언어와 동일
  // print, println: 기본 출력문
  // 끝에 ; 안찍어도 됨
  print("Hello, world!!!")

  // 2. 변수
  // camelCase 사용
  // var: 일반적인 변수
  // val: final 같은 느낌
  // 클래스 attribute -> property라고 함

  var a: Int = 10
  // 자료형 없이 var a 라고 작성해도 됨
  // 대신 코틀린은 type strict, null-safety 특성을 가짐!
  // nullable의 경우 변수명 뒤에 ?를 붙여서 선언
  //  > var star?: Int
  // late lazy 속성도 존재

  print(a)

  // 3. 자료형
  // 정수형: Byte(8bit), Short(16bit), Int(32bit), Long(64bit)
  // 실수형: Float(32bit), Double(64bit)(기본)

  // 1234L     // Long 타입
  // 12.3f     // Float 타입
  // 0x1af     // 16진수
  // 0b0011010 // 2진수
  // 8진수 X

  // 문자형: Char(2byte)(UTF-16 BE)
  // escape sequence 지원
  var character: Char = '가'
  print(character)

  // 논리형: Boolean
  // true, false

  // 문자열:
  // Q: 왜 타입으로 String을 쓰지 않을까?
  // 위에서 나열한 자료형들은 '기본 자료형'
  // String의 경우는 class
  // -> 강의에서는 String을 붙이지 않았지만 붙여도 상관없음.
  var str1 = "asdf"
  var str2: String = """asdf
    asdf
    asdf""" // 여러줄 작성

  print(str1)
  print(str2)
}
