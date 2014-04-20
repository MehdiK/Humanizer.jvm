package org.humanizer.jvm.tests

import org.junit.Test as Test
import kotlin.test.assertEquals
import java.util.ArrayList
import java.util.HashMap
import org.spek.*
import org.humanizer.jvm.humanize
import java.util.Calendar

public class DateHumanizerTests(): Spek() {
    {

        val data = listOf(
                -1 to "one second ago",
                -10 to "10 seconds ago",
                -59 to "59 seconds ago",
                -60 to "one minute ago"
        )

        givenData(data) {
            val (input, expected) = it
            on("calling humanize", {
                val cal = Calendar.getInstance()
                val current = cal.getTime()
                cal.add(Calendar.SECOND,input)
                val actual = cal.getTime().humanize(current)
                it("should become ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

    }}