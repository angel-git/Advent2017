package day6

fun part1(input: String): Int {
    val possibilities = mutableSetOf<String>()
    val memoryBlocks = input.split("\t").map { it.toInt() }.toMutableList()
    var counter = 0

    while (true) {
        val maxIndex = memoryBlocks.indexOf(memoryBlocks.max())
        val maxValue = memoryBlocks[maxIndex]
        memoryBlocks[maxIndex] = 0
        for (i in 0 until maxValue) {
            memoryBlocks[(i + 1 + maxIndex) % memoryBlocks.size]++
        }
        if (possibilities.add(memoryBlocks.joinToString())) {
            counter++
        } else {
            break
        }
    }
    return counter + 1
}

fun part2(input: String): Int {
    val possibilities = mutableSetOf<String>()
    val memoryBlocks = input.split("\t").map { it.toInt() }.toMutableList()

    while (true) {
        val maxIndex = memoryBlocks.indexOf(memoryBlocks.max())
        val maxValue = memoryBlocks[maxIndex]
        memoryBlocks[maxIndex] = 0
        for (i in 0 until maxValue) {
            memoryBlocks[(i + 1 + maxIndex) % memoryBlocks.size]++
        }
        if (!possibilities.add(memoryBlocks.joinToString())) {
            return part1(memoryBlocks.joinToString("\t")) - 1
        }
    }
}
