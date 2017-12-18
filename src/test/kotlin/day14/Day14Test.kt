package day14

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day14Test : FeatureSpec() {

    init {

        feature("Day 14") {

            scenario("part1") {
                part1("flqrgnkx") shouldBe 8108
                part1("jzgqcdpd") shouldBe 8074
            }
            scenario("part2") {
                part2("flqrgnkx") shouldBe 1242
                part2("jzgqcdpd") shouldBe 1212
            }
        }
    }
}