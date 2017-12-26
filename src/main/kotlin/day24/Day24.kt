package day24


fun part1(input: String): Int {
    val components = parseInput(input)
    return bridge(0, listOf(), components, compareBy({ it.sumBy { it.strength() } }))
            .sumBy { it.strength() }
}

fun part2(input: String): Int {
    val components = parseInput(input)
    return bridge(0, listOf(), components, compareBy({ it: List<Component> -> it.size }).then(compareBy({ it.sumBy { it.strength() } })))
            .sumBy { it.strength() }
}

fun bridge(x: Int, bridge: List<Component>, remaining: List<Component>, comparator: Comparator<List<Component>>): List<Component> {
    return remaining
            .filter { it.canJoin(x) }
            .map { bridge(it.end(x), bridge + it, remaining - it, comparator) }
            .maxWith(comparator) ?: bridge
}

data class Component(val a: Int, val b: Int) {
    fun canJoin(x: Int): Boolean = x == a || x == b
    fun strength(): Int = a + b
    fun end(x: Int) = if (a == x) b else a
}

private fun parseInput(input: String) =
        input
                .reader()
                .readLines()
                .map { Component(it.split("/")[0].toInt(), it.split("/")[1].toInt()) }
