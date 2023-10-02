package delegation

// Reference: https://kotlinlang.org/docs/delegated-properties.html#lazy-properties
class Car {
    // Declare a property 'engine' and delegate it using 'by lazy'
    // The property will be initialized lazily when it's first accessed
    val engine: Int by lazy { initialize() }

    // Private function to simulate a time-consuming initialization
    private fun initialize(): Int {
        var count = 0
        repeat(1000) {
            Thread.sleep(5)
            count++
        }
        return count
    }
}

fun main() {
    val car = Car()

    // Access the 'engine' property for the first time
    // Since it's the first access, 'initialize()' is called, and there is a delay
    println(car.engine)

    // Access the 'engine' property again
    // This time, it returns the previously computed value without re-running 'initialize()'
    println(car.engine)
}