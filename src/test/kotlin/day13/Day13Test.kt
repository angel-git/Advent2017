package day13

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day13Test : FeatureSpec() {

    init {

        feature("Day 12") {
            val input = File("src/test/kotlin/day13/input.txt").readText()
            val example = "0: 3\n" +
                    "1: 2\n" +
                    "4: 4\n" +
                    "6: 4"

            scenario("part1") {
                part1(example) shouldBe 24
                part1(input) shouldBe 1316
            }
            scenario("part2") {
                part2(example) shouldBe 10
                part2(input) shouldBe 3840052
            }
        }
    }
}