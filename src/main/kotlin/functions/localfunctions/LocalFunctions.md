# Kotlin Local Functions
Kotlin supports local functions, which are functions inside other functions. Kotlin's local functions offer several benefits, including:

**Encapsulation and Information Hiding**

Local functions allow you to encapsulate implementation details of a larger
function, making the code more modular and easier to understand. They are only accessible within the function they are
defined in, which helps in hiding unnecessary implementation details from the rest of the code. This is particularly
useful when you want to hide functions that are just used as implementation details of a larger function.

```kotlin
fun printArea(width: Int, height: Int) {
    fun calculateArea(width: Int, height: Int): Int = width * height
    val area = calculateArea(width, height)
    println("The area is $area")
}
```

**Access to Outer Function's Variables**

Local functions can access the parameters and variables defined in the outer
scope. This allows them to utilize and manipulate the state of the enclosing function, enhancing their flexibility and
usefulness.

```kotlin
fun fizzbuzz2(start: Int, end: Int) {
    fun isFizz(k: Int): Boolean = k % 3 == 0
    fun isBuzz(k: Int): Boolean = k % 5 == 0
    for (k in start..end) {
        if (isFizz(k) && isBuzz(k))
            println("Fizz Buzz")
        else if (isFizz(k))
            println("Fizz")
        else if (isBuzz(k))
            println("Buzz")
        else
            println(k)
    }
}
```

**Improved Readability**

Local functions can make the code more readable and concise. For example, they can be defined
directly inside loops, which can help to avoid repetition of code and make the code easier to understand.

```kotlin
fun fizzbuzz3(start: Int, end: Int) {
    for (k in start..end) {
        fun isFizz(): Boolean = k % 3 == 0
        fun isBuzz(): Boolean = k % 5 == 0
        when {
            isFizz() && isBuzz() -> println("Fizz Buzz")
            isFizz() -> println("Fizz")
            isBuzz() -> println("Buzz")
            else -> println(k)
        }
    }
}
```