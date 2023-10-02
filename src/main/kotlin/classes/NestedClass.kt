package classes


class OuterClass(val outerValue: String) {
    class NestedClass {
        fun workOnNestedClass() {
//            println("I'm working on $outerValue in nested class!")    // Can't access outerValue
            println("I'm working in nested class!")
        }
    }

    inner class InnerClass {
        fun workOnInnerClass() {
            println("I'm working on $outerValue in inner class!")
        }
    }
}

fun main() {
    val nestedClass = OuterClass.NestedClass()
    nestedClass.workOnNestedClass()

    val outerClass = OuterClass("Kotlin")
    val innerClass = outerClass.InnerClass()
    innerClass.workOnInnerClass()

}