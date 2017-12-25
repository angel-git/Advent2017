package day20

import java.util.*

val allRegex = Regex("p=<(-?[0-9]+),(-?[0-9]+),(-?[0-9]+)>, v=<(-?[0-9]+),(-?[0-9]+),(-?[0-9]+)>, a=<(-?[0-9]+),(-?[0-9]+),(-?[0-9]+)>")

fun part1(particles: String): Int {
    val particlesList = particles.reader().readLines().map { parseParticle(it) }
    repeat(1000) {
        particlesList.map { it.move() }
    }
    return particlesList.map { it.distanceFrom0() }.withIndex().sortedBy { it.value }[0].index
}

fun part2(particles: String): Int {
    val particlesList = particles.reader().readLines().map { parseParticle(it) }
    val list = particlesList.toMutableList()
    repeat(1000) {
        val collisions = list.filter { particle -> list.count { particle.isCollision(it) } > 1 }.toSet()
        list.removeIf { collisions.contains(it) }
        list.forEach { it.move() }
    }

    return list.size
}

private fun parseParticle(line: String): Particle {
    val regex = allRegex.matchEntire(line)!!
    val positionVector =
            Vector(
                    listOf(
                            regex.groups[1]!!.value.toInt(),
                            regex.groups[2]!!.value.toInt(),
                            regex.groups[3]!!.value.toInt()))
    val velocityVector =
            Vector(
                    listOf(
                            regex.groups[4]!!.value.toInt(),
                            regex.groups[5]!!.value.toInt(),
                            regex.groups[6]!!.value.toInt()))
    val accelerationVector =
            Vector(
                    listOf(
                            regex.groups[7]!!.value.toInt(),
                            regex.groups[8]!!.value.toInt(),
                            regex.groups[9]!!.value.toInt()))

    return Particle(positionVector, velocityVector, accelerationVector)
}

class Particle(
        private val position: Vector<Int>,
        private val velocity: Vector<Int>,
        private val acceleration: Vector<Int>) {

    fun move() {
        velocity[0] = velocity[0] + acceleration[0]
        velocity[1] = velocity[1] + acceleration[1]
        velocity[2] = velocity[2] + acceleration[2]

        position[0] = position[0] + velocity[0]
        position[1] = position[1] + velocity[1]
        position[2] = position[2] + velocity[2]
    }

    fun distanceFrom0(): Int = Math.abs(position[0]) + Math.abs(position[1]) + Math.abs(position[2])

    fun isCollision(particle: Particle) =
            this.position[0] == particle.position[0] && this.position[1] == particle.position[1] && this.position[2] == particle.position[2]

}