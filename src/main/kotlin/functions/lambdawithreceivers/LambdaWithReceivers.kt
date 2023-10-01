package functions.lambdawithreceivers

// Reference: https://kotlinlang.org/docs/lambdas.html#function-literals-with-receiver

// A class representing a text view with text content, font size, and text color.
class TextView(var text: String = "", var textSize: Int = 12, var textColor: TextColor = TextColor.Black) {
    // Override the toString function to provide a string representation of the TextView.
    override fun toString(): String {
        return "text = $text, size = $textSize, color = $textColor"
    }
}

// An enum class to represent text colors.
enum class TextColor {
    Black, White
}

// Extension function for TextView that applies a style using a lambda with receiver.
fun TextView.applyStyle(style: TextView.() -> Unit) {
    style() // Invoke the lambda to configure the TextView.
}

fun main() {
    val textView = TextView()
    println("Before applying style: $textView")

    // Apply a style to the textView using a lambda with receiver.
    textView.applyStyle {
        text = "Hello, Kotlin!"
        textSize = 24
        textColor = TextColor.White
    }
    println("After applying style: $textView")
}

