package functions.inlinefunctions

// Reference: https://kotlinlang.org/docs/inline-functions.html
inline fun performAction(noinline nonInlineOperation: () -> Unit, inlineOperation: () -> Unit) {
    println("Before calling operation()")
    nonInlineOperation()
    inlineOperation()
    println("After calling operation")
}

fun main() {
    println("Starting from main")
    performAction(nonInlineOperation = {
        println(message = "This is the noinline operation")
    }, inlineOperation = {
        println("This is the inline operation")
    })
    println("Finishing from main")
}