import java.util.*
import kotlin.math.round

private const val ROUND_NUMBER: Short = 10000
fun roundNumber(number: Double) = round(number * ROUND_NUMBER) / ROUND_NUMBER

data class Item(val value: Double, val weight: Double){
    fun calculateValuation(item: Item): Double = item.value / item.weight
}

private fun calculateMaxValueInKnapsack(knapsackWeight: Int, itemsProperties: ArrayList<Double>): Double {
    var maxKnapsackValue = 0.0
    val itemsArray: ArrayList<Item> = arrayListOf()

    for (property in 0 until itemsProperties.size step 2) {
        itemsArray.add(Item(itemsProperties[property], itemsProperties[property + 1]))
    }
    itemsArray.sortByDescending { it.calculateValuation(it) }

    var weight = knapsackWeight

    itemsArray.forEach {
        it.takeIf { weight > 0 }?.apply {
            maxKnapsackValue += roundNumber(it.value * if (weight >= it.weight) 1.0 else weight / it.weight)
            weight -= it.weight.toInt()
        }
    }

    return maxKnapsackValue
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val knapsackWeight = scanner.nextInt()
    val itemsProperties: ArrayList<Double> = arrayListOf()

    var lengthOfInput = 2 * n
    while (lengthOfInput > 0) {
        itemsProperties.add(scanner.nextDouble())
        lengthOfInput -= 1
    }

    println(calculateMaxValueInKnapsack(knapsackWeight, itemsProperties))
}
