package day25

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec

class Day25Test: FeatureSpec() {

    init {
        feature("Day 25") {
            val example = "Begin in state A.\n" +
                    "Perform a diagnostic checksum after 6 steps.\n" +
                    "\n" +
                    "In state A:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state B.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 0.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state B.\n" +
                    "\n" +
                    "In state B:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state A.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state A."


            val input = "Begin in state A.\n" +
                    "Perform a diagnostic checksum after 12656374 steps.\n" +
                    "\n" +
                    "In state A:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state B.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 0.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state C.\n" +
                    "\n" +
                    "In state B:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state A.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state D.\n" +
                    "\n" +
                    "In state C:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state D.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 0.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state C.\n" +
                    "\n" +
                    "In state D:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 0.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state B.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 0.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state E.\n" +
                    "\n" +
                    "In state E:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state C.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state F.\n" +
                    "\n" +
                    "In state F:\n" +
                    "  If the current value is 0:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the left.\n" +
                    "    - Continue with state E.\n" +
                    "  If the current value is 1:\n" +
                    "    - Write the value 1.\n" +
                    "    - Move one slot to the right.\n" +
                    "    - Continue with state A."
            scenario("part1"){
                part1(example) shouldBe 3
                part1(input) shouldBe 2526

            }

        }


    }
}