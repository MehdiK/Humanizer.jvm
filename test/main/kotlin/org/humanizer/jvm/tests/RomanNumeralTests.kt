package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.humanizer.jvm.humanize
import org.spek.shouldEqual
import org.humanizer.jvm.toRoman
import org.humanizer.jvm.fromRoman

public class RomanNumeralTests(): Spek() {
    {

        var data = listOf(
                1 to "I",
                2 to "II",
                3 to "III",
                4 to "IV",
                5 to "V",
                6 to "VI",
                7 to "VII",
                8 to "VIII",
                9 to "IX",
                10 to "X",
                11 to "XI",
                12 to "XII",
                40 to "XL",
                50 to "L",
                90 to "XC",
                100 to "C",
                400 to "CD",
                500 to "D",
                3999 to "MMMCMXCIX")

        givenData(data) {
            val (input, expected) = it
            on("calling toRoman on $input", {
                val actual = input.toRoman()
                it("should become ${it.component2()}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        givenData(data) {
            val (expected, input) = it
            on("calling fromRoman on $input", {
                val actual = input.fromRoman()
                it("should become ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }
    }
}

