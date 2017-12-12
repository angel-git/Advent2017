package day12

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day12Test: FeatureSpec() {

    init {

        feature("Day 12") {
            val input = File("src/test/kotlin/day12/input.txt").readText()
            val example = "0 <-> 2\n" +
                    "1 <-> 1\n" +
                    "2 <-> 0, 3, 4\n" +
                    "3 <-> 2, 4\n" +
                    "4 <-> 2, 3, 6\n" +
                    "5 <-> 6\n" +
                    "6 <-> 4, 5"

            scenario("part1") {

                part1(example, "0").size shouldBe 6
                part1(input, "0").size shouldBe 113
            }
            scenario("part2") {
                part2(example).size shouldBe 2
                part2(input).size shouldBe 202
            }
        }
    }
}