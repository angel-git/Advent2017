package day8

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day8Test: FeatureSpec() {

    init {
        feature("Day 8: I Heard You Like Registers") {
            val example = "b inc 5 if a > 1\n" +
                    "a inc 1 if b < 5\n" +
                    "c dec -10 if a >= 1\n" +
                    "c inc -20 if c == 10"
            val input = File("src/test/kotlin/day8/instructions.txt").readText()

            scenario("readInstructions") {
                readInstructions(example).first shouldBe 1
                readInstructions(input).first shouldBe 5966
            }
            scenario("part2") {
                readInstructions(example).second shouldBe 10
                readInstructions(input).second shouldBe 6347
            }

        }
    }
}