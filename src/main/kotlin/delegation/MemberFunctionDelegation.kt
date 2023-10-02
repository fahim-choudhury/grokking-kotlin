package delegation

// Reference: https://kotlinlang.org/docs/delegation.html
interface Repository {
    fun getById(): String
    fun getAll(): List<String>
}

interface Logger {
    fun logAll()
}

class Controller(private val repository: Repository, private val logger: Logger) {
    fun index() {
        repository.getAll()
        logger.logAll()
    }
}

class DelegatedController(repository: Repository, logger: Logger) : Repository by repository, Logger by logger {
    fun index() {
        getAll()
        getById()
        logAll()
    }
}