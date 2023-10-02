package classes

// Reference: https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables
data class Customer(val name: String)
interface Repository {
    fun getAll(): List<Customer>
}

class RepositoryImpl() : Repository {
    override fun getAll(): List<Customer> {
        return emptyList()
    }
}

class CustomerController {
    lateinit var repository: Repository
//    lateinit var counter: Int   // lateinit can't have primitive types as they can't be assigned null values
    fun index(): String {
        return repository.getAll().toString()
    }
}

fun main() {
    val customerController = CustomerController()
    // If we don't provide the repository implementation, code will throw UninitializedPropertyAccessException
//    customerController.repository = RepositoryImpl()
    customerController.index()
}