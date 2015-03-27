package org.humanizer.jvm.localisation.en

import java.util.ArrayList

public class NumberToWords {
    public fun toWords(value: Int): String {
        return toWords(value.toLong())
    }

    public fun toWords(value: Long): String {
        var number = value
        if (number == 0L)
            return "zero"

        if (number < 0)
            return "minus ${toWords((number * -1))}"

        var parts = ArrayList<String>()

        if ((number / 1000000000) > 0) {
            parts.add("${toWords((number / 1000000000))} billion")
            number %= 1000000000
        }

        if ((number / 1000000) > 0) {
            parts.add("${toWords((number / 1000000))} million")
            number %= 1000000
        }

        if ((number / 1000) > 0) {
            parts.add("${toWords((number / 1000))} thousand")
            number %= 1000
        }

        if ((number / 100) > 0) {
            parts.add("${toWords(number / 100)} hundred")
            number %= 100
        }

        if (number > 0) {
            if (parts.count() != 0)
                parts.add("and");

            if (number < 20)
                parts.add(unitsMap()[number.toInt()])
            else {
                var lastPart = tensMap()[number.toInt() / 10]
                if ((number % 10) > 0)
                    lastPart += "-${unitsMap()[number.toInt() % 10]}"

                parts.add(lastPart)
            }
        }

        return parts.join(" ").trimStart()
    }

    public fun toOrdinalWords(value: Int): String {
        var towords: String
        // 9 => ninth
        if (exceptionNumbersToWords(value) != "")
            return exceptionNumbersToWords(value);

        // 21 => twenty first
        if (value > 20) {
            var exceptionPart: String
            if (exceptionNumbersToWords(value % 10) != "") {
                exceptionPart = exceptionNumbersToWords(value % 10)
                var normalPart = value - value % 10
                towords = removeOnePrefix(toWords(normalPart))
                return "$towords $exceptionPart"
            }
        }

        return normalNumberToWords(value);
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
        var towords = toWords(number).replace('-', ' ').trimStart()

        towords = removeOnePrefix(towords)
        // twenty => twentieth
        if (towords.endsWith("y"))
            towords = "${towords.substring(0, towords.length() - 1)}ie"

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
        if (OrdinalExceptions().count { it.first == number } == 1)
            return OrdinalExceptions().first { it.first == number }.second
        return ""
    }
}
