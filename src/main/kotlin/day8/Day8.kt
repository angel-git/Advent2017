package day8


val regex = Regex("([a-z]+) (dec|inc) (-?[0-9]+) if ([a-z]+) (<|<=|==|>|>=|!=) (-?[0-9]+)")

fun readInstructions(input: String): Pair<Int, Int> {
    val memory = mutableMapOf<String, Int>()
    val instructions = input.reader().readLines()
    var max = 0

    instructions.forEach {
        val result = regex.matchEntire(it)!!
        val variable = result.groups[1]!!.value
        val operation = result.groups[2]!!.value
        val value = result.groups[3]!!.value.toInt()
        val variableComp = result.groups[4]!!.value
        val comparator = result.groups[5]!!.value
        val valueComp = result.groups[6]!!.value.toInt()

        var valueInMemory = 0
        if (memory.containsKey(variable)) {
            valueInMemory = memory[variable]!!
        }

        var variableCompInMemory = 0
        if (memory.containsKey(variableComp)) {
            variableCompInMemory = memory[variableComp]!!
        }

        if (isOperationApplicable(comparator, variableCompInMemory, valueComp)) {
            if (operation == "inc") {
                valueInMemory += value
            } else {
                valueInMemory -= value
            }
        }
        memory.put(variable, valueInMemory)
        if (max < valueInMemory) {
            max = valueInMemory
        }
    }

    return Pair(memory.maxBy { it.value }!!.value, max)
}

private fun isOperationApplicable(comparator: String, leftValue: Int, rightValue: Int): Boolean {
    return when (comparator) {
        "<" -> leftValue < rightValue
        "<=" -> leftValue <= rightValue
        "==" -> leftValue == rightValue
        "!=" -> leftValue != rightValue
        ">=" -> leftValue >= rightValue
        ">" -> leftValue > rightValue
        else -> throw IllegalArgumentException(comparator)
    }
}