package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.humanizer.jvm.truncate
import org.spek.shouldEqual
import org.humanizer.jvm.toQuantity
import org.humanizer.jvm.ShowQuantityAs

public class ToQuantityTests() : Spek() {

    data class ParamClass(val value: String
                          , val quantity: Int
                          , val expected: String
                          , val format: String = ""
                          , val culture: String = "") {
        override fun toString(): String {
            return "\"$value\" "
        }
    }
    {

        var data = listOf(
                ParamClass("case", 0, "0 cases"),
                ParamClass("case", 1, "1 case"),
                ParamClass("case", 5, "5 cases"),
                ParamClass("man", 0, "0 men"),
                ParamClass("man", 1, "1 man"),
                ParamClass("man", 2, "2 men"),
                ParamClass("men", 2, "2 men"),
                ParamClass("process", 2, "2 processes"),
                ParamClass("process", 1, "1 process"),
                ParamClass("processes", 2, "2 processes"),
                ParamClass("processes", 1, "1 process"))

        givenData(data) {
            on("calling toQuantity with quantity ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("case", 0, "cases"),
                ParamClass("case", 1, "case"),
                ParamClass("case", 5, "cases"),
                ParamClass("man", 0, "men"),
                ParamClass("man", 1, "man"),
                ParamClass("man", 2, "men"),
                ParamClass("men", 2, "men"),
                ParamClass("process", 2, "processes"),
                ParamClass("process", 1, "process"),
                ParamClass("processes", 2, "processes"),
                ParamClass("processes", 1, "process"))
        givenData(data) {
            on("calling toQuantity with quantity ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity, showQuantityAs = ShowQuantityAs.None)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("case", 0, "0 cases"),
                ParamClass("case", 1, "1 case"),
                ParamClass("case", 5, "5 cases"),
                ParamClass("man", 0, "0 men"),
                ParamClass("man", 1, "1 man"),
                ParamClass("man", 2, "2 men"),
                ParamClass("men", 2, "2 men"),
                ParamClass("process", 2, "2 processes"),
                ParamClass("process", 1, "1 process"),
                ParamClass("processes", 2, "2 processes"),
                ParamClass("processes", 1, "1 process"))

        givenData(data) {
            on("calling toQuantity with quantity ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity, showQuantityAs = ShowQuantityAs.Numeric)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }


        data = listOf(
                ParamClass("case", 0, "zero cases"),
                ParamClass("case", 1, "one case"),
                ParamClass("case", 5, "five cases"),
                ParamClass("man", 0, "zero men"),
                ParamClass("man", 1, "one man"),
                ParamClass("man", 2, "two men"),
                ParamClass("men", 2, "two men"),
                ParamClass("process", 2, "two processes"),
                ParamClass("process", 1, "one process"),
                ParamClass("processes", 2, "two processes"),
                ParamClass("processes", 1200, "one thousand two hundred processes"),
                ParamClass("processes", 1, "one process"))

        givenData(data) {
            on("calling truncate with quantity ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity, showQuantityAs = ShowQuantityAs.Words)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        /*
        TODO : Make these tests pass and make Gandalf go away.
        data = listOf(
                ParamClass("case", 1, "1 case", ),
                ParamClass("case", 2, "2 cases", "%,d"),
                ParamClass("case", 123456, "123,456 cases","%,d"),
                ParamClass("case", 123456, "123,456.00 cases", "%,2d"),
                ParamClass("dollar", 0, "$0 dollars", "%f"),
                ParamClass("dollar", 1, "$1 dollar", "%f"),
                ParamClass("dollar", 2, "$2 dollars", "%f"),
                ParamClass("dollar", 2, "$2.00 dollars", "%,2f"))

        givenData(data) {
            on("calling truncate with length ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity, it.format)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("case", 0, "0 cases", "N0", "it-IT"),
                ParamClass("case", 1, "1 case", "N0", "it-IT"),
                ParamClass("case", 2, "2 cases", "N0", "it-IT"),
                ParamClass("case", 1234567, "1.234.567 cases", "N0", "it-IT"),
                ParamClass("case", 1234567, "1.234.567,00 cases", "N2", "it-IT"),
                ParamClass("euro", 0, "0 € euros", "C0", "es-ES"),
                ParamClass("euro", 1, "1 € euro", "C0", "es-ES"),
                ParamClass("euro", 2, "2 € euros", "C0", "es-ES"),
                ParamClass("euro", 2, "2,00 € euros", "C2", "es-ES"))

        givenData(data) {
            on("calling toQuantity with quantity ${it.quantity}", {
                val actual = it.value.toQuantity(it.quantity, it.format, it.culture)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }
        */
    }
}

