package day10

fun part1(length: Int, input: String): Int {
    val lengths = input.split(",").map { it.toInt() }.toList()
    val list = hash(length, lengths)
    return list[0] * list[1]
}

fun part2(length: Int, input: String): String {
    val chars = input.toCharArray().map { it.toInt() }.toList() + listOf(17, 31, 73, 47, 23)
    val list = hash(length, chars, 64)
    return (0..15)
            .map { list.subList(it * 16, it * 16 + 16) }
            .map { xor(it) }
            .hex()
}

private fun hash(length: Int, lengths: List<Int>, times: Int = 1): List<Int> {
    val list = (0 until length).toMutableList()
    var currentPosition = 0
    var skipSize = 0
    (0 until times).forEach {
        lengths.forEach {
            reverse(list, currentPosition, it)
            currentPosition += it + skipSize
            skipSize++
        }
    }
    return list
}

private fun reverse(list: MutableList<Int>, index: Int, length: Int) {
    val indices = (index until index + length).map { it % list.size }
    val subList = list.slice(indices).reversed()
    indices.forEachIndexed { i, v -> list[v] = subList[i] }
}

private fun xor(list: List<Int>) = list.fold(0, { a, b -> a xor b })

fun List<Int>.hex(): String {
    return this.fold("", {a, b -> a + Integer.toHexString(b).padStart(2, '0')})
}