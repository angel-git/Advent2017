package day18

import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout

val setEx = Regex("set ([a-z]) (-?[0-9]+|[a-z])")
val addEx = Regex("add ([a-z]) (-?[0-9]+|[a-z])")
val mulEx = Regex("mul ([a-z]) (-?[0-9]+|[a-z])")
val modEx = Regex("mod ([a-z]) (-?[0-9]+|[a-z])")
val jgzEx = Regex("jgz ([a-z]) (-?[0-9]+|[a-z])")
val rcvEx = Regex("rcv ([a-z])")
val sndEx = Regex("snd ([a-z])")
val numberEx = Regex("-?[0-9]+")

fun part1(instructions: String): Long {
    val instructionsList = instructions.reader().readLines().toList()
    val memory = mutableMapOf<String, Long>()
    ('a'..'z').forEach {
        memory.put(it.toString(), 0L)
    }
    return execute1(memory, instructionsList, mutableMapOf())
}

fun part2(instructions: String): Long {
    val instructionsList = instructions.reader().readLines().toList()


    val channel0to1 = Channel<Long>(Channel.UNLIMITED)
    val channel1to0 = Channel<Long>(Channel.UNLIMITED)
    return runBlocking {
        val p0 = async { execute2(0, instructionsList, channel1to0, channel0to1) }
        val p1 = async { execute2(1, instructionsList, channel0to1, channel1to0) }
        p1.await()
    }

}

private fun execute1(memory: MutableMap<String, Long>, instructionsList: List<String>, sound: MutableMap<String, Long>): Long {

    var nextPointer = 0
    while (true) {
        val instruction = instructionsList[nextPointer]
        nextPointer++
        when {
            instruction.matches(setEx) ->
                parseInstruction(instruction, setEx, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, _ -> parseValue(inst, memory) }) })

            instruction.matches(addEx) ->
                parseInstruction(instruction, addEx, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u + parseValue(inst, memory) }) })

            instruction.matches(mulEx) ->
                parseInstruction(instruction, mulEx, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u * parseValue(inst, memory) }) })

            instruction.matches(modEx) ->
                parseInstruction(instruction, modEx, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u % parseValue(inst, memory) }) })

            instruction.matches(jgzEx) -> {
                parseInstruction(instruction, jgzEx, { inst ->
                    if (memory.getValue(inst.getRegistry()) > 0) {
                        nextPointer += (parseValue(inst, memory) - 1).toInt()
                    }
                })

            }
            instruction.matches(sndEx) ->
                parseInstruction(instruction, sndEx, { inst -> sound.put(inst.getRegistry(), memory.getValue(inst.getRegistry())) })

            instruction.matches(rcvEx) -> {
                val inst = rcvEx.matchEntire(instruction)!!
                if (memory.getValue(inst.getRegistry()) != 0L && sound.containsKey(inst.getRegistry())) {
                    return sound.getValue(inst.getRegistry())
                }
            }

        }
    }

}


suspend private fun execute2(program: Int, instructionsList: List<String>, inChannel: Channel<Long>, outChannel: Channel<Long>): Long {

    val memory = mutableMapOf<String, Long>()
    ('a'..'z').forEach {
        memory.put(it.toString(), 0L)
    }
    memory.put("p", program.toLong())
    var sent = 0
    var nextPointer = 0
    while (true) {
        val instruction = instructionsList[nextPointer]
        nextPointer++
        println("#$program - $instruction")
        when {
            instruction.matches(setEx) ->
                setEx.apply(instruction, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, _ -> parseValue(inst, memory) }) })

            instruction.matches(addEx) ->
                addEx.apply(instruction, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u + parseValue(inst, memory) }) })

            instruction.matches(mulEx) ->
                mulEx.apply(instruction, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u * parseValue(inst, memory) }) })

            instruction.matches(modEx) ->
                modEx.apply(instruction, { inst -> memory.computeIfPresent(inst.getRegistry(), { _, u -> u % parseValue(inst, memory) }) })

            instruction.matches(jgzEx) -> {
                jgzEx.apply(instruction, { inst ->
                    if (memory.getValue(inst.getRegistry()) > 0) {
                        nextPointer += (parseValue(inst, memory).toInt() - 1)
                    }
                })
            }

            instruction.matches(sndEx) ->
                sndEx.applySuspendable(instruction, { inst -> outChannel.send(memory.getValue(inst.getRegistry())) }).also { sent++ }

            instruction.matches(rcvEx) -> {
                try {
                    rcvEx.applySuspendable(instruction, { inst -> memory.put(inst.getRegistry(), withTimeout(5000) { inChannel.receive() }) })
                } catch (e: TimeoutCancellationException) {
                    return sent.toLong()
                }
            }

        }
    }

}


private fun parseInstruction(instruction: String, regex: Regex, param: (MatchResult) -> Unit) =
        regex.matchEntire(instruction)!!.also { param(it) }

suspend private fun parseSuspendInstruction(instruction: String, regex: Regex, param: suspend (MatchResult) -> Unit) =
        regex.matchEntire(instruction)!!.also { param(it) }

private fun parseValue(instruction: MatchResult, memory: MutableMap<String, Long>): Long =
        if (instruction.isNumber()) {
            instruction.getRegistryOrValue().toLong()
        } else {
            memory.getValue(instruction.getRegistryOrValue())
        }

fun Regex.apply(instruction: String, param: (MatchResult) -> Unit) =
        parseInstruction(instruction, this, param)

suspend fun Regex.applySuspendable(instruction: String, param: suspend (MatchResult) -> Unit) =
        parseSuspendInstruction(instruction, this, param)

fun MatchResult.isNumber(): Boolean = this.groups[2]!!.value.matches(numberEx)
fun MatchResult.getRegistry(): String = this.groups[1]!!.value
fun MatchResult.getRegistryOrValue(): String = this.groups[2]!!.value
