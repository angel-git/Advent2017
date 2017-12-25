package day20

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day20Test : FeatureSpec() {
    init {
        feature("Day 20") {
            val input = File("src/test/kotlin/day20/input.txt").readText()

            scenario("part 1") {
                val example =   "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>\n" +
                                "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>"
                part1(example) shouldBe 0
                part1(input) shouldBe 308
            }
            scenario("part 2") {
                val example =   "p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>\n" +
                                "p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>\n" +
                                "p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>\n" +
                                "p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>"
                part2(example) shouldBe 1
                part2(input) shouldBe 504
            }
        }
    }
}