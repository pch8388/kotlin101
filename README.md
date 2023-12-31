# kotlin101

## 식별자
- var : 변경가능(variable)
- val : 변경불가(value)

## 데이터 타입
```kotlin
// 타입을 정확히 지정해줄 수도 있음
var n: Int = 1
var p: Double = 1.2

// Int
var n = 1
// Double
var p = 1.2
// Float
var p = 1.2f
// Long
var n = 1L
```

### Numbers

Integer types

| Type  | Size(bits) | Min value | Max value |
|-------|------------|-----------|-----------|
| Byte  | 8          | -128      | 127       |
| Short | 16         | -32768    | 32767     |
| Int   | 32         | -2^31     | 2^31-1    |
| Long  | 64         | -2^63     | 2^63-1    |

Floating-point types

| Type   | Size(bits) | Significant bits | Exponent bits | Decimal digits |
|--------|------------|-----------------|---------------|----------------|
| Float  | 32         | 24              | 8             | 6-7            |
| Double | 64         | 53              | 11            | 15-16          |



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

## when
- switch 의 역할
- 나중에 예제 더 추가
```kotlin
val numbers = mapOf(
    1 to "eins", 2 to "zwei", 3 to "drei",
    4 to "vier", 5 to "fuenf", 6 to "sechs",
    7 to "sieben", 8 to "acht", 9 to "neun",
    10 to "zehn", 11 to "elf", 12 to "zwoelf"
)

fun ordinal(i: Int): String =
    when (i) {
        1 -> "erste"
        3 -> "dritte"
        7 -> "siebte"
        8 -> "achte"
        20 -> "zwanzigste"
        else -> numbers.getValue(i) + "te"
    }
fun main() {
    println(ordinal(2) == "zweite")
    println(ordinal(3) == "dritte")
    println(ordinal(11) == "elfte")
}
```

## 문자열 템플릿
```kotlin
// $ 로 대입
val answer = 42
println("Found $answer!")
// $1 은 찾을 수 없는 변수라서 그대로 출력됨
println("printing a $1")

// \n으로 new line 표현
val s = "hi\n"
val n = 11
val d = 3.14
println("first: " + s + "second : " + n + " third: " + d)

// {} 안에 식을 넣을 수 있음
val condition = true
println("${if (condition) 'a' else 'b'}")

// $x + 4 => 11 + 4 , ${x+4} => 15
val x = 11
println("$x + 4 = ${x + 4}")

// escape 역슬래쉬(\)
val k = "value"
println("k = \"$k\".")
println("""k = "$k".""")
```