package functions.localfunctions

// Reference: https://kotlinlang.org/docs/functions.html#local-functions
fun outerFunction(outerFunctionParam: String){
    val localVariable = "I'm a local variable from outer function. I'm also known as Closure."

    fun localFunction(){
        println(outerFunctionParam)
        println(localVariable)
    }
    localFunction()
}

fun printArea(width: Int, height: Int) {
    fun calculateArea() = width * height
    println("Area = ${calculateArea()}")
}

fun main() {
    outerFunction("I'm an outer function parameter.")
    printArea(10, 20)
}


