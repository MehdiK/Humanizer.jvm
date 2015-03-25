package org.humanizer.jvm.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.truncate
import org.humanizer.jvm.TruncateFrom
import org.humanizer.jvm.Truncator


public class TruncateTests(): Spek() {

    data class ParamClass(val value: String
                          , val length: Int
                          , val expected: String
                          , val truncationString: String = "…") {
        override fun toString(): String {
            return "\"$value\" and truncation string $truncationString"
        }



    }
    init {

        var data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text longer than truncate length", 10, "Text long…"),
                ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length"),
                ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length"))

        givenData(data) {
            on("calling truncate with length ${it.length}", {
                val actual = it.value.truncate(it.length)
                it("should be \"${it.expected}\"", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
                ParamClass("", 10, ""),
                ParamClass("a", 1, "a"),
                ParamClass("Text longer than truncate length", 10, "…te length"),
                ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length"),
                ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length"))

        givenData(data) {
            on("calling truncate with length ${it.length} and TruncateFrom.Left", {
                val actual = it.value.truncate(it.length, truncateFrom = TruncateFrom.Left)
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
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedLength)
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
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfCharacters)
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
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfWords)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
            ParamClass("", 10, "", "..."),
            ParamClass("a", 1, "a", "..."),
            ParamClass("Text longer than truncate length", 10, "Text lo...", "..."),
            ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length", "..."),
            ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length", "..."),
            ParamClass("Text with delimiter length greater than truncate length truncates to fixed length without truncation string", 2, "Te", "...")
        )

        givenData(data) {
            on("calling truncate with length ${it.length} and truncationString ${it.truncationString}", {
                val actual = it.value.truncate(it.length, it.truncationString)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }



        data = listOf(
            ParamClass("", 10, "", "..."),
            ParamClass("a", 1, "a", "..."),
            ParamClass("Text longer than truncate length", 10, "Text lo...", "..."),
            ParamClass("Text with different truncation string", 10, "Text wi---", "---"),
            ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length", "..."),
            ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length", "..."),
            ParamClass("Text with delimiter length greater than truncate length truncates to fixed length without truncation string", 2, "Te", "...")
        )
        givenData(data) {
            on("calling truncate with length ${it.length} and truncationString ${it.truncationString} for FixedLength", {
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedLength, truncationString = it.truncationString)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, "", "..."),
        ParamClass("a", 1, "a", "..."),
        ParamClass("Text with more characters than truncate length", 10, "Text wit...", "..."),
        ParamClass("Text with different truncation string", 10, "Text wit---", "---"),
        ParamClass("Text with number of characters equal to truncate length", 47, "Text with number of characters equal to truncate length", "..."),
        ParamClass("Text with less characters than truncate length", 41, "Text with less characters than truncate length", "..."),
        ParamClass("Text with delimiter length greater than truncate length truncates to fixed length without truncation string", 2, "Te", "...")
        )

        givenData(data) {
                    on("calling truncate with length ${it.length} and truncationString ${it.truncationString} for FixedNumberOfCharacters", {
                        val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfCharacters, truncationString = it.truncationString)
                        it("should be ${it.expected}", {
                            shouldEqual(it.expected, actual)
                        })
                    })
                }

        data = listOf(
        ParamClass("", 10, "", "..."),
        ParamClass("a", 1, "a", "..."),
        ParamClass("Text with more words than truncate length", 4, "Text with more words...", "..."),
        ParamClass("Text with different truncation string", 4, "Text with different truncation---", "---"),
        ParamClass("Text with number of words equal to truncate length", 9, "Text with number of words equal to truncate length", "..."),
        ParamClass("Text with less words than truncate length", 8, "Text with less words than truncate length", "..."),
        ParamClass("Words are\nsplit\rby\twhitespace", 4, "Words are\nsplit\rby...", "...")
        )

        givenData(data) {
            on("calling truncate with length ${it.length} and truncationString ${it.truncationString} for FixedNumberOfWords", {
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfWords, truncationString = it.truncationString)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, ""),
        ParamClass("a", 1, "a"),
        ParamClass("Text longer than truncate length", 10, "…te length"),
        ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length"),
        ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length"))

        givenData(data) {
            on("calling truncate with length ${it.length} and FixedLength and Truncate from Left", {
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedLength, truncateFrom = TruncateFrom.Left)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, ""),
        ParamClass("a", 1, "a"),
        ParamClass("Text with more characters than truncate length", 10, "…ate length"),
        ParamClass("Text with number of characters equal to truncate length", 47, "Text with number of characters equal to truncate length"),
        ParamClass("Text with less characters than truncate length", 41, "Text with less characters than truncate length"),
        ParamClass("Text with strange characters ^$(*^ and more ^$**)%  ", 10, "…rs ^$(*^ and more ^$**)%  "))

        givenData(data) {
            on("calling truncate with length ${it.length} and FixedNumberOfCharacters and Truncate from Left", {
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfCharacters, truncateFrom = TruncateFrom.Left)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, ""),
        ParamClass("a", 1, "a"),
        ParamClass("Text with more words than truncate length", 4, "…words than truncate length"),
        ParamClass("Text with number of words equal to truncate length", 9, "Text with number of words equal to truncate length"),
        ParamClass("Text with less words than truncate length", 8, "Text with less words than truncate length"),
        ParamClass("Words are\nsplit\rby\twhitespace", 4, "…are\nsplit\rby\twhitespace"),
        ParamClass("Text with whitespace at the end  ", 4, "…whitespace at the end"))

        givenData(data) {
            on("calling truncate with length ${it.length} and FixedNumberOfWords and Truncate from Left", {
                val actual = it.value.truncate(it.length, truncator = Truncator.FixedNumberOfWords, truncateFrom = TruncateFrom.Left)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, "", "..."),
        ParamClass("a", 1, "a", "..."),
        ParamClass("Text longer than truncate length", 10, "... length", "..."),
        ParamClass("Text with different truncation string", 10, "--- string", "---"),
        ParamClass("Text with length equal to truncate length", 41, "Text with length equal to truncate length", "..."),
        ParamClass("Text smaller than truncate length", 34, "Text smaller than truncate length", "..."),
        ParamClass("Text with delimiter length greater than truncate length truncates to fixed length without truncation string", 2, "ng", "..."))

        givenData(data) {
            on("calling truncate with length ${it.length} and truncationstring ${it.truncationString} and FixedLength and Truncate from Left", {
                val actual = it.value.truncate(it.length, it.truncationString, Truncator.FixedLength, TruncateFrom.Left)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

        data = listOf(
        ParamClass("", 10, "", "..."),
        ParamClass("a", 1, "a", "..."),
        ParamClass("Text with more characters than truncate length", 10, "...e length", "..."),
        ParamClass("Text with different truncation string", 10, "---n string", "---"),
        ParamClass("Text with number of characters equal to truncate length", 47, "Text with number of characters equal to truncate length", "..."),
        ParamClass("Text with less characters than truncate length", 41, "Text with less characters than truncate length", "..."),
        ParamClass("Text with delimiter length greater than truncate length truncates to fixed number of characters without truncation string", 2, "ng", "..."))

                givenData(data) {
                    on("calling truncate with length ${it.length} and truncationstring ${it.truncationString} and FixedNumberOfCharacters and Truncate from Left", {
                        val actual = it.value.truncate(it.length, it.truncationString, Truncator.FixedNumberOfCharacters, TruncateFrom.Left)
                        it("should be ${it.expected}", {
                            shouldEqual(it.expected, actual)
                        })
                    })
                }

        data = listOf(
        ParamClass("", 10, "", "..."),
        ParamClass("a", 1, "a", "..."),
        ParamClass("Text with more words than truncate length", 4, "...words than truncate length", "..."),
        ParamClass("Text with different truncation string", 4, "---with different truncation string", "---"),
        ParamClass("Text with number of words equal to truncate length", 9, "Text with number of words equal to truncate length", "..."),
        ParamClass("Text with less words than truncate length", 8, "Text with less words than truncate length", "..."),
        ParamClass("Words are\nsplit\rby\twhitespace", 4, "...are\nsplit\rby\twhitespace", "..."),
        ParamClass("Text with whitespace at the end  ", 4, "...whitespace at the end", "..."))

        givenData(data) {
            on("calling truncate with length ${it.length} and truncationstring ${it.truncationString} and FixedNumberOfWords and Truncate from Left", {
                val actual = it.value.truncate(it.length, it.truncationString, Truncator.FixedNumberOfWords, TruncateFrom.Left)
                it("should be ${it.expected}", {
                    shouldEqual(it.expected, actual)
                })
            })
        }

    }
}
     
