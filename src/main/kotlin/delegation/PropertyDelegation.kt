package delegation

import kotlin.reflect.KProperty

// Reference: https://kotlinlang.org/docs/delegated-properties.html
class GetUserUseCase {
    // Declare a property called 'repository' and delegate it to an instance of UserRepository
    // The 'by' keyword indicates property delegation
    var repository: String by UserRepository()
}

class UserRepository {
    private var backingField = "Default"

    // The 'getValue' method is called when you access the 'repository' property
    operator fun getValue(useCase: GetUserUseCase, property: KProperty<*>): String {
        println("getValue() called: useCase = $useCase, property = $property")
        return backingField
    }

    // The 'setValue' method is called when you assign a new value to the 'repository' property
    operator fun setValue(useCase: GetUserUseCase, property: KProperty<*>, value: String) {
        println("setValue() called")
        backingField = value
    }
}

fun main() {
    val useCase = GetUserUseCase()

    // Access the 'repository' property, which triggers the 'getValue' method in UserRepository
    println(useCase.repository) // Prints: getValue() called: useCase = delegation.GetUserUseCase@<hashcode>, property = var repository: kotlin.String

    // Assign a new value to the 'repository' property, which triggers the 'setValue' method in UserRepository
    useCase.repository = "New value" // Prints: setValue() called

    // Access the 'repository' property again and retrieve the updated value
    println(useCase.repository) // Prints: getValue() called: useCase = delegation.GetUserUseCase@<hashcode>, property = var repository: kotlin.String
    // Prints: New value
}