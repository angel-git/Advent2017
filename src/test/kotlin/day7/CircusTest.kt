package day7

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class CircusTest : FeatureSpec() {


    init {

        feature("Day 7: Recursive Circus") {

            scenario("part 1") {
                val example = "pbga (66)\n" +
                        "xhth (57)\n" +
                        "ebii (61)\n" +
                        "havc (66)\n" +
                        "ktlj (57)\n" +
                        "fwft (72) -> ktlj, cntj, xhth\n" +
                        "qoyq (66)\n" +
                        "padx (45) -> pbga, havc, qoyq\n" +
                        "tknk (41) -> ugml, padx, fwft\n" +
                        "jptl (61)\n" +
                        "ugml (68) -> gyxo, ebii, jptl\n" +
                        "gyxo (61)\n" +
                        "cntj (57)"
                part1(example) shouldBe "tknk"

                val input = File("src/test/kotlin/day7/circus.txt").readText()
                part1(input) shouldBe "dtacyn"

            }

            scenario("part 2") {
                val example = "pbga (66)\n" +
                        "xhth (57)\n" +
                        "ebii (61)\n" +
                        "havc (66)\n" +
                        "ktlj (57)\n" +
                        "fwft (72) -> ktlj, cntj, xhth\n" +
                        "qoyq (66)\n" +
                        "padx (45) -> pbga, havc, qoyq\n" +
                        "tknk (41) -> ugml, padx, fwft\n" +
                        "jptl (61)\n" +
                        "ugml (68) -> gyxo, ebii, jptl\n" +
                        "gyxo (61)\n" +
                        "cntj (57)"
                part2(example) shouldBe 60
                val input = File("src/test/kotlin/day7/circus.txt").readText()
                part2(input) shouldBe 521
            }


        }



    }
}