package flatmap

fun main() {
    val evenNumbers = listOf(0, 2, 4, 6, 8, 10)
    val oddNumbers = listOf(1, 3, 5, 7, 9)

    val numbers: List<List<Int>> = listOf(evenNumbers, oddNumbers)
    val flattenedList = numbers
        .flatMap { it } // Can be written as flatten()
        .sorted()
    println(flattenedList)

    val words = listOf("a", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")
    val characters = words.flatMap { it.toList() }
    println(characters)
}