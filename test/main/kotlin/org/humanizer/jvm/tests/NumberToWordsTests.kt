package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.humanizer.jvm.toQuantity
import org.spek.shouldEqual
import org.humanizer.jvm.toWords
import org.humanizer.jvm.toOrdinalWords

public class NumberToWordsTests() : Spek() {
    {

        var data = listOf(
                1 to "one",
                10 to "ten",
                11 to "eleven",
                122 to "one hundred and twenty-two",
                3501 to "three thousand five hundred and one",
                100 to "one hundred",
                1000 to "one thousand",
                100000 to "one hundred thousand",
                1000000 to "one million",
                10000000 to "ten million",
                100000000 to "one hundred million",
                1000000000 to "one billion",
                111 to "one hundred and eleven",
                1111 to "one thousand one hundred and eleven",
                111111 to "one hundred and eleven thousand one hundred and eleven",
                1111111 to "one million one hundred and eleven thousand one hundred and eleven",
                11111111 to "eleven million one hundred and eleven thousand one hundred and eleven",
                111111111 to "one hundred and eleven million one hundred and eleven thousand one hundred and eleven",
                1111111111 to "one billion one hundred and eleven million one hundred and eleven thousand one hundred and eleven",
                123 to "one hundred and twenty-three",
                1234 to "one thousand two hundred and thirty-four",
                12345 to "twelve thousand three hundred and forty-five",
                123456 to "one hundred and twenty-three thousand four hundred and fifty-six",
                1234567 to "one million two hundred and thirty-four thousand five hundred and sixty-seven",
                12345678 to "twelve million three hundred and forty-five thousand six hundred and seventy-eight",
                123456789 to "one hundred and twenty-three million four hundred and fifty-six thousand seven hundred and eighty-nine",
                1234567890 to "one billion two hundred and thirty-four million five hundred and sixty-seven thousand eight hundred and ninety")

        givenData(data) {
            on("calling toQuantity with quantity ${it.first}", {
                val actual = it.first.toWords()
                it("should be \"${it.second}\"", {
                    shouldEqual(it.second, actual)
                })
            })
        }

        data = listOf(
                0 to "zeroth",
                1 to "first",
                2 to "second",
                3 to "third",
                4 to "fourth",
                5 to "fifth",
                6 to "sixth",
                7 to "seventh",
                8 to "eighth",
                9 to "ninth",
                10 to "tenth",
                11 to "eleventh",
                12 to "twelfth",
                13 to "thirteenth",
                14 to "fourteenth",
                15 to "fifteenth",
                16 to "sixteenth",
                17 to "seventeenth",
                18 to "eighteenth",
                19 to "nineteenth",
                20 to "twentieth",
                21 to "twenty first",
                22 to "twenty second",
                30 to "thirtieth",
                40 to "fortieth",
                50 to "fiftieth",
                60 to "sixtieth",
                70 to "seventieth",
                80 to "eightieth",
                90 to "ninetieth",
                95 to "ninety fifth",
                96 to "ninety sixth",
                100 to "hundredth",
                120 to "hundred and twentieth",
                121 to "hundred and twenty first",
                1000 to "thousandth",
                1001 to "thousand first",
                1021 to "thousand and twenty first",
                10000 to "ten thousandth",
                10121 to "ten thousand one hundred and twenty first",
                100000 to "hundred thousandth",
                1000000 to "millionth")

        givenData(data) {
            on("calling toQuantity with quantity ${it.first}", {
                val actual = it.first.toOrdinalWords()
                it("should be \"${it.second}\"", {
                    shouldEqual(it.second, actual)
                })
            })
        }

    }
}
