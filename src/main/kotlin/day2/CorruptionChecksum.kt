package day2

fun checksum(input: String): Int {
    var sum = 0
    input.reader().forEachLine {
        val numbers = it.split("\t").map { it.toInt() }
        sum += numbers.max()!! - numbers.min()!!

    }
    return sum
}

fun checksum2(input: String): Int {
    var sum = 0
    input.reader().forEachLine {
        val numbers = it.split("\t").map { it.toInt() }
        numbers.forEachIndexed { indexI, i ->
            numbers.forEachIndexed { indexJ, j -> if (indexI != indexJ && i % j == 0) sum += i / j }
        }

    }
    return sum
}
