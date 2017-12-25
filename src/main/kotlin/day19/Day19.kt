package day19

fun part1(input: String): Pair<String, Int> {

    val maze = input.split("\n").map { it.toCharArray() }

    var letters = ""
    var count = 0
    val col = maze.first().withIndex().find { (_, c) -> c == '|' }!!.index
    var position = Pair(0, col)
    var direction = "DOWN"

    while (true) {
        val sign = maze[position.first][position.second]
        if (sign.isLetter()) {
            letters = letters.plus(sign)
        }
        if (sign == '+') {
            when (direction) {
                "UP" -> direction = tryGoRightOrLeft(maze, position)
                "DOWN" -> direction = tryGoRightOrLeft(maze, position)
                "LEFT" -> direction = tryGoUpOrDown(maze, position)
                "RIGHT" -> direction = tryGoUpOrDown(maze, position)
            }
        }
        if (sign == ' ') {
            break
        }
        count++
        position = next(direction, position)
    }
    return Pair(letters, count)
}

private fun next(direction: String, currentPos: Pair<Int, Int>): Pair<Int, Int> {
    return when (direction) {
        "DOWN" -> Pair(currentPos.first + 1, currentPos.second)
        "UP" -> Pair(currentPos.first - 1, currentPos.second)
        "RIGHT" -> Pair(currentPos.first, currentPos.second + 1)
        "LEFT" -> Pair(currentPos.first, currentPos.second - 1)
        else -> throw IllegalStateException("wrong $direction")
    }
}

private fun tryGoRightOrLeft(maze: List<CharArray>, currentPos: Pair<Int, Int>): String {
    return if (maze[currentPos.first][currentPos.second - 1] == '-'
                   || maze[currentPos.first][currentPos.second - 1].isLetter()) {
        "LEFT"
    } else "RIGHT"
}

private fun tryGoUpOrDown(maze: List<CharArray>, currentPos: Pair<Int, Int>): String {
    return if (maze[currentPos.first - 1][currentPos.second] == '|'
            || maze[currentPos.first - 1][currentPos.second].isLetter()) {
        "UP"
    } else "DOWN"
}