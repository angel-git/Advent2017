package day7

val regex = Regex("([a-z]{4,8}) \\(([0-9]+)\\)( -> ([a-z ,]+))?")

fun part1(input: String): String {
    return parseTree(input.reader().readLines()).name
}

fun part2(input: String): Int {
    val tree = parseTree(input.reader().readLines())
    return walk(tree)
}

fun walk(tree: Tree) : Int {
    if(!tree.balanced()) {
        val result = tree.children().map { walk(it) }.max()
        if(tree.children().map { it.balanced() }.count { it } == tree.children().size) {
            val groups = tree.children().groupBy { it.sum() }
            val wrongTree = groups.values.first { it.size == 1 }.first()
            val correctTree = groups.values.first { it.size > 1 }.first()

            return wrongTree.weight - (wrongTree.sum() - correctTree.sum())
        }

        return result!!
    }

    return Int.MIN_VALUE
}

fun parseTree(lines: List<String>) : Tree {
    val input = lines.map { parse(it) }.toList()
    val programs = input.map { it.name to Tree(it.name, it.weight, null) }.toMap()

    input.flatMap { a -> a.children.map { p -> Pair(a.name, p) } }.forEach {
        programs[it.first]!!.nodes[it.second] = programs[it.second]!!
        programs[it.second]!!.parent = programs[it.first]!!
    }

    return programs.values.first { it.parent == null }
}

fun parse(line: String): Node {
    val result = regex.matchEntire(line)!!

    val name = result.groups[1]!!.value
    val weight = result.groups[2]!!.value.toInt()
    val children = if(result.groups[4] == null) listOf() else result.groups[4]!!.value.split(", ").toList()

    return Node(name, weight, children)
}

data class Node(val name: String, val weight: Int, val children: List<String>)

data class Tree (val name: String, val weight: Int, var parent: Tree?) {
    val nodes: MutableMap<String, Tree> = mutableMapOf()

    fun children() = nodes.values
    fun sum(): Int = weight + nodes.values.map { it.sum() }.sum()
    fun balanced() = nodes.values.map { it.sum() }.toSet().size == 1
}
