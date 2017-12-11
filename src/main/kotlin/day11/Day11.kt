package day11

fun hex(input: String): Pair<Int, Int> {
    val steps = input.split(",")
    // https://www.redblobgames.com/grids/hexagons/
    var x = 0
    var y = 0
    var z = 0
    var max = 0
    steps.forEach {
        when (it) {
            "n" -> {
                y += 1
                z -= 1
            }
            "s" -> {
                y -= 1
                z += 1
            }
            "ne" -> {
                x += 1
                z -= 1
            }
            "sw" -> {
                x -= 1
                z += 1
            }
            "nw" -> {
                x -= 1
                y += 1
            }
            "se" -> {
                x += 1
                y -= 1
            }
        }
        val dist = (Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2
        if (max < dist) max = dist
    }
    return Pair((Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2, max)
}

