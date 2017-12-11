package day11

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day11Test: FeatureSpec() {
    init {
        feature("Day 11: Hex Ed") {
            val input = File("src/test/kotlin/day11/input.txt").readText()

            scenario("part1") {
                hex("ne,ne,ne").first shouldBe 3
                hex("ne,ne,sw,sw").first shouldBe 0
                hex("ne,ne,s,s").first shouldBe 2
                hex("se,sw,se,sw,sw").first shouldBe 3

                hex(input).first shouldBe 773

            }

            scenario("part2") {
                hex(input).second shouldBe 1560
            }
        }

    }
}