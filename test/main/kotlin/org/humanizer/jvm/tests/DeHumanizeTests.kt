package org.humanizer.jvm.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.humanizer.jvm.humanize
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.dehumanize

public class DeHumanizerTests(): Spek() {
    init {

        var data = listOf(
                "Pascal case sentence is camelized" to "PascalCaseSentenceIsCamelized",
                "Title Case Sentence Is Camelized" to "TitleCaseSentenceIsCamelized",
                "Mixed case sentence Is Camelized" to "MixedCaseSentenceIsCamelized",
                "lower case sentence is camelized" to "LowerCaseSentenceIsCamelized",
                "" to "")

        givenData(data) {
            val (input, expected) = it
            on("calling deHumanize on $input", {
                val actual = input.dehumanize()
                it("should become ${it.component2()}", {
                    shouldEqual(expected, actual)
                })
            })
        }
    }
}


