package classes

// Reference: https://kotlinlang.org/docs/sealed-classes.html
sealed class Response {
    object Loading : Response() {
        override fun toString(): String {
            return "Loading..."
        }
    }

    class Success(private val message: String) : Response() {
        override fun toString(): String {
            return message
        }
    }

    class Error(private val code: Int, private val message: String) : Response() {
        override fun toString(): String {
            return "Error! Code = $code, message = $message"
        }
    }
}

fun main() {
//    var responseObject = Response()   // Can't instantiate sealed type
    var response: Response
    (0..3).forEach { code ->
        response = when (code) {
            0 -> Response.Loading
            1 -> Response.Success("Success!")
            2 -> Response.Error(400, "Bad request")
            else -> Response.Error(code, "Unknown request") // Subclasses of sealed types can have multiple instances
        }
        println(response.toString())
    }

    var responseEnum: ResponseEnum

    println("---- Enums ----")
    (0..3).forEach { code ->
        responseEnum = when (code) {
            0 -> ResponseEnum.Loading
            1 -> ResponseEnum.Success
            2 -> ResponseEnum.Error
            else -> ResponseEnum.Error  // Enum constants can only be single instance
        }
        println("$responseEnum, code = ${responseEnum.code}")
    }

}

enum class ResponseEnum(val code: Int) {
    Success(200), Loading(0), Error(500)
}