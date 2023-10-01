# Local and non-local returns in Kotlin

In Kotlin, we typically refer to "local returns" as returns that exit the immediate scope (such as a function or
lambda), and "non-local returns" as returns that exit an outer scope (such as a lambda or inline function).

**Local Return** 

A local return is a return statement that exits the immediate scope, such as a function or lambda, without
affecting the calling function. Local returns are commonly used within functions or lambdas to return a value or exit
early if a certain condition is met.

**Non-Local Return**

A non-local return is a return statement that can exit an outer scope, such as a lambda expression or
an inline function. It allows you to exit not just the immediate scope but also any enclosing functions that are higher
in the call stack.

To avoid confusion, it's essential to use return labels (with the `@` symbol) when working with non-local returns to
specify the scope you want to return from.