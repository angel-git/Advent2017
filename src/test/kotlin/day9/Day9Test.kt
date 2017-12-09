package day9

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class Day9Test: FeatureSpec() {

    init {

        feature("Day 9: Stream Processing") {
            val input = File("src/test/kotlin/day9/input.txt").readText()

            scenario("part 1") {
                processStream("{}").first shouldBe 1
                processStream("{{{}}}").first shouldBe 6
                processStream("{{},{}}").first shouldBe 5
                processStream("{{{},{},{{}}}}").first shouldBe 16
                processStream("{<a>,<a>,<a>,<a>}").first shouldBe 1
                processStream("{{<ab>},{<ab>},{<ab>},{<ab>}}").first shouldBe 9
                processStream("{{<!!>},{<!!>},{<!!>},{<!!>}}").first shouldBe 9
                processStream("{{<a!>},{<a!>},{<a!>},{<ab>}}").first shouldBe 3
                processStream(input).first shouldBe 17537

            }

            scenario("part 2") {
                processStream("<>").second shouldBe 0
                processStream("<<<<>").second shouldBe 3
                processStream("<{!>}>").second shouldBe 2
                processStream("<!!>").second shouldBe 0
                processStream("<!!!>>").second shouldBe 0
                processStream("<{o\"i!a,<{i<a>").second shouldBe 10
                processStream(input).second shouldBe 7539

            }
        }
    }
}