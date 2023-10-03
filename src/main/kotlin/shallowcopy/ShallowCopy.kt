package shallowcopy

import shallowcopy.data.Address
import shallowcopy.data.User

fun main() {
    // 1. Shallow copy on a data class
    val originalUser = User(firstName = "Steve", lastName = "Smith", address = Address("Australia"))
    val copiedUser = originalUser.copy(firstName = "Graeme")

    // FIXME: Add -ea VM option in the IDE's Run configuration to make the assert() method work

    // Check if the originalUser and copiedUser are different objects in memory
    assert(originalUser !== copiedUser) // === is used for referential equality check, inequality check is !==

    // Check if a new String object is created for copiedUser's firstName
    assert(originalUser.firstName !== copiedUser.firstName)

    // At this point, lastName and address objects are shared by both originalUser and copiedUser
    assert(originalUser.lastName === copiedUser.lastName)
    assert(originalUser.address === copiedUser.address)

    // Modify the copiedUser's address
    copiedUser.address.country = "South Africa"

    // Check if changing the address in the copiedUser affects the originalUser due to shared reference
    assert(originalUser.address == copiedUser.address)  // == is used for structural equality check

    // Note: Having all properties as 'val' (immutable) would prevent this issue.

    // 'copy()' only copies properties in the primary constructor, not properties defined in the class body
    originalUser.isChanged = true   // Interesting thing is that, copiedUser.isChanged will remain unchanged i.e. false
    assert(originalUser.isChanged != copiedUser.isChanged)

    // 2. Shallow copy on list
    val fruits = mutableListOf("apple", "banana", "cherry")
    val copiedFruits = fruits.toList()   // Shallow copy, same for map(), toMutableList()

    // Assert that fruits and copiedFruits point to different List objects in memory
    assert(fruits !== copiedFruits)

    fruits[2] = "mango" // fruits[2] have a brand-new String object with value "mango"

    assert(fruits[0] === copiedFruits[0])
    assert(fruits[1] === copiedFruits[1])
    assert(fruits[2] !== copiedFruits[2])   // copiedFruits will not have the updated String object (mango)

    // Create a list of addresses
    val addresses = mutableListOf(Address("Bangladesh"), Address("India"), Address("Pakistan"))

    // Create a shallow copy of the list (creates a separate object in memory)
    val copiedAddresses = addresses.toMutableList()

    // Assert that they are two different objects in memory
    assert(addresses !== copiedAddresses)

    // Modify an element in the original list (affects the copiedAddress list too)
    addresses[2].country = "Nepal"

    for (i in 0..2) {
        // Both lists share the same elements in the same order
        assert(addresses[i] == copiedAddresses[i])
        assert(addresses[i] === copiedAddresses[i])
    }
}