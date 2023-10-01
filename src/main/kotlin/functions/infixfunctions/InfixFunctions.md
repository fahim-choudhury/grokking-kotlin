# Kotlin Infix Functions

In Kotlin, infix functions are a way to call a function using infix notation, which means you can call a function
without using the dot and parentheses. This can make your code look more like a natural language and thus more readable.

Here's a simple example:

```kotlin
infix fun Int.plus(value: Int) = this + value

val result = 1 plus 2
```

To create your own infix functions, you need to meet the following requirements:

1. The function must be a member function or an extension function.
2. It must accept only one parameter.
3. It must be marked with the infix keyword.
4. The parameter must not accept a variable number of arguments and must have no default value.

Infix functions in Kotlin offer several advantages:

**Readability**

Infix functions make your code more readable by allowing you to call a function without using the dot and
parentheses. This can make your code look more like a natural language, which can make it easier to understand.

**Domain Specific Languages (DSLs)**

Infix functions are very useful when you want to create a domain-specific language. They allow you to create code that
reads like natural language, which can make your code more expressive and easier to understand.

```kotlin
data class Point(val x: Int, val y: Int)

infix fun Point.isAbove(otherPoint: Point) = this.y > otherPoint.y

val p1 = Point(1, 4)
val p2 = Point(2, 2)

if (p1 isAbove p2) {
    println("p1 is above p2")
}
```

**Flexibility**

Infix functions can be used with other operators, but you should keep the priority of the operator in mind. Infix
function calls have lower precedence than the arithmetic operators, type casts, and the rangeTo operator. On the other
hand, infix function call's precedence is higher than that of the boolean operators && and ||, is- and in-checks, and
some other operators. [Reference](https://kotlinlang.org/docs/functions.html#function-scope:~:text=Infix%20function%20calls%20have%20lower%20precedence%20than%20arithmetic%20operators)
