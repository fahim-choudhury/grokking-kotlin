# Kotlin Lambda with Receivers

Kotlin lambda with receivers, also known as lambda extension, is a powerful feature that allows you to define an
extension function-like scope inside a lambda expression. This is particularly useful when working with DSLs (
Domain-Specific Languages) and building fluent APIs.

## Basic Syntax

The basic syntax for a lambda with receiver is as follows:

```kotlin
receiverType.(receiverVariableName) -> returnType
```

* `receiverType`: The type that becomes the receiver of the lambda, enabling you to access its members within the
  lambda.
* `receiverVariableName`: An optional name that you can use to refer to the receiver object within the lambda.
* `returnType`: The return type of the lambda.

## Example

```kotlin
fun TextView.applyStyle(style: TextView.() -> Unit) {
    style()
}

fun main() {
    val textView = TextView(context)

    textView.applyStyle {
        text = "Hello, Kotlin"
        textSize = 18.0f
        setTextColor(Color.BLUE)
    }
}

```

In this example, the `applyStyle` function takes a lambda with receiver of type `TextView`. Inside the lambda, we can
directly access and modify the properties of the `textView` object.

## Advantages

Lambda receivers simplify code blocks, enabling operations, DSLs, and code reuse. They help create abstractions, extend
primitive types, and craft readable syntax for literals like dates or object builders.