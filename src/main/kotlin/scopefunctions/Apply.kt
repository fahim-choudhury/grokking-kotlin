package scopefunctions

import scopefunctions.data.Person

fun main() {
    // The context object is available as a receiver (this).
    // The return value is the object itself.
    val person = Person().apply {
        this.firstName = "Brian"
        this.middleName = "Charles"
        this.country = "West Indies"
    }
    println(person)
}