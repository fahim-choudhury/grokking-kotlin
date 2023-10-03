package deepcopy.data

data class Address(var country: String) : Cloneable {
    public override fun clone(): Address {
        return Address(this.country)
    }
}