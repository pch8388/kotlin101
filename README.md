# kotlin101

## 식별자
- var : 변경가능(variable)
- val : 변경불가(value)

## 데이터 타입
```kotlin
// 타입을 정확히 지정해줄 수도 있음
var n: Int = 1
var p: Double = 1.2

var n = 1
var p = 1.2
```

- Int
- Double
- Boolean
- String
- Char

> raw string : """string""" 과 같이 멀티라인 string 사용

```kotlin
// Double 로 타입추론 해준다
val n = 1 + 1.2
```

## 함수
```kotlin
fun 함수이름(p1: 타입1, p2: 타입2, ...): 반환타입 {
    return result;
}

fun multiplyByTwo(x: Int): Int {
    println("multiplyByTwo is fun")
    return x * 2;
}
```

```kotlin
fun 함수이름(p1: 타입1, p2: 타입2, ...): 반환타입 = 식

fun multiplyByTwo(x: Int): Int = x * 2
```

> 반환타입을 적지 않으면 추론

```kotlin
fun 함수이름(p1: 타입1, p2: 타입2, ...) =  식

// Int 반환을 추론
fun multiplyByTwo(x: Int) = x * 2
```

## if
- 대부분 java 와 비슷
```kotlin
fun main() {
    val x: Boolean = 1 >= 1
    if (x)
        println("it's true")

    val num = 10
    val result = if (num > 100) 4 else 42
    println("result : $result")

    val b = 1
    println(trueOrFalse(b < 3))
    println(trueOrFalse(b >= 3))

    val k = 1
    println(oneOrTheOther(k == 1))
    println(oneOrTheOther(k == 2))
}

fun trueOrFalse(exp: Boolean): String {
    if (exp)
        return "It's true!"
    return "It's false!"
}

fun oneOrTheOther(exp: Boolean): String =
    if(exp)
        "True"
    else
        "False"
```