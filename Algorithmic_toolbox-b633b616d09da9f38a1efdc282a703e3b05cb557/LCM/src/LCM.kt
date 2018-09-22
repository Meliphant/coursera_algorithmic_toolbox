import java.util.*

fun lcm(a: Long, b: Long): Long {
    var x = a
    var y = b
    var x1: Long
    while (y > 0) {
        x1 = y
        y = x.rem(y)
        x = x1
    }
    return a / x * b
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLong()
    val b = scanner.nextLong()

    println(lcm(a, b))
}