package org.humanizer.jvm.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.humanizer.jvm.humanize
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.dehumanize
import org.humanizer.jvm.milliSecondsToTimespan

public class TimeSpanTests(): Spek() {
    init {

        var data = listOf(
                1 to "0 seconds",
                1000 to "1 second",
                5000 to "5 seconds",
                60000 to "1 minute and 0 seconds",
                61000 to "1 minute and 1 second",
                65000 to "1 minute and 5 seconds",
                120000 to "2 minutes and 0 seconds",
                121000 to "2 minutes and 1 second",
                125000 to "2 minutes and 5 seconds",
                3600000 to "1 hour and 0 minutes and 0 seconds",
                3615000 to "1 hour and 0 minutes and 15 seconds",
                7200000 to "2 hours and 0 minutes and 0 seconds",
                86400000 to "1 day and 0 hours and 0 minutes and 0 seconds",
                99999999 to "1 day and 3 hours and 46 minutes and 39 seconds")

        givenData(data) {
            val (input, expected) = it
            on("calling toTimespan on $input", {
                val actual = input.milliSecondsToTimespan()
                it("should become ${it.component2()}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                1 to "0 seconds and 1 millisecond",
                1000 to "1 second and 0 milliseconds",
                5000 to "5 seconds and 0 milliseconds",
                60000 to "1 minute and 0 seconds and 0 milliseconds",
                61000 to "1 minute and 1 second and 0 milliseconds",
                65000 to "1 minute and 5 seconds and 0 milliseconds",
                120000 to "2 minutes and 0 seconds and 0 milliseconds",
                121000 to "2 minutes and 1 second and 0 milliseconds",
                125000 to "2 minutes and 5 seconds and 0 milliseconds",
                3600000 to "1 hour and 0 minutes and 0 seconds and 0 milliseconds",
                3615000 to "1 hour and 0 minutes and 15 seconds and 0 milliseconds",
                7200000 to "2 hours and 0 minutes and 0 seconds and 0 milliseconds",
                86400000 to "1 day and 0 hours and 0 minutes and 0 seconds and 0 milliseconds",
                99999999 to "1 day and 3 hours and 46 minutes and 39 seconds and 999 milliseconds")

        givenData(data) {
            val (input, expected) = it
            on("calling toTimespan on $input", {
                val actual = input.milliSecondsToTimespan(true)
                it("should become ${it.component2()}", {
                    shouldEqual(expected, actual)
                })
            })
        }
    }
}

