import java.util.*

fun pizanoPeriod(m: Short): Short {
    var number: Short = 0
    val arr = arrayListOf<Short>()

    while (number <= 6 * m) {
        if (number <= 1) arr.add(number)
        else {
            arr.add((arr[number - 1] + arr[number - 2]).rem(m).toShort())
            if (arr[number - 0] == 1.toShort() && arr[number - 1] == 0.toShort()) {
                return (number - 1).toShort()
            }
        }
        number++
    }
    return (number - 1).toShort()
}

fun calcFibRemainder(m: Short, remainder: Short): Long {
    val arr = arrayListOf<Short>()
    var i: Short = 0
    while(i <= remainder){
        if (i == 0.toShort() || i == 1.toShort()) arr.add(i)
        else arr.add((arr[i - 1] + arr[i - 2]).rem(m).toShort())
        i++
    }
    return arr[arr.size - 1].toLong()
}

fun calcFibMod(n: Long, m: Short): Long {
    val period = pizanoPeriod(m)
    val remainder = n.rem(period).toShort()
    val fibonacciRemainder = calcFibRemainder(m, remainder)
    return fibonacciRemainder
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextShort()
    println(calcFibMod(n, m))
}
