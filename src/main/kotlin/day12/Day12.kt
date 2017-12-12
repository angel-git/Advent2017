package day12

fun part1(input: String, id: String): Set<String> {
    val lines = parse(input.reader().readLines())
    var visited = mutableSetOf(id)
    while (true) {
        val next = visited.toMutableSet()
        for (elem in visited) {
            next.addAll(lines[elem]!!)
        }
        if (next == visited) break
        visited = next
    }
    return visited
}

fun part2(input: String): Set<Set<String>> {
    val groups = parse(input.reader().readLines())
    val visited = mutableSetOf<Set<String>>()
    groups.keys.mapTo(visited) { part1(input, it) }
    return visited
}

private fun parse(input: List<String>): Map<String, List<String>> {
    return input
            .map {
                val all = Regex("\\w+").findAll(it).toList().map { it.value }
                all[0] to all.drop(1)
            }
            .toMap()
}
