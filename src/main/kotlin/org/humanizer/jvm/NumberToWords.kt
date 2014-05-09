package org.humanizer.jvm

import java.util.ArrayList

fun Int.toWords(): String {
    var number = this
    if (number == 0)
        return "zero"

    if (number < 0)
        return (number * -1).toWords().format("minus {0}")

    var parts = ArrayList<String>()

    if ((number / 1000000000) > 0) {
        parts.add("${(number / 1000000000).toWords()} billion")
        number %= 1000000000
    }

    if ((number / 1000000) > 0) {
        parts.add("${(number / 1000000).toWords()} million")
        number %= 1000000
    }

    if ((number / 1000) > 0) {
        parts.add("${(number / 1000).toWords()} thousand")
        number %= 1000
    }

    if ((number / 100) > 0) {
        parts.add("${(number / 100).toWords()} hundred")
        number %= 100
    }

    if (number > 0) {
        if (parts.count() != 0)
            parts.add("and");

        if (number < 20)
            parts.add(unitsMap()[number])
        else {
            var lastPart = tensMap()[number / 10]
            if ((number % 10) > 0)
                lastPart += "-${unitsMap()[number % 10]}"

            parts.add(lastPart)
        }
    }

    return parts.makeString(" ").trimLeading()
}

fun Int.toOrdinalWords(): String {
    var towords = ""
    // 9 => ninth
    if (exceptionNumbersToWords(this) != "")
        return exceptionNumbersToWords(this);

    // 21 => twenty first
    if (this > 20) {
        var exceptionPart = ""
        if (exceptionNumbersToWords(this % 10) != "") {
            exceptionPart = exceptionNumbersToWords(this % 10)
            var normalPart = this - this % 10
            towords = removeOnePrefix(normalPart.toWords())
            return "$towords $exceptionPart"
        }
    }

    return normalNumberToWords(this);
}

private fun unitsMap(): List<String> {
    return listOf ("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
}

private fun tensMap(): List<String> {
    return listOf("zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
}

fun OrdinalExceptions(): List<Pair<Int, String>> {
    return  listOf(1 to "first",
            2 to "second",
            3 to "third",
            4 to "fourth",
            5 to "fifth",
            8 to "eighth",
            9 to "ninth",
            12 to "twelfth")
}

private fun normalNumberToWords(number: Int): String {
    var towords = number.toWords().replace('-', ' ').trimLeading()

    towords = removeOnePrefix(towords)
    // twenty => twentieth
    if (towords.endsWith("y"))
        towords = "${towords.substring(0, towords.length - 1)}ie"

    return "${towords}th"
}

private fun removeOnePrefix(towords: String): String {
    // one hundred => hundredth
    var result = towords
    if (towords.startsWith("one "))
        result = towords.substring(4)

    return result;
}

private fun exceptionNumbersToWords(number: Int): String {
    if(OrdinalExceptions().count { it.first == number} == 1)
        return OrdinalExceptions().first { it.first == number }.second
    return ""
}

