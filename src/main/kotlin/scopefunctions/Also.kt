package scopefunctions

import scopefunctions.data.Person

fun main() {
    // The context object is available as a receiver (it).
    // The return value is the object itself.
    val person = Person().also {
        it.firstName = "Brian"
        it.middleName = "Charles"
        it.country = "West Indies"
    }
    println(person)
}