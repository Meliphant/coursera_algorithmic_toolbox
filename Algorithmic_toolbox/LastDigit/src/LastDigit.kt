import java.util.*

fun calcFib(n: Int) =
    when (n) {
        0, 1 -> n.rem(10).toByte()
        else -> {
            var number = 0
            val arr = arrayListOf<Byte>()
            while (number <= n) {

                if (number <= 1) arr.add(number.rem(10).toByte())
                else {
                    val x = arr[number - 1]
                    val y = arr[number - 2]
                    arr.add((x + y).rem(10).toByte())
                }
                number++
            }
            arr[arr.size - 1]
        }
    }

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    println(calcFib(n))
}
