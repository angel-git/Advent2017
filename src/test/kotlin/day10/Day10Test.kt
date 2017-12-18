package day10

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day10Test: FeatureSpec() {

    init {
        feature("Day 10: Knot Hash") {
            scenario("part 1") {
                part1(5, "3,4,1,5") shouldBe 12
                part1(256, "187,254,0,81,169,219,1,190,19,102,255,56,46,32,2,216") shouldBe 1980
            }
            scenario("part 2") {
                part2(256, "187,254,0,81,169,219,1,190,19,102,255,56,46,32,2,216") shouldBe "899124dac21012ebc32e2f4d11eaec55"
                part2(256, "88,88,211,106,141,1,78,254,2,111,77,255,90,0,54,205") shouldBe "e0387e2ad112b7c2ef344e44885fe4d8"
                part2(256, "1,2,3") shouldBe "3efbe78a8d82f29979031a4aa0b16a9d"
            }

        }



    }
}