package day5

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class TrampolinesTest: FeatureSpec() {

    init {

        feature("Day 5: A Maze of Twisty Trampolines, All Alike") {

            scenario("part 1") {
                val example = "0\n" +
                        "3\n" +
                        "0\n" +
                        "1\n" +
                        "-3"

                tramp(example) shouldBe 5

                val input = File("src/test/kotlin/day5/trampolines.txt").readText()
                tramp(input) shouldBe 325922

            }

            scenario("part 2") {
                val example = "0\n" +
                        "3\n" +
                        "0\n" +
                        "1\n" +
                        "-3"

                tramp2(example) shouldBe 10
                val input = File("src/test/kotlin/day5/trampolines.txt").readText()
                tramp2(input) shouldBe 0
            }
        }

    }


}