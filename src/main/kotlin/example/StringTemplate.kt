package example

fun main() {
    val answer = 42
    println("Found $answer!")
    println("printing a $1")

    println()

    val s = "hi\n"
    val n = 11
    val d = 3.14
    println("first: " + s + "second : " + n + " third: " + d)

    println()

    val condition = true
    println("${if (condition) 'a' else 'b'}")

    val x = 11
    println("$x + 4 = ${x + 4}")

    println()

    val k = "value"
    println("k = \"$k\".")
    println("""k = "$k".""")
}