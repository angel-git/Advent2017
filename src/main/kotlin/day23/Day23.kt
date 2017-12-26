package day23

val numberEx = Regex("-?[0-9]+")

fun part1(input: String): Int {
    val memory = mutableMapOf<String, Long>()
    ('a'..'h').forEach {
        memory.put(it.toString(), 0L)
    }
    var counter = 0
    var pointer = 0

    val instructions = input.reader().readLines()
    while (pointer in 0 until instructions.size) {

        val it = instructions[pointer]
        val all = it.split(" ")
        val operation = all[0]
        val a = all[1]
        val b = all[2]

        when (operation) {
            "set" -> memory.put(a, memory.getMemory(b))
            "sub" -> memory.put(a, memory.getMemory(a) - memory.getMemory(b))
            "mul" -> memory.put(a, memory.getMemory(a) * memory.getMemory(b)).also { counter++ }
            "jnz" -> {
                if (memory.getMemory(a) != 0L) {
                    pointer += memory.getMemory(b).toInt() - 1
                }
            }

        }

        pointer++
    }

    return counter
}

fun part2(): Int {
    var b = 57
    val c: Int
    var d: Int
    var f: Int
    var g: Int
    var h = 0

    b = b * 100 + 100000
    c = b + 17000
    do {
        f = 1
        d = 2
        while (d * d <= b) {
            if (b % d == 0) {
                f = 0
                break
            }
            d++
        }
        if (f == 0) {
            h++
        }
        g = b - c
        b += 17
    } while (g != 0)

    return h
}


fun MutableMap<String, Long>.getMemory(input: String): Long {
    return if (input.isNumber()) {
        input.toLong()
    } else {
        this[input]!!
    }
}

fun String.isNumber(): Boolean = this.matches(numberEx)