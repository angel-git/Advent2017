package day15

val factorA = 16807L
val factorB = 48271L
val product = 2147483647L

val bit16 = 65535L

fun part1(startA: Long, startB: Long): Int {

    var counter = 0

    var previousA = startA
    var previousB = startB
    (1..40_000_000).forEach {
        previousA = (previousA * factorA) % product
        previousB = (previousB * factorB) % product

        if (previousA and bit16 == previousB and bit16) counter++
    }

    return counter
}

fun part2(startA: Long, startB: Long): Int {
    var counter = 0
    var previousA = startA
    var previousB = startB
    (1..5_000_000).forEach {
        do {
            previousA = (previousA * factorA) % product
        } while (previousA.toInt() % 4 != 0)
        do {
            previousB = (previousB * factorB) % product
        } while (previousB.toInt() % 8 != 0)


        if (previousA and bit16 == previousB and bit16) counter++
    }

    return counter
}
