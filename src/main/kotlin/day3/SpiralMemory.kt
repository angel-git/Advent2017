package day3

data class Position(var number: Int, val x: Int, val y: Int) {

    fun goNextDirection(number: Int, direction: String): Position {
        if (direction == "right") return goRight(number)
        if (direction == "left") return goLeft(number)
        if (direction == "up") return goUp(number)
        if (direction == "down") return goDown(number)
        return this
    }

    fun goRight(number: Int): Position = Position(number, this.x + 1, this.y)

    fun goLeft(number: Int): Position = Position(number, this.x - 1, this.y)
    fun goUp(number: Int): Position = Position(number, this.x, this.y + 1)
    fun goDown(number: Int): Position = Position(number, this.x, this.y - 1)
    override fun equals(other: Any?): Boolean {
        other as Position
        return this.x == other.x && this.y == other.y
    }

}

fun part1(input: Int): Int {
    val positions = createSpiral(input)
    val position = positions.find { it.number == input }

    return Math.abs(position!!.x - 0) + Math.abs(position.y - 0)
}

fun part2(input: Int): Int {
    return createSpiral2(input)
}

fun MutableList<Position>.sumAdjacents(position: Position): Int {
    return this.sumBy {
        if (position.x - 1 <= it.x && it.x <= position.x + 1 &&
                (position.y - 1 <= it.y && it.y <= position.y + 1)) {
            it.number
        } else {
            0
        }
    }
}

private fun createSpiral(n: Int): List<Position> {
    val positions: MutableList<Position> = mutableListOf()
    var currentPosition = Position(1, 0, 0)
    positions.add(currentPosition)
    val directions = arrayOf("right", "up", "left", "down")
    var currentDirection = 0

    var counter = 2

    while (counter <= n) {
        val nextPosition = currentPosition.goNextDirection(counter, directions[currentDirection % 4])

        if (!positions.contains(nextPosition)) {
            positions.add(nextPosition)
            currentDirection++
            counter++
            currentPosition = nextPosition
        } else {
            currentDirection--
        }
    }
    return positions
}

private fun createSpiral2(n: Int): Int {

    val positions: MutableList<Position> = mutableListOf()
    var currentPosition = Position(1, 0, 0)
    positions.add(currentPosition)
    val directions = arrayOf("right", "up", "left", "down")
    var currentDirection = 0

    var counter = 2

    while (counter <= n) {

        val nextPosition = currentPosition.goNextDirection(0, directions[currentDirection % 4])
        val newNumber = positions.sumAdjacents(nextPosition)
        nextPosition.number = newNumber
        if (!positions.contains(nextPosition)) {
            positions.add(nextPosition)
            currentDirection++
            counter++
            currentPosition = nextPosition

            if (newNumber > n) {
                return newNumber
            }
        } else {
            currentDirection--
        }
    }

    return 0

}
