package org.humanizer.jvm.localisation.nl

import java.util.ArrayList

public class NumberToWords {
    public fun toWords(value: Int): String {
        return toWords(value.toLong())
    }

    public fun toWords(value: Long): String {
        var number = value
        if (number == 0L)
            return unitsMap()[0]

        if (number < 0)
            return "min ${toWords(number * -1)}"

        var word = ""

        for(it in hundreds())
        {
            var divided = number / it.value

            if (divided <= 0)
                continue

            if (divided == 1L && !it.displayOneUnit)
                word += it.name
            else
                word += toWords(divided) + it.prefix + it.name

            number %= it.value
            if (number > 0)
                word += it.postfix
        }

        if (number > 0)
        {
            if (number < 20)
                word += unitsMap()[number.toInt()];
            else
            {
                var tens = tensMap()[(number / 10).toInt()]
                var unit = number % 10
                if (unit > 0)
                {
                    var units = unitsMap()[unit.toInt()]
                    var trema = units.endsWith("e")
                    word += units + (if(trema) "ën" else "en") + tens
                }
                else
                    word += tens;
            }
        }

        return word;
    }

    public fun toOrdinalWords(value: Int): String {
        var word = toWords(value);

        if (exceptionNumbersToWords(word) != "")
            return exceptionNumbersToWords(word);

        var postFix = "de"
        val endingCharForSte = listOf ('t', 'g', 'd')
        endingCharForSte.forEach { if (word.lastIndexOf(it) == (word.length() - 1))
            postFix = "ste" }

        return word + postFix
    }

    private fun unitsMap(): List<String> {
        return listOf ("nul", "een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "elf", "twaalf", "dertien", "veertien", "vijftien", "zestien", "zeventien", "achttien", "negentien")
    }

    private fun tensMap(): List<String> {
        return listOf("nul", "tien", "twintig", "dertig", "veertig", "vijftig", "zestig", "zeventig", "tachtig", "negentig")
    }

    fun OrdinalExceptions(): List<Pair<String, String>> {
        return  listOf("een" to "eerste",
                "drie" to "derde",
                "miljoen" to "miljoenste")
    }

    private fun exceptionNumbersToWords(number: String): String {
        if (OrdinalExceptions().count { number.endsWith(it.first) } == 1)
            return number.substring(0, number.length() - OrdinalExceptions().first { number.endsWith(it.first) }.first.length()) + OrdinalExceptions().first { number.endsWith(it.first) }.second
        return ""
    }

    data class Fact(val value: Int, val name: String, val prefix: String, val postfix: String, val displayOneUnit: Boolean) {
    }

    fun hundreds(): List<Fact> {
        return listOf(
                Fact(value = 1000000000, name = "miljard", prefix = " ", postfix = " ", displayOneUnit = true),
                Fact(value = 1000000, name = "miljoen", prefix = " ", postfix = " ", displayOneUnit = true),
                Fact(value = 1000, name = "duizend", prefix = "", postfix = " ", displayOneUnit = false),
                Fact(value = 100, name = "honderd", prefix = "", postfix = "", displayOneUnit = false))
    }
}
