package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.humanizer.jvm.humanize
import org.spek.shouldEqual
import org.humanizer.jvm.dehumanize

public class DeHumanizerTests(): Spek() {
    {

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

