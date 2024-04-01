package example

open class Base(p: Int)

class Derived(p: Int) : Base(p)

class BaseChild: Base {

    constructor(p: Int) : super(p)
    constructor(p: Int, s: String) : super(p)
}

open class Parent

class Child : Parent {
    private var age: Int = 0

    constructor(age: Int) {
        this.age = age
    }

    constructor(s: String)
}

open class Shape {
    open fun draw() { /*...*/ }
    fun fill() { /*...*/ }
}

open class Circle() : Shape() {
    override fun draw() { /*...*/ }
}

open class Circle2() : Circle() {
    override fun draw() { /*...*/ }
}

open class Rectangle() : Shape() {
    final override fun draw() { /*...*/ }
}

open class Shape2 {
    open val vertexCount: Int = 0
}

class Rectangle2 : Shape2() {
    override var vertexCount = 4
}

interface Shape3 {
    val vertexCount: Int
}

class Rectangle3(override val vertexCount: Int = 4) : Shape3 // Always has 4 vertices

class Polygon : Shape3 {
    override var vertexCount: Int = 0  // Can be set to any number later
}

fun main() {
    val rectangle3 = Rectangle3(5)
    println(rectangle3.vertexCount)

    val polygon = Polygon()
    polygon.vertexCount = 10
    println(polygon.vertexCount)
}