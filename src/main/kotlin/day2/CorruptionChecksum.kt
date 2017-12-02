package day2

private fun doChecksum(input: String, action: (List<Int>) -> Int): Int {
    var sum = 0
    input.reader().forEachLine {
        val numbers = it.split("\t").map { it.toInt() }
        sum += action(numbers)

    }
    return sum
}

fun checksum(input: String): Int {
    return doChecksum(input, { it.max()!! - it.min()!! })
}

fun checksum2(input: String): Int {
    return doChecksum(input, {
        var sum = 0
        it.forEachIndexed { indexI, i ->
            it.forEachIndexed { indexJ, j -> if (indexI != indexJ && i % j == 0) sum += i / j }
        }
        sum
    })
}
