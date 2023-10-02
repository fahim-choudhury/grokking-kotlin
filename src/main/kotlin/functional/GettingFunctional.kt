package functional

fun applyOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun applyOperation(x: Int, operation: (Int) -> Int): Int {
    return operation(x)
}

fun sum(x: Int, y: Int) = x + y

fun square(x: Int) = x * x

fun unaryOperation(x: Int, operation: (Int) -> Int): Int {
    return operation(x)
}

class Database() {
    fun commit() {}
}

fun transaction(db: Database, code: () -> Unit) {
    try {
        code()
    } finally {
        db.commit()
    }
}

fun main() {
    // 1. Using function literals
    val sum = applyOperation(1, 2, ::sum)
    println(sum)
    val square = applyOperation(sum, ::square)
    println(square)

    // 2. Using lambda expressions
    applyOperation(10, 20, { x: Int, y: Int -> x + y }) // IDE gives warning: lambdas should move out of parentheses
    applyOperation(10, 20) { x, y -> x + y }    // Moved lambda out of parentheses

    // Multiple ways of writing lambda, thanks to Kotlin's type inference
    val sumLambda1 = { x: Int, y: Int -> x + y }
    val sumLambda2: (Int, Int) -> Int = { x, y -> x + y }

    println(applyOperation(10, 20, sumLambda1))
    println(applyOperation(10, 20, sumLambda2))

    // Using the only lambda receiver object with 'it'
    unaryOperation(5) { it * it }

    // Lambdas help to write expressive DSL-like language
    val db = Database()
    transaction(db) {
        // Interact with the database
    }
}