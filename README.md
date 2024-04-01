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


언더스코어를 통해 가독성 향상

```kotlin
// Int
val oneMillion = 1_000_000
// Long
val creditCardNumber = 1234_5678_9012_3456L
// Long
val socialSecurityNumber = 999_99_9999L
// Hexadecimals
val hexBytes = 0xFF_EC_DE_5E
// Binaries
val bytes = 0b11010010_01101001_10010100_10010010
```

JVM 에서 number 표현 <br>
JVM 플랫폼에서는 int / double 과 같은 것을 primitive 타입으로 저장한다.<br>
nullable reference 로 저장하는 경우에는 boxing 된 타입으로 저장함

```kotlin
val a: Int = 100
val boxedA: Int? = a
val anotherBoxedA: Int? = a

val b: Int = 10000
val boxedB: Int? = b
val anotherBoxedB: Int? = b

// Referential equality
println(boxedA === anotherBoxedA) // true
println(boxedB === anotherBoxedB) // false
// Structural equality (equals())
println(boxedB == anotherBoxedB) // true
```

> 위와 같이 나오는 이유는 둘 다 boxing 된 타입이지만, JVM 이 -128 ~ 127 에 해당하는 Integer 는 메모리 최적화를 위해 항상 같은 reference 를 반환한다 <br>
> 아래에서 보는 것과 같이 결국 java/lang/Integer.valueOf 를 사용하기 때문에 이와 같이 수행된다

<img width="700" alt="kotlin int boxing" src="https://github.com/pch8388/kotlin101/assets/17218212/37a3c308-556c-449d-9e29-738a210a9b86">

### Unsigned integer types

| Type   | Size(bits) | Min value | Max value |
|--------|------------|-----------|-----------|
| UByte  | 8          | 0         | 255       |
| UShort | 16         | 0         | 65535     |
| UInt   | 32         | 0         | 2^32-1    |
| ULong  | 64         | 0         | 2^64-1    |

> 비즈니스 로직 등에서 쓰기보다는 array 의 index 범위 등에 쓰기에 좋음

### Boolean
자바 동일

### Char
자바와 동일한데, 코틀린 특성상 nullable 하게 정의하면 boxing 타입을 쓰는듯

### 문자열 템플릿
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
// raw string : `"""string"""` 과 같이 멀티라인 string 사용
println("""k = "$k".""")
```

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

## for loop
```kotlin
// foreach 와 같이 collection 을 모두 순회
val items = listOf("apple", "banana", "kiwifruit")
for (item in items) {
    println(item)
}

// indices : collection 의 시작인덱스~끝 인덱스를 나타냄
val items = listOf("apple", "banana", "kiwifruit")
for (index in items.indices) {
    println("item at $index is ${items[index]}")
}

// 1~4 까지 순회 (.. => rangeTo())
for (i in 1..4) print(i)

// 1~3 까지 순회 (..< => rangeUntil())
for (i in 1..<4) print(i)

// 4에서 1까지 순회 => 4321
for (i in 4 downTo 1) print(i)

// 0~8 까지 +2 씩 증가 => 02468
for (i in 0..8 step 2) print(i)

// 0~7 까지 +2 씩 증가 => 0246
for (i in 0..<8 step 2) print(i)

// 8~0 까지 -2 씩 감소 => 86420
for (i in 8 downTo 0 step 2) print(i)

// 이련형태도 됨.. [2, 4, 6, 8, 10]
println((1..10).filter { it % 2 == 0 })
// [3, 5, 7, 9, 11]
print((1..10 step 2).map { it + 2 })
```

> 람다 쓸 때, 파라미터가 한개인 경우 생략할 수 있다. 대신, 변수 이름을 it 로 써야함
> map { it + 2 } 혹은 map { itx -> itx + 2 }

[람다 싱글 파라미터](https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter)

## while loop
- java 랑 동일함

## Data class
```kotlin
data class Person(val name: String, val age: Int)
```
- 간단한 선언으로 Data 를 담는 역할을 하는 클래스를 만들 수 있다(document 에 DTO 클래스 생성이라고 표현)
- data class 를 추가하면 자동으로 제공하는 함수가 있다
  - `getter` (변수를 var로 만들면 setter 도 제공) => getXX() 형태가 아닌 instance.name 과 같은 형태로 사용함
  - `equals` / `hashCode`
  - `toString`
  - `copy` : deep copy
  ```kotlin
  val jack = User(name = "Jack", age = 1)
  val olderJack = jack.copy(age = 2)
  ```
  - `componentN` : 실제로 직접 사용할 일은 없지만 destructuring declarations(구조분해선언)을 위해 선언
  - `equals` / `hashCode` / `toString` 은 명시적으로 사용자가 구현하면 그것을 쓰지만 `copy` 나 `componentN` 은 불가능함
- abstract, open, sealed, inner 로 사용 불가
- 생성자에 반드시 하나이상의 파라미터 필요
  - 생성자 파라미터에 반드시 val / var 선언 필요
- 클래스 내부에 따로 변수 선언을 해도 되지만, 자동 생성 함수들은 해당 변수를 무시하고 생성됨
  - 즉, 아래와 같은 구문이 성립된다
  ```kotlin
  data class Person(val name: String) {
    var age: Int = 0
  }
  
  val person1 = Person("John")
  val person2 = Person("John")
  person1.age = 10
  person2.age = 20
  
  // true
  println("person1 == person2: ${person1 == person2}")
  // 10
  println("person1 age: ${person1.age}")
  // 20
  println("person2 age: ${person2.age}")
  ```

### destructuring declarations
```kotlin
data class Person(val name: String, val age: Int)

val person = Person("Kwon", 20)

val (name, age) = person
print("name : $name, age : $age")

// 구조분해선언은 compile 될 때 아래와 같이 된다고 함 
// 선언을 보면 알 수 변수의 네이밍과는 관계 없이 순서에 영향을 받는다. 즉, val (age, name) = person 이라고 했어도, age에 name이 할당됨
val name = person.component1()
val age = person.component2()

// loop 에서도 사용가능
for ((name, age) in persons) print("name : $name, age : $age")

// function 의 결과를 받는 것도 가능
fun destFunction(name:String, age:Int): Person {
  return Person(name, age)
}
val (funName, funAge) = destFunction("Park", 40)
println("name : $funName, age : $funAge")

// underscore 를 통해 생략도 가능
val (_, funAge2) = destFunction("UnderScore", 42)
```

## Classes
class 키워드로 class 를 선언한다
```kotlin
class Empty
```
이런 문법도 가능하다... 

클래스는 다음의 요소를 가질 수 있다
- Constructor / initializer block
- Functions
- Properties
- Nested and inner classes
- Object declarations

### 생성자
- 기본 생성자를 클래스 헤더에 생성할 수 있다.
- 추가로도 생성가능함
- kotlin 은 객체 생성시에 new 키워드가 없음
```kotlin
class Person constructor(fistName: String)

class Person(fistName: String)
```

속성 initialize 혹은 initialize block 을 사용할 수 있다
```kotlin
// 속성 initialize
class Customer(name: String) {
    val customerKey = name.uppercase()
}

// initialize block
class Customer(name: String) {
    var customerKey
    init {
        customerKey = name.lowercase()
    }
}

// 두개를 섞어쓰면, 순서대로 수행된다
class InitOrderDemo(name: String) {
  val firstProperty = "First property: $name".also(::println)

  init {
    println("First initializer block that prints $name")
  }

  val secondProperty = "Second property: ${name.length}".also(::println)

  init {
    println("Second initializer block that prints ${name.length}")
  }
}
```

클래스 헤더에 바로 정의하는 기본 생성자(primary constructor)에서는 property 에 대한 정의가 가능하다
```kotlin
class Person(val firstName: String, val lastName: String, var age: Int)

// 기본값 설정도 가능
class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true)
```

trailing comma 도 지원 (생성자에서 할 얘기가 맞는지는 모르겠으나..)
```kotlin
class Person(
    val firstName: String,
    val lastName: String,
    var age: Int, // trailing comma
) { /*...*/ }
```

생성자에 특별히 가시성을 제어하거나 어노테이션을 붙이려면 constructor 키워드 앞에 붙이면 됨
```kotlin
class Customer private @Inject constructor(name: String) { /*...*/ }
```

기본 생성자가 아닌 생성자도 추가할 수 있다
```kotlin
class Person(val pets: MutableList<Pet> = mutableListOf())

class Pet {
  constructor(owner: Person) {
    owner.pets.add(this) // adds this pet to the list of its owner's pets
  }
}
```

기본 생성자가 있고, 보조 생성자를 만들려고 하면, this 를 통해 기본 생성자를 호출해주어야 함
````kotlin
class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()
    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }
}
````

- 생성자가 없다면 자바처럼 인자가 없는 기본 생성자는 만들어 준다
- 클래스 헤더에 선언하지 않고 constructor 로 선언하는 경우에는 자바와 같은 룰을 가져간다. 즉, 다른 생성자를 꼭 호출하지 않아도 됨
- 클래스 헤더에 선언된 생성자는 primary constructor 로 반드시 호출해야 함
- init block 은 primary constructor 가 없더라도 작동한다.
  - 재미있는 점은 init block 의 위치와 상관없이 모두 수행된 후 constructor 가 수행된다 
  - primary constructor 가 있는 경우에는 위치에 따라 수행 순서가 달라짐 
    - 컴파일하면 코드를 끼워넣어준다. 아래와 같이 primary constructor 가 없다면 init block 을 먼저 다 수행하도록 컴파일된다 
```kotlin
class Constructors {
    init {
        println("Constructors : Init block")
    }

    constructor(i: Int) {
        println("Constructor Int : $i")
    }

    constructor(s: String) {
        println("Constructor string : $s")
    }
}

class DefaultConstructors {
    init {
        println("DefaultConstructors : Init block")
    }
}
```

primary constructor 가 있는 경우를 보면 코드의 위치에 따라 컴파일 시점에 코드를 배치해주는 것을 볼 수 있다

```kotlin
class PrimaryConstructors(val name: String) {
    val upperName = name.uppercase()
    
    init {
        println("Constructors : Init block")
    }
}
```
`
public final class PrimaryConstructors {
   public PrimaryConstructors(@NotNull String name) {
      Intrinsics.checkNotNullParameter(name, "name");
      super();
      this.name = name;
      String var2 = this.name;
      String var10001 = var2.toUpperCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var10001, "this as java.lang.String).toUpperCase(Locale.ROOT)");
      this.upperName = var10001;
      var2 = "Constructors : Init block";
      System.out.println(var2);
   }
}
`

## Inheritance
- 지정하지 않으면 `Any` 타입을 슈퍼클래스로 가진다
- `Any` 클래스는 `equals / hashcode / toString` 메서드를 가진다


### 상속
```kotlin
// 명시적 슈퍼클래스를 가지려면 콜론(:) 뒤에 선언한다
open class Base(p: Int)

// primary 생성자를 선언하면 선언부에서 super class 생성자도 호출해주어야 함
class Derived(p: Int) : Base(p)

// primary 생성자를 쓰지 않고 슈퍼클래스에 인자가 있는 생성자가 있다면 명시적으로 호출해주어야 한다
class BaseChild: Base {
    constructor(p: Int) : super(p)
    constructor(p: Int, s: String) : super(p)
}

open class Parent

// 부모클래스에 default 생성자만 있다면 명시적으로 호출하지 않아도 되는 듯..
class Child : Parent {
    private var age: Int = 0

    constructor(age: Int) {
        this.age = age
    }

    constructor(s: String)
}
```

### Method Override
````kotlin
// 상속을 허용하려면 open 키워드를 쓴다
// class 가 open 이어도 fill 과 같이 open method 가 아니면 오버라이드가 불가능하다
open class Shape {
    open fun draw() { /*...*/ }
    fun fill() { /*...*/ }
}

open class Circle() : Shape() {
    override fun draw() { /*...*/ }
}

open class Circle2() : Circle() {
    // 여러번 오버라이드도 가능
    override fun draw() { /*...*/ }
}

open class Rectangle() : Shape() {
    // final 로 선언하면 더이상 오버라이드를 허용하지 않음
    final override fun draw() { /*...*/ }
}
````

### Property Override
프로퍼티도 똑같이 오버라이드 가능
````kotlin
open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount = 4
}

// val -> var 는 되지만 var -> val 은 안됨
// val -> var 일때는 하위클래스에서 set 을 재정의하지만 반대는 불가능하기 때문(가능한 경우 리스코프 치환원칙에도 어긋남)
open class Shape2 {
    open val vertexCount: Int = 0
}

class Rectangle2 : Shape2() {
    override var vertexCount = 4
}
````

### 하위 클래스의 초기화 순서
1. 슈퍼클래스의 생성자 초기화
2. 서브클래스의 생성자 초기화

> 이때, 생성자 초기화는 생성자 설명때 언급했던 것과 같이, primary constructor 라면 순서대로 수행하고, 아니라면, init block -> constructor 의 순서로 수행한다
> 슈퍼클래스의 생성자를 초기화하기 위해 호출하는 name.replaceFirstChar 구문이 제일 먼저 호출된다.
````kotlin
open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

fun main() {
    println("Constructing the derived class(\"hello\", \"world\")")
    Derived("hello", "world")
}

// result 
//    Constructing the derived class("hello", "world")
//    Argument for the base class: Hello
//    Initializing a base class
//    Initializing size in the base class: 5
//    Initializing a derived class
//    Initializing size in the derived class: 10
````

### 슈퍼클래스 구현 호출
super 키워드를 통해 상위 클래스 호출
```kotlin
open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}
```

내부 클래스에서 외부 클래스의 슈퍼클래스를 호출 하는 것은 `super@Outer` 형태로 할 수 있음
```kotlin
class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}
```

### Overriding rules
여러 요소로부터 상속받는 경우(클래스 상속은 다중상속이 안되고, 인터페이스)에 같은 시그니처의 메소드가 있다면 반드시 하위 클래스에서 재정의 해야 한다(모호함을 없애기 위해)
슈퍼클래스를 호출할때는 `<Base>` 와 같은 형태로 어떤 클래스를 호출하는 것인지 명시해야한다
````kotlin
open class Rectangle {
    open fun draw() { /* ... */ }
}

interface Polygon {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle(), Polygon {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}
````