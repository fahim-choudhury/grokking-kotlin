package functional


/*
* Reference: https://kotlinlang.org/docs/lambdas.html#closures
* A lambda expression or anonymous function (as well as a local function and an object expression) can access its closure,
* which includes the variables declared in the outer scope.The variables captured in the closure can be modified in the lambda:
 */
fun main() {
    var evenSum = 0
    (1..10)
        .filter { it % 2 == 0 }
        .forEach {
            evenSum += it
        }
    println(evenSum)

    // TODO: https://proandroiddev.com/kotlin-vs-java-the-inside-scoop-on-closures-ae9a8d6ddba5
}