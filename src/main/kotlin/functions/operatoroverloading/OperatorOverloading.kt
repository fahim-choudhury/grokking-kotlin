package functions.operatoroverloading

// Reference: https://kotlinlang.org/docs/operator-overloading.html
data class Time(val hours: Int, val minutes: Int)

operator fun Time.plus(time: Time): Time {
    val minutes = this.minutes + time.minutes
    val hoursInMinutes = minutes / 60
    val remainingMinutes = minutes % 60
    val hours = this.hours + time.hours + hoursInMinutes
    return Time(hours, remainingMinutes)
}

fun main() {
    val time1 = Time(hours = 0, minutes = 58)
    val time2 = Time(hours = 0, minutes = 2)
    val newTime = time1 + time2
    println(newTime)
}