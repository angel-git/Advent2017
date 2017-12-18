package day16


val spinEx = Regex("s([0-9]+)")
val exchangeEx = Regex("x([0-9]+)/([0-9]+)")
val partnerEx = Regex("p([a-p])/([a-p])")


fun part1(programs: String, dance: String): String {

    var chars = programs.toCharArray()
    val movements = dance.split(",")

    chars = doDance(movements, chars)

    return chars.joinToString("")
}

fun part2(programs: String, dance: String): String {

    val alreadyDanced = mutableListOf<String>()
    var chars = programs.toCharArray()
    val movements = dance.split(",")
    repeat(1000000000) {
        if (alreadyDanced.contains(chars.joinToString(""))) {
            return alreadyDanced[1000000000 % alreadyDanced.size]
        } else {
            alreadyDanced.add(chars.joinToString(""))
            chars = doDance(movements, chars)
        }

    }
    return chars.joinToString("")
}

private fun doDance(movements: List<String>, chars: CharArray): CharArray {
    var chars1 = chars
    movements.forEach {
        when {
            it.matches(spinEx) -> chars1 = spin(chars1, spinEx.matchEntire(it)!!.groups[1]!!.value.toInt())
            it.matches(exchangeEx) -> {
                val matchEntire = exchangeEx.matchEntire(it)!!
                exchange(chars1, matchEntire.groups[1]!!.value.toInt(), matchEntire.groups[2]!!.value.toInt())
            }
            it.matches(partnerEx) -> {
                val matchEntire = partnerEx.matchEntire(it)!!
                partner(chars1, matchEntire.groups[1]!!.value[0], matchEntire.groups[2]!!.value[0])
            }
        }
    }
    return chars1
}

private fun spin(dance: CharArray, number: Int): CharArray {
    val last = dance.takeLast(number)
    return (last + dance.dropLast(number)).toCharArray()
}

private fun exchange(dance: CharArray, positionA: Int, positionB: Int) {
    val previousA = dance[positionA]
    dance[positionA] = dance[positionB]
    dance[positionB] = previousA
}

private fun partner(dance: CharArray, programA: Char, programB: Char) {
    exchange(dance, dance.indexOf(programA), dance.indexOf(programB))
}