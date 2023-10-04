package scopefunctions

import scopefunctions.data.Person

fun main() {
    // The context object is available as lambda receiver, this
    // Returns the lambda result
    val person = Person()
    println(person)
    val runResult1 = person.run {
        this.firstName = "Hashim Amla"
        this.country = "South Africa"
    }
    println(person)
    println(runResult1)

    // Non-extension variant of run
    val runResult2 = run {
        val list = listOf("apple", "banana", "orange")
        list
    }
    println(runResult2)
}