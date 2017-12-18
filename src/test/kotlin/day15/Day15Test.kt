package day15

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day15Test : FeatureSpec() {

    init {

        feature("day 15") {

            scenario("part1") {
                part1(65, 8921) shouldBe 588
                part1(512, 191) shouldBe 567

            }
            scenario("part2") {
                part2(65, 8921) shouldBe 309
                part2(512, 191) shouldBe 323
            }

        }


    }
}