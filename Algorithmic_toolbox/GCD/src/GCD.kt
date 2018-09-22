import java.util.*

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    var x1: Int
    while (y > 0) {
        x1 = y
        y = x.rem(y)
        x = x1
    }
    return x
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(gcd(a, b))
}