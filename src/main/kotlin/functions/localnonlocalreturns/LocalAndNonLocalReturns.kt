package functions.localnonlocalreturns

// Reference: https://kotlinlang.org/docs/inline-functions.html#non-local-returns
// https://kotlinlang.org/docs/returns.html#return-to-labels

/** Extension function to iterate over elements and apply an action */
fun <T> Iterable<T>.myForEach(action: (T) -> Unit) {
    for (element in this) action(element)
}

/** Inline extension function with the same functionality as myForEach */
inline fun <T> Iterable<T>.myInlinedForEach(action: (T) -> Unit) {
    for (element in this) action(element)
}

fun main() {
    val numbers = 1..20

    // 1. Local return with label
    numbers.myForEach myLabel@{
        if (it % 5 == 0) {
            println("Value = $it")
            // A bare return is not allowed inside a lambda, so we use a label to perform a local return.
            // return // Compiler error; forbidden
            return@myLabel
        }
    }
    println("Returned from myForEach{}")

    // 2. Non-local return in inline functions
    numbers.myInlinedForEach myInlinedForEach@ {
        if (it % 5 == 0) {
            println("Value = $it")
            // Here, we are inside an inline function. Inline functions enable us to return from lambda.
            // A regular 'return' would exit the main() function.
            // return   // It'll exit the main() function
            // To return only from the nearest 'fun', we use a label.
            return@myInlinedForEach // local return
        }
    }
    println("Returned from inlined myForEach{}") // It'll not execute unless @label is used after the return statement

    // 3. Anonymous function
    numbers.myForEach(fun(x) {
        if (x % 5 == 0) {
            println("Value = $x")
            // Here, we use a regular 'return' to perform a local return, which exits only from the anonymous function.
            return
        }
    })
    println("Returned from anonymous function")
}