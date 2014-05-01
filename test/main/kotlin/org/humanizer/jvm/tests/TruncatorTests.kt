package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.spek.shouldEqual
import org.humanizer.jvm.truncate
import org.humanizer.jvm.Truncator


public class TruncateTests(): Spek() {

    data class ParamClass(val value: String
                          , val length: Int
                          , val expected: String) {    }
    {

        var data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text longer than truncate length", 10, "Text long…"),
                ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length"),
                ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length"))

        givenData(data) {
            on("calling truncate with length ${it.length}", {
                val actual = it.value.truncate(it.length)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text longer than truncate length", 10, "Text long…"),
                ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length"),
                ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length"))

        givenData(data) {
            on("calling truncate with length ${it.length} and FixedLength", {
                val actual = it.value.truncate(it.length, Truncator.FixedLength)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, ""),
        ParamClass("a", 1, "a"),
        ParamClass("Text with more characters than truncate length", 10, "Text with m…"),
        ParamClass("Text with number of characters equal to truncate length", 47, "Text with number of characters equal to truncate length"),
        ParamClass("Text with less characters than truncate length", 41, "Text with less characters than truncate length"))


        givenData(data) {
            on("calling truncate with length ${it.length} and FixedNumberOfCharacters", {
                val actual = it.value.truncate(it.length, Truncator.FixedNumberOfCharacters)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text with more words than truncate length", 4, "Text with more words…"),
                ParamClass("Text with number of words equal to truncate length", 9, "Text with number of words equal to truncate length"),
                ParamClass("Text with less words than truncate length", 8, "Text with less words than truncate length"),
                ParamClass("Words are\nsplit\rby\twhitespace", 4, "Words are\nsplit\rby…"))


        givenData(data) {
            on("calling truncate with length ${it.length} and FixedNumberOfWords", {
                val actual = it.value.truncate(it.length, Truncator.FixedNumberOfWords)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }
    }
}
     
