package day6

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day6Test : FeatureSpec() {

    init {
        feature("Day 6: Memory Reallocation") {
            scenario("part 1") {
                part1("0\t2\t7\t0") shouldBe 5
                part1("11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11") shouldBe 4074
            }

            scenario("part 2") {
                part2("0\t2\t7\t0") shouldBe 4
                part2("11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11") shouldBe 2793
            }

        }
    }
}