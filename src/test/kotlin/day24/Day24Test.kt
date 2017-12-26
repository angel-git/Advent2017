package day24

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day24Test: FeatureSpec() {
    init {
        feature("Day 24") {
            val example = "0/2\n" +
                    "2/2\n" +
                    "2/3\n" +
                    "3/4\n" +
                    "3/5\n" +
                    "0/1\n" +
                    "10/1\n" +
                    "9/10"

            val input = "42/37\n" +
                    "28/28\n" +
                    "29/25\n" +
                    "45/8\n" +
                    "35/23\n" +
                    "49/20\n" +
                    "44/4\n" +
                    "15/33\n" +
                    "14/19\n" +
                    "31/44\n" +
                    "39/14\n" +
                    "25/17\n" +
                    "34/34\n" +
                    "38/42\n" +
                    "8/42\n" +
                    "15/28\n" +
                    "0/7\n" +
                    "49/12\n" +
                    "18/36\n" +
                    "45/45\n" +
                    "28/7\n" +
                    "30/43\n" +
                    "23/41\n" +
                    "0/35\n" +
                    "18/9\n" +
                    "3/31\n" +
                    "20/31\n" +
                    "10/40\n" +
                    "0/22\n" +
                    "1/23\n" +
                    "20/47\n" +
                    "38/36\n" +
                    "15/8\n" +
                    "34/32\n" +
                    "30/30\n" +
                    "30/44\n" +
                    "19/28\n" +
                    "46/15\n" +
                    "34/50\n" +
                    "40/20\n" +
                    "27/39\n" +
                    "3/14\n" +
                    "43/45\n" +
                    "50/42\n" +
                    "1/33\n" +
                    "6/39\n" +
                    "46/44\n" +
                    "22/35\n" +
                    "15/20\n" +
                    "43/31\n" +
                    "23/23\n" +
                    "19/27\n" +
                    "47/15\n" +
                    "43/43\n" +
                    "25/36\n" +
                    "26/38\n" +
                    "1/10"

            scenario("part1"){
                part1(example) shouldBe 31
                part1(input) shouldBe 1940
            }
            scenario("part2"){
                part2(example) shouldBe 19
                part2(input) shouldBe 1928
            }
        }


    }
}