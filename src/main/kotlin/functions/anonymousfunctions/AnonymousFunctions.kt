package functions.anonymousfunctions

// Reference: https://kotlinlang.org/docs/lambdas.html#anonymous-functions
fun performOperation(x: Int, operation: (Int) -> Int): Int {
    return operation(x)
}

fun main() {
    // 1. Lambda expression
    val lambdaResult = performOperation(3, { it * it })
    println(lambdaResult)

    // 2. Anonymous function
    val anonymousResult = performOperation(Int.MAX_VALUE, fun(x: Int): Int {
        // Supports multiple return points
        return if (x == Int.MAX_VALUE) {
            -1
        } else {
            x * x
        }
    })
    println(anonymousResult)


}