package example

fun multiplyByTwo(x: Int): Int {
    println("multiplyByTwo is fun")
    return x * 2;
}

fun main() {
    val r = multiplyByTwo(5)
    println("result is : $r")
}