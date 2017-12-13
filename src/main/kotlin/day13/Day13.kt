package day13

fun part1(input: String): Int {
    val values = input.reader().readLines().map {
        val splitted = it.split(": ").map { it.toInt() }
        splitted[0] to splitted[1]
    }.toMap()

    return values
            .map { if (it.key % (2 * (it.value - 1)) == 0) it.key * it.value else 0 }
            .sum()
}

fun part2(input: String): Int {
    val values = input.reader().readLines().map {
        val splitted = it.split(": ").map { it.toInt() }
        splitted[0] to splitted[1]
    }.toMap()

    var delay = 0
    while (values.entries.any { (it.key + delay) % (2 * (it.value - 1)) == 0 })
        delay++

    return delay
}