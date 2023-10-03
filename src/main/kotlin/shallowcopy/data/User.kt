package shallowcopy.data

data class User(val firstName: String, val lastName: String, val address: Address) {
    var isChanged = false
}