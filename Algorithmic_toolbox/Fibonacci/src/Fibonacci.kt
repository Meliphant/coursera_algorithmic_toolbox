import java.util.*

fun calcFib(n: Int) =
        when (n) {
            0, 1 -> n.toLong()
            else -> {
                var number = 0
                val arr = arrayListOf<Long>()
                while (number <= n) {

                    if (number <= 1) arr.add(number.toLong())
                    else arr.add(arr[number - 1] + arr[number - 2])

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
