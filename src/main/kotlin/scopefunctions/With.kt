package scopefunctions

import scopefunctions.data.Person

fun main() {
    val person = Person()
    println(person)
    // with() is not an extension function. The context object is passed as an argument
    // Inside the lambda, it's available as a receiver `this`
    val withResult = with(person) {
        this.firstName = "Dale Steyn"
        this.country = "South Africa"
        "My name is ${this.firstName}. I'm from ${this.country}."
    }
    println(person)
    println("withResult(): $withResult")

    // with vs run on nullable objects
    var nullablePerson: Person? = null

    // Use run on nullable object instead of with
    with(nullablePerson) {
        this?.firstName = "Sachin Tendulkar"
        this?.country = "India"
    }

    nullablePerson?.run {
        this.firstName = "Sachin Tendulkar"
        this.country = "India"
    }
}