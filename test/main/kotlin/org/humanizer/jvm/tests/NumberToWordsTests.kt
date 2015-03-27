package org.humanizer.jvm.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.humanizer.jvm.toQuantity
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.toWords
import org.humanizer.jvm.toOrdinalWords
import java.util.Locale

public class NumberToWordsTests() : Spek() {
    init {

        given("en Locale") {
            val currentLocale = Locale.getDefault()
            Locale.setDefault(Locale("en","US"))
            on("numbertoWords for 1", {
                val actual = 1.toWords()
                Locale.setDefault(currentLocale)
                it("should be English one", {
                    shouldEqual("one", actual)
                })
            })
        }

        given("nl Locale") {
            val currentLocale = Locale.getDefault()
            Locale.setDefault(Locale("nl","BE"))
            on("numbertoWords for 1", {
                val actual = 1.toWords()
                Locale.setDefault(currentLocale)
                it("should be Dutch een", {
                    shouldEqual("een", actual)
                })
            })
        }

    }
}
