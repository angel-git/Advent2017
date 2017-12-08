package day4

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FeatureSpec
import java.io.File

class PassphrasesTest : FeatureSpec() {

    init {
        feature("Day 4: High-Entropy Passphrases") {

            val input = File("src/test/kotlin/day4/input.txt").readText()

            scenario("part 1") {
                passphrase("aa bb cc dd ee") shouldBe 1
                passphrase("aa bb cc dd aa") shouldBe 0
                passphrase("aa bb cc dd aaa") shouldBe 1

                passphrase(input) shouldBe 466
            }

            scenario("part 2") {
                passphraseAnagram("abcde fghij") shouldBe 1
                passphraseAnagram("abcde xyz ecdab") shouldBe 0
                passphraseAnagram("a ab abc abd abf abj") shouldBe 1
                passphraseAnagram("iiii oiii ooii oooi oooo") shouldBe 1
                passphraseAnagram("oiii ioii iioi iiio") shouldBe 0

                passphraseAnagram(input) shouldBe 251
            }
        }
    }
}