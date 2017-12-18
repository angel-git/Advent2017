package day17

fun part1(input: Int): Int {

    val list = mutableListOf<Int>()
    var currentPos = 0
    list.add(0)
    repeat(2018) {
        currentPos = ((currentPos + input) % list.size) + 1
        list.add(currentPos, it+1)
    }

    return list[(list.indexOf(2017) + 1) % list.size]
}

fun part2(input: Int): Int {
    var currentPos = 0
    var valueAfterZero = 0
    (1..50_000_000).forEach {
        currentPos = ((currentPos + input) % it) + 1
        if (currentPos == 1) valueAfterZero = it
    }

    return valueAfterZero
}