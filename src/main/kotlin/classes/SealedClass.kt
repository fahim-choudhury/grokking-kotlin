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
    (0..2).forEach { code ->
        response = when (code) {
            0 -> Response.Loading
            1 -> Response.Success("Success!")
            2 -> Response.Error(400, "Bad request")
            else -> throw RuntimeException("Invalid type")
        }
        println(response.toString())
    }

}