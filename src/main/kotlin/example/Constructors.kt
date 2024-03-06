package example

class Constructors {
    init {
        println("Constructors : Init block")
    }

    constructor(i: Int) {
        println("Constructor Int : $i")
    }

    init {
        println("Constructors : Init block2")
    }

    constructor(s: String) {
        println("Constructor string : $s")
    }

    init {
        println("Constructors : Init block3")
    }
}

class DefaultConstructors {
    init {
        println("DefaultConstructors : Init block")
    }
}

class PrimaryConstructors(val name: String) {
    val upperName = name.uppercase()

    init {
        println("Constructors : Init block")
    }
}

fun main() {
    Constructors(1)
    DefaultConstructors()
    Constructors("st")
}