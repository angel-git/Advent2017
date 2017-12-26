package day25

fun part1(input: String): Int {

    var instructions = input.reader().readLines()
    var state = instructions.find { it.startsWith("Begin in state ") }!!.substringAfter("Begin in state ").dropLast(1)
    var steps = instructions.find { it.startsWith("Perform a diagnostic checksum after ") }!!.substringAfter("after ").dropLast(7).toInt()

    val map = mutableMapOf<String, Action>()

    var indexState: Int
    while (!instructions.isEmpty()) {
        indexState = instructions.indexOfFirst { it.startsWith("In state ") }
        val stateInstructions = instructions.subList(indexState, indexState + 9)
        val currentState = stateInstructions[0].dropLast(1).takeLast(1)

        val write0 = stateInstructions[2].dropLast(1).takeLast(1).toInt()
        val direction0 = if (stateInstructions[3].dropLast(1).endsWith("right")) 1 else -1
        val nextState0 = stateInstructions[4].dropLast(1).takeLast(1)

        val write1 = stateInstructions[6].dropLast(1).takeLast(1).toInt()
        val direction1 = if (stateInstructions[7].dropLast(1).endsWith("right")) 1 else -1
        val nextState1 = stateInstructions[8].dropLast(1).takeLast(1)

        map.put(currentState, Action(write0, direction0, nextState0, write1, direction1, nextState1))
        instructions = instructions.drop(indexState + 9)
    }

    var currentPos = steps/2
    val memory = IntArray(steps, { _ -> 0 })

    while (steps > 0) {
        val action = map[state]!!
        val currentValue = memory[currentPos]
        if (currentValue == 0) {
            memory[currentPos] = action.write0
            currentPos += action.move0
            state = action.next0
        } else {
            memory[currentPos] = action.write1
            currentPos += action.move1
            state = action.next1
        }
        steps--
    }

    return memory.count { it == 1 }
}

data class Action(val write0: Int,
                  val move0: Int,
                  val next0: String,
                  val write1: Int,
                  val move1: Int,
                  val next1: String)