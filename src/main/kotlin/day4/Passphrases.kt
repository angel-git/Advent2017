package day4

fun passphrase(input: String): Int {
    var counter = 0
    input.reader().forEachLine {
        val numberOfWords = it.split(" ")
        val numberOfDistinct = numberOfWords.distinct()
        if (numberOfWords == numberOfDistinct) counter ++
    }
    return counter
}

fun passphraseAnagram(input: String): Int {
    var counter = 0
    input.reader().forEachLine {
        val numberOfWords = it.split(" ").map { it.toCharArray().sortedArray().contentToString() }
        val numberOfDistinct = numberOfWords.distinct()
        if (numberOfWords == numberOfDistinct) counter ++
    }
    return counter
}