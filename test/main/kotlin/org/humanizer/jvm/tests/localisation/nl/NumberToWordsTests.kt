package org.humanizer.jvm.tests.localisation.nl

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.humanizer.jvm.toQuantity
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.toWords
import org.humanizer.jvm.toOrdinalWords
import org.humanizer.jvm.localisation.nl.NumberToWords

public class NumberToWordsTests() : Spek() {
    init {

        var data = listOf(
                0 to "nul",
                1 to "een",
                -10 to "min tien",
                10 to "tien",
                11 to "elf",
                122 to "honderdtweeëntwintig",
                3501 to "drieduizend vijfhonderdeen",
                100 to "honderd",
                1000 to "duizend",
                100000 to "honderdduizend",
                1000000 to "een miljoen",
                10000000 to "tien miljoen",
                100000000 to "honderd miljoen",
                1000000000 to "een miljard",
                111 to "honderdelf",
                1111 to "duizend honderdelf",
                111111 to "honderdelfduizend honderdelf",
                1111111 to "een miljoen honderdelfduizend honderdelf",
                11111111 to "elf miljoen honderdelfduizend honderdelf",
                111111111 to "honderdelf miljoen honderdelfduizend honderdelf",
                1111111111 to "een miljard honderdelf miljoen honderdelfduizend honderdelf",
                123 to "honderddrieëntwintig",
                124 to "honderdvierentwintig",
                1234 to "duizend tweehonderdvierendertig",
                12345 to "twaalfduizend driehonderdvijfenveertig",
                123456 to "honderddrieëntwintigduizend vierhonderdzesenvijftig",
                1234567 to "een miljoen tweehonderdvierendertigduizend vijfhonderdzevenenzestig",
                12345678 to "twaalf miljoen driehonderdvijfenveertigduizend zeshonderdachtenzeventig",
                123456789 to "honderddrieëntwintig miljoen vierhonderdzesenvijftigduizend zevenhonderdnegenentachtig",
                1234567890 to "een miljard tweehonderdvierendertig miljoen vijfhonderdzevenenzestigduizend achthonderdnegentig",
                1234567899 to "een miljard tweehonderdvierendertig miljoen vijfhonderdzevenenzestigduizend achthonderdnegenennegentig",
                108 to "honderdacht",
                678 to "zeshonderdachtenzeventig",
                2013 to "tweeduizend dertien",
                2577 to "tweeduizend vijfhonderdzevenenzeventig",
                17053980 to "zeventien miljoen drieënvijftigduizend negenhonderdtachtig",
                415618 to "vierhonderdvijftienduizend zeshonderdachttien",
                16415618 to "zestien miljoen vierhonderdvijftienduizend zeshonderdachttien",
                322 to "driehonderdtweeëntwintig")

        givenData(data) {
            on("calling toQuantity with quantity ${it.first}" , {
                val actual = NumberToWords().toWords(it.first)
                it("should be \"${it.second}\"" , {
                    shouldEqual(it.second , actual)
                })
            })
        }

        data = listOf(
                0 to "nulde",
                1 to "eerste",
                2 to "tweede",
                3 to "derde",
                4 to "vierde",
                5 to "vijfde",
                6 to "zesde",
                7 to "zevende",
                8 to "achtste",
                9 to "negende",
                10 to "tiende",
                11 to "elfde",
                12 to "twaalfde",
                13 to "dertiende",
                14 to "veertiende",
                15 to "vijftiende",
                16 to "zestiende",
                17 to "zeventiende",
                18 to "achttiende",
                19 to "negentiende",
                20 to "twintigste",
                21 to "eenentwintigste",
                22 to "tweeëntwintigste",
                30 to "dertigste",
                40 to "veertigste",
                50 to "vijftigste",
                60 to "zestigste",
                70 to "zeventigste",
                80 to "tachtigste",
                90 to "negentigste",
                95 to "vijfennegentigste",
                96 to "zesennegentigste",
                100 to "honderdste",
                101 to "honderdeerste",
                106 to "honderdzesde",
                108 to "honderdachtste",
                112 to "honderdtwaalfde",
                120 to "honderdtwintigste",
                121 to "honderdeenentwintigste",
                1000 to "duizendste",
                1001 to "duizend eerste",
                1005 to "duizend vijfde",
                1008 to "duizend achtste",
                1012 to "duizend twaalfde",
                1021 to "duizend eenentwintigste",
                10000 to "tienduizendste",
                10121 to "tienduizend honderdeenentwintigste",
                100000 to "honderdduizendste",
                100001 to "honderdduizend eerste",
                1000000 to "een miljoenste",
                1000001 to "een miljoen eerste")

        givenData(data) {
            on("calling toQuantity with quantity ${it.first}" , {
                val actual = NumberToWords().toOrdinalWords(it.first)
                it("should be \"${it.second}\"" , {
                    shouldEqual(it.second , actual)
                })
            })
        }

    }
}
