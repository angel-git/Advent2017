package day22

fun part1(input: String, iterations: Int): Int {

    val map = input.reader().readLines().map { it.replace(" ", "") }.map { it.toCharArray() }.toMutableList()

    var direction = Direction.UP
    var initialPosition = Pair(map.size / 2, map[0].size / 2)

    var infected = 0

    repeat(iterations) {
        if (initialPosition.first >= map.size) {
            map.add(CharArray(map[0].size, { _ -> '.' }))
        }
        if (initialPosition.first < 0) {
            map.add(0, CharArray(map[0].size, { _ -> '.' }))
            initialPosition = Pair(0, initialPosition.second)
        }
        if (initialPosition.second >= map[0].size) {
            map.forEachIndexed { index, chars -> map[index] = chars + '.' }
        }
        if (initialPosition.second < 0) {
            map.forEachIndexed { index, chars -> map[index] = CharArray(0) + '.' + chars }
            initialPosition = Pair(initialPosition.first, 0)
        }

        val cell = map[initialPosition.first][initialPosition.second]
        if (cell == '#') {
            direction = direction.right()
            map[initialPosition.first][initialPosition.second] = '.'
        }

        if (cell == '.') {
            direction = direction.left()
            map[initialPosition.first][initialPosition.second] = '#'
            infected++
        }

        initialPosition = when (direction) {
            Direction.UP -> Pair(initialPosition.first - 1, initialPosition.second)
            Direction.RIGHT -> Pair(initialPosition.first, initialPosition.second + 1)
            Direction.LEFT -> Pair(initialPosition.first, initialPosition.second - 1)
            Direction.DOWN -> Pair(initialPosition.first + 1, initialPosition.second)
        }
    }

    return infected
}

fun part2(input: String, iterations: Int): Int {

    val map = input.reader().readLines().map { it.replace(" ", "") }.map { it.toCharArray() }.toMutableList()

    var direction = Direction.UP
    var initialPosition = Pair(map.size / 2, map[0].size / 2)

    var infected = 0

    repeat(iterations) {
        if (initialPosition.first >= map.size) {
            map.add(CharArray(map[0].size, { _ -> '.' }))
        }
        if (initialPosition.first < 0) {
            map.add(0, CharArray(map[0].size, { _ -> '.' }))
            initialPosition = Pair(0, initialPosition.second)
        }
        if (initialPosition.second >= map[0].size) {
            map.forEachIndexed { index, chars -> map[index] = chars + '.' }
        }
        if (initialPosition.second < 0) {
            map.forEachIndexed { index, chars -> map[index] = CharArray(0) + '.' + chars }
            initialPosition = Pair(initialPosition.first, 0)
        }

        val cell = map[initialPosition.first][initialPosition.second]

        if (cell == '.') {
            direction = direction.left()
            map[initialPosition.first][initialPosition.second] = 'W'
        }
        if (cell == 'W') {
            map[initialPosition.first][initialPosition.second] = '#'
            infected++
        }

        if (cell == '#') {
            direction = direction.right()
            map[initialPosition.first][initialPosition.second] = 'F'
        }

        if (cell == 'F') {
            direction = direction.reverse()
            map[initialPosition.first][initialPosition.second] = '.'
        }



        initialPosition = when (direction) {
            Direction.UP -> Pair(initialPosition.first - 1, initialPosition.second)
            Direction.RIGHT -> Pair(initialPosition.first, initialPosition.second + 1)
            Direction.LEFT -> Pair(initialPosition.first, initialPosition.second - 1)
            Direction.DOWN -> Pair(initialPosition.first + 1, initialPosition.second)
        }
    }

    return infected
}


enum class Direction {
    UP {
        override fun left() = LEFT
        override fun right() = RIGHT
        override fun reverse() = DOWN
    },

    RIGHT {
        override fun left() = UP
        override fun right() = DOWN
        override fun reverse() = LEFT
    },

    LEFT {
        override fun left() = DOWN
        override fun right() = UP
        override fun reverse() = RIGHT
    },

    DOWN {
        override fun left() = RIGHT
        override fun right() = LEFT
        override fun reverse() = UP
    };

    abstract fun left(): Direction
    abstract fun right(): Direction
    abstract fun reverse(): Direction

}