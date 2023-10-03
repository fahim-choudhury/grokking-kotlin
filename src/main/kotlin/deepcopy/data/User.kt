package deepcopy.data

data class User(val firstName: String, val lastName: String, val address: Address) : Cloneable {
    var isChanged = false

    public override fun clone(): User {
        return User(this.firstName, this.lastName, this.address.clone()).also { it.isChanged = this.isChanged }
    }
}