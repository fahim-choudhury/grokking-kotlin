package scopefunctions

import scopefunctions.data.Person

fun main() {
    val person = Person()
    println(person)
    // The context object is the lambda argument, `it`
    // The return value is the lambda result
    val letResult1 = person.let {
        it.firstName = "Alan Donald"
        it.country = "South Africa"
        "My name is ${it.firstName}. I'm from ${it.country}."
    }
    println(person)
    println("let{} result = $letResult1")

    // Invoking one or more operations on results of call chains
    val numbers = listOf("one", "two", "three", "four")
    val letResult2 = numbers
        .map { it }
        .filter { it.length > 3 }
        .let {
            println(it)
            return@let "I'm a list of strings." // It's optional to use return@let
        }
    println(letResult2)
}