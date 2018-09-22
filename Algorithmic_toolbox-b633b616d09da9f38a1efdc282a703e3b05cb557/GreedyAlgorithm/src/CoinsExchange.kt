import java.util.*

private const val DENOMINATION_1: Short = 1
private const val DENOMINATION_5: Short = 5
private const val DENOMINATION_10: Short = 10

fun calculateExchangeCoinsNumber(n: Short): Int {

    val setDenominations: MutableSet<Short> = mutableSetOf(DENOMINATION_1, DENOMINATION_5, DENOMINATION_10)
    var exchangeCoinsNumber = 0
    var maxInSet: Short
    var inputNumber = n

    while (setDenominations.size > 0) {

        maxInSet = setDenominations.max()!!

        exchangeCoinsNumber += inputNumber / maxInSet
        inputNumber = inputNumber.rem(maxInSet).toShort()
        setDenominations.remove(maxInSet)
    }
    return exchangeCoinsNumber
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextShort()
    println(calculateExchangeCoinsNumber(n))
}
