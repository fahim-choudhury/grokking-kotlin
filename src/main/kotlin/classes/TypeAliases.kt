package classes

// Reference: https://kotlinlang.org/docs/type-aliases.html
typealias OnClickListener = () -> Unit

fun apply(action: OnClickListener) {
    action()
}

fun main() {
    val onClickListener: OnClickListener = { println("I'm a listener") }
    apply(onClickListener)
}