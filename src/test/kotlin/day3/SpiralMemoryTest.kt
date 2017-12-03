package day3

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class SpiralMemoryTest : FeatureSpec() {

    init {
        feature("Day 3: Spiral Memory") {
            scenario("part 1") {
                part1(1) shouldBe 0
                part1(12) shouldBe 3
                part1(23) shouldBe 2
                part1(1024) shouldBe 31

//                part1(361527) shouldBe 326
            }

            scenario("part 2") {
                part2(26) shouldBe 54
                part2(361527) shouldBe 363010
            }
        }
    }

}