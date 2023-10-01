# Kotlin Anonymous Functions

Anonymous functions in Kotlin are a powerful and concise way to define function literals without a name. They can be
used as arguments for higher-order functions, stored in variables, or even returned from other functions. Here's the
syntax of an anonymous function in Kotlin:

```kotlin
fun(a: Int, b: Int): Int {
    return a + b
}
```

**Differences with lambda expressions**

The lambda expression syntax is missing one thing – the ability to specify the function's return type. In most
cases, this is unnecessary because the return type can be inferred automatically. However, if you do need to specify it
explicitly, you can use an anonymous function.

Another difference between lambda expressions and anonymous functions is the behavior of non-local returns. A return
statement without a label always returns from the function declared with the fun keyword. This means that a return
inside a lambda expression will return from the enclosing function, whereas a return inside an anonymous function will
return from the anonymous function itself.
