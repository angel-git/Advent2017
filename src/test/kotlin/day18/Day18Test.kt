package day18

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day18Test: FeatureSpec() {
    init {
        feature("Day 18") {
            val input = File("src/test/kotlin/day18/input.txt").readText()

            scenario("part1"){
                val example = "set a 1\n" +
                        "add a 2\n" +
                        "mul a a\n" +
                        "mod a 5\n" +
                        "snd a\n" +
                        "set a 0\n" +
                        "rcv a\n" +
                        "jgz a -1\n" +
                        "set a 1\n" +
                        "jgz a -2"
                part1(example) shouldBe 4L
                part1(input) shouldBe 3188L
            }
            scenario("part2"){
                val example = "snd a\n" +
                        "snd b\n" +
                        "snd p\n" +
                        "rcv a\n" +
                        "rcv b\n" +
                        "rcv c\n" +
                        "rcv d"
                part2(example) shouldBe 3L
                part2(input) shouldBe 3188L
            }
        }
    }
}