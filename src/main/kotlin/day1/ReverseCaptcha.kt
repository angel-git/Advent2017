package day1

fun reverseCaptcha(step: Int, captcha: String): Int {
    return captcha
            .filterIndexed { index, c -> captcha[(index + step) % captcha.length] == c }
            .toCharArray().map { it.toString().toInt() }.sum()
}
