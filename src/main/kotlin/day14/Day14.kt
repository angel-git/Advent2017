package day14

import java.math.BigInteger


fun part1(input: String): Int =
        makeGrid(input).sumBy { it.count { it == '1' } }

fun part2(input: String): Int {
    var groups = 0

    val grid = makeGrid(input).map { it.toCharArray() }
    grid.forEachIndexed { x, row ->
        row.forEachIndexed { y, char ->
            if (char == '1') {
                groups += 1
                findAdjacents(grid, x, y)
            }
        }
    }
    return groups
}

private fun findAdjacents(input: List<CharArray>, x: Int, y: Int) {
    if (x in 0..127 && y in 0..127) {
        if (input[x][y] == '1') {
            input[x][y] = '0'
            findAdjacents(input, x - 1, y)
            findAdjacents(input, x + 1, y)
            findAdjacents(input, x, y - 1)
            findAdjacents(input, x, y + 1)
        }
    }
}

private fun makeGrid(input: String): List<String> =
        (0..127)
                .map { day10.part2(256, "$input-$it") }
                .map { BigInteger(it, 16).toString(2).padStart(128, '0') }
