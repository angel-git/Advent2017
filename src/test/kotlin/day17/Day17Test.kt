package day17

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day17Test: FeatureSpec() {

    init {
        feature("Day 17") {

            scenario("part1") {
                part1(3) shouldBe 638
                part1(304) shouldBe 1173
            }
            scenario("part2") {
                part2(304) shouldBe 1930815
            }


        }


    }
}