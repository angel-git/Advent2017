package day5

fun tramp(input: String): Int {
    var count = 0
    val maze = input.split("\n").toList().map { it.toInt() }.toMutableList()
    var offset = 0
    while (0 <= offset && offset < maze.size) {
        val nextJump = maze[offset]
        maze[offset]++
        offset += nextJump
        count++
    }
    return count
}


fun tramp2(input: String): Int {
    var count = 0
    val maze = input.split("\n").toList().map { it.toInt() }.toMutableList()
    var offset = 0
    while (0 <= offset && offset < maze.size) {
        val nextJump = maze[offset]
        if (nextJump >= 3) {
            maze[offset]--
        } else {
            maze[offset]++
        }
        offset += nextJump
        count++
    }
    return count
}