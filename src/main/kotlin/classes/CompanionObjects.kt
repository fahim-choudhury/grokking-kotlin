package classes

class Log {
    fun print() {
        println("Log: Inside member function")
    }

    object Factory {
        fun print() {
            println("Log: Inside factory object")
        }
    }

    companion object {
        fun print() {
            println("Log: Inside companion object")
        }
    }
}

object Logger {
    fun log() {
        println("Log: Inside logger")
    }
}

fun main() {
    // Using member function
    val log = Log()
    log.print()

    // Using factory object
    Log.Factory.print()

    // Using companion object
    Log.print()

    // Using Logger object directly
    Logger.log()
}