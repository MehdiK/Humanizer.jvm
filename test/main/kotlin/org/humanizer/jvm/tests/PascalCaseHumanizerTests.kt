package org.humanizer.tests.tests

import org.junit.Test as Test
import kotlin.test.assertEquals
import java.util.ArrayList
import java.util.HashMap
import org.spek.*
import org.humanizer.tests.humanize

public class PascalHumanizerTests(): Spek() {
    {

    val data = listOf(
            "ThisIsATest" to "This Is A Test",
            "ThisIsAnotherTest" to "This Is Another Test"
            )

    givenData(data) {
        val (input, expected) = it
        on("calling humanize", {
            val actual = input.humanize()
            it("should become ${it.component2()}", {
                shouldEqual(expected, actual)
            })
        })
    }

}}








