package deepcopy

import deepcopy.data.Address
import deepcopy.data.User

fun main() {
    // Create an originalUser with a User object and an Address object
    val originalUser = User(firstName = "Steve", lastName = "Smith", address = Address("Australia"))

    // Create a copiedUser by making a deep copy of the originalUser with a modified firstName
    val copiedUser = originalUser.copy(firstName = "Graeme").clone()

    // FIXME: Add -ea VM option in the IDE's Run configuration to make the assert() method work

    // Assert that the originalUser and copiedUser are not the same object in memory
    assert(originalUser !== copiedUser)

    // Modify the country in the address of the copiedUser
    copiedUser.address.country = "South Africa"

    // Assert that the address in the originalUser and copiedUser are not the same object in memory
    assert(originalUser.address !== copiedUser.address)

    // Uncomment these lines to print the originalUser and copiedUser
    // println(originalUser)
    // println(copiedUser)

    // Create a list of addresses
    val addresses = mutableListOf(Address("Bangladesh"), Address("India"), Address("Pakistan"))

    // Create a copiedAddresses list by making deep copies of the addresses list
    val copiedAddresses = addresses.map { it.clone() }

    // Modify the country in the third address in the original list
    addresses[2].country = "Nepal"

    // Assert that each address in the original list and copied list are not the same objects in memory
    for (i in 0..2) {
        assert(addresses[i] !== copiedAddresses[i])
    }
}