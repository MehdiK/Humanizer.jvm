package org.humanizer.jvm

import org.humanizer.jvm.exceptions.ArgumentOutOfRangeException
import java.util.regex.Pattern
import org.humanizer.jvm.exceptions.ArgumentException

fun Int.toRoman() : String
{
    val  minValue = 1
    val maxValue = 3999
    val maxRomanNumeralLength = 15

    if ((this < minValue) || (this > maxValue))
        throw ArgumentOutOfRangeException(this,minValue, maxValue)

    var sb = StringBuilder(maxRomanNumeralLength)

    var result = this
    romanNumerals().forEach()
    {
        while (result / it.second > 0)
        {
            sb.append(it.first)
            result -= it.second
        }
    }

    return sb.toString()
}

fun String.fromRoman() : Int
{
    var input = this.trim().toUpperCase();

    var length = input.length;

    if ((length == 0) || input.isInvalidRomanNumeral())
        throw ArgumentException("Empty or invalid Roman numeral string. The input was $input.");

    var total = 0;
    var i = length;

    while (i > 0)
    {
        var digit = romanNumerals().single{ it.first == input[i-1].toString()}.second

        if (i > 1)
        {
            var previousDigit = romanNumerals().single{ it.first == input[i - 2].toString()}.second

            if (previousDigit < digit)
            {
                digit -= previousDigit
                i--
            }
        }
        i--
        total += digit
    }

    return total
}

fun String.isInvalidRomanNumeral() : Boolean
{
    return !Pattern.compile("^(?i:(?=[MDCLXVI])((M{0,3})((C[DM])|(D?C{0,3}))?((X[LC])|(L?XX{0,2})|L)?((I[VX])|(V?(II{0,2}))|V)?))$", Pattern.CASE_INSENSITIVE).matcher(this).matches()
}

fun romanNumerals() : List<Pair<String, Int>>
{
    return listOf(
        "M" to  1000 ,
        "CM" to 900 ,
        "D" to  500,
        "CD" to 400,
        "C" to 100,
        "XC" to 90,
        "L" to  50,
        "XL" to 40,
        "X" to  10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1)
}
