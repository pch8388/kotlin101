package example

open class Base2(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived2(
    name: String,
    val lastName: String,
) : Base2(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

fun main() {
    println("Constructing the derived class(\"hello\", \"world\")")
    Derived2("hello", "world")
}

open class Rectangle4 {
    open fun draw() { /* ... */ }
}

interface Polygon4 {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle4(), Polygon4 {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle4>.draw() // call to Rectangle.draw()
        super<Polygon4>.draw() // call to Polygon.draw()
    }
}