package passbyvalue

// Reference: https://stackoverflow.com/a/7034719

data class Person(var name: String)

fun main() {
    val person = Person("Graeme Smith")

    fun changeName(anotherPerson: Person) {
        // Compiler assigns/copies/passes the address (reference) of the person object to the parameter, anotherPerson
        // Thus, only one Person object lives in the memory shared by two variables, person and anotherPerson

        // Modify name
        anotherPerson.name = "Steve Smith"

        // FIXME: Add -ea VM option in the IDE's Run configuration to make the assert() method work
        // Assert that both person and anotherPerson refer to the same Person object in memory
        assert(person === anotherPerson)
        assert(person == anotherPerson)
    }

    println("Before changeName(): $person")
    changeName(person)
    println("After changeName(): $person")
}