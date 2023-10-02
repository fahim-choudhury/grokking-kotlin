package classes

import java.lang.AssertionError

class Stopwatch {
    // Reference: Backing fields: https://kotlinlang.org/docs/properties.html#backing-fields
    var counter = 0
        get() {
            return field
        }
        set(value) {
            if (value > 0) {
                field = value
                // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
            }
        }
}

class Database {
    // Reference: Backing properties: https://kotlinlang.org/docs/properties.html#backing-properties
    private var _table: Map<Int, String>? = null
    public val table: Map<Int, String>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
}

fun main() {
    // 1. Backing fields
    val stopwatch = Stopwatch()
    stopwatch.counter = 100
    println(stopwatch.counter)
    stopwatch.counter = -1
    println(stopwatch.counter)

    // 2. Backing properties
    val database = Database()
//    database.table = mutableMapOf(1 to "Hello", 2 to "World") // Compiler error; immutable table
    println(database.table)
}