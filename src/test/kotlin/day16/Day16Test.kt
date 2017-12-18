package day16

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day16Test : FeatureSpec() {

    init {

        feature("Day 16") {

            val input = File("src/test/kotlin/day16/input.txt").readText()
            scenario("part 1") {
                part1("abcde", "s1,x3/4,pe/b") shouldBe "baedc"
                part1(('a'..'p').joinToString(""), input ) shouldBe "nlciboghjmfdapek"
            }
            scenario("part 2") {
                part2(('a'..'p').joinToString(""), input ) shouldBe "nlciboghmkedpfja"
            }


        }


    }
}