package example

data class Person(val name: String, val age: Int)

fun main() {
    val person = Person("Kwon", 20)

    val (name, age) = person
    println("name : $name, age : $age")
    println()

    val person2 = Person("Kim", 30)

    val persons = arrayOf(person, person2)

    for ((nameInArray, ageInArray) in persons) {
        println("name : $nameInArray, age : $ageInArray")
    }

    println()

    val (funName, funAge) = destFunction("Park", 40)
    println("name : $funName, age : $funAge")
}

fun destFunction(name:String, age:Int): Person {
    return Person(name, age)
}