package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.spek.shouldEqual
import org.humanizer.jvm.truncate


public class TruncateTests(): Spek() {

    data class ParamClass(val value: String
                          , val length: Int
                          , val expected: String) {    }
    {

        val data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text longer than truncate length", 10, "Text long..."),
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
    }
}
     
