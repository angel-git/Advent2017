package day9


fun processStream(input: String): Pair<Int, Int> {
    var depth = 0
    var count = 0

    var garbage = false
    var ignored = false
    var garbageCount = 0

    input.forEach {
        if (!ignored) {
            if (garbage && it != '!') {
                garbageCount++
            }
            if (it == '{' && !garbage) {
                depth++
            } else if (it == '}' && !garbage) {
                count += depth
                depth--
            } else if (it == '!') {
                ignored = true
            } else if (it == '<' && !garbage) {
                garbage = true
            } else if (it == '>') {
                garbage = false
                garbageCount--
            }
        } else {
            ignored = false
        }
    }
    return Pair(count, garbageCount)
}
