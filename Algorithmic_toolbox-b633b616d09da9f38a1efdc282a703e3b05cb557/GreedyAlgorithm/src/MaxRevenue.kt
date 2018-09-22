import java.util.*

private fun calculateMaxAdvertisingRevenue(profit: IntArray, clicks: IntArray): Long{
    var maxAdvertisingRevenue: Long = 0
    Arrays.sort(profit)
    Arrays.sort(clicks)
    for (it in profit.size-1 downTo 0){
        maxAdvertisingRevenue += profit[it].toLong() * clicks[it].toLong()
    }
    return maxAdvertisingRevenue
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val profit = IntArray(n)
    val clicks = IntArray(n)

    for (i in 0 until n){
        profit.set(i, scanner.nextInt())
    }
    for (i in 0 until n){
        clicks.set(i, scanner.nextInt())
    }
    println(calculateMaxAdvertisingRevenue(profit, clicks))
}
