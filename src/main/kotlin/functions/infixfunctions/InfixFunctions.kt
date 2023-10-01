package functions.infixfunctions

fun main() {
    // 1
    val result = 1 plus 2
    println("Using infix function: 1 plus 2 = $result")

    // 2
    val p1 = Point(1, 4)
    val p2 = Point(2, 2)

    if (p1 isAbove p2) {
        println("p1 is above p2")
    }
}

infix fun Int.plus(value: Int) = this + value

data class Point(val x: Int, val y: Int)

infix fun Point.isAbove(otherPoint: Point) = this.y > otherPoint.y

