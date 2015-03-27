package org.humanizer.jvm.tests

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.givenData
import org.humanizer.jvm.truncate
import org.jetbrains.spek.api.shouldEqual
import org.humanizer.jvm.*

public class InflectorTests(): Spek() {
    init {
        var data = listOf(
                "some title" to "Some Title",
                "some-title" to "Some Title",
                "sometitle" to "Sometitle",
                "some-title: The begining" to "Some Title: The Begining",
                "some_title:_the_begining" to "Some Title: The Begining",
                "some title: The_begining" to "Some Title: The Begining")

        givenData(data) {
            val (value, expected) = it
            on("calling titleize on String", {
                val actual = value.titleize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                "some_title" to "some-title",
                "some-title" to "some-title",
                "some_title_goes_here" to "some-title-goes-here",
                "some_title and_another" to "some-title and-another")

        givenData(data) {
            val (value, expected) = it
            on("calling dasherize on String", {
                val actual = value.dasherize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                "some_title" to "some-title",
                "some-title" to "some-title",
                "some_title_goes_here" to "some-title-goes-here",
                "some_title and_another" to "some-title and-another")

        givenData(data) {
            val (value, expected) = it
            on("calling hyphenate on String", {
                val actual = value.hyphenate()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                "customer" to "Customer",
                "CUSTOMER" to "CUSTOMER",
                "CUStomer" to "CUStomer",
                "customer_name" to "CustomerName",
                "customer_first_name" to "CustomerFirstName",
                "customer_first_name_goes_here" to "CustomerFirstNameGoesHere",
                "customer name" to "Customer name")

        givenData(data) {
            val (value, expected) = it
            on("calling pascalize on String", {
                val actual = value.pascalize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                "customer" to "customer",
                "CUSTOMER" to "cUSTOMER",
                "CUStomer" to "cUStomer",
                "customer_name" to "customerName",
                "customer_first_name" to "customerFirstName",
                "customer_first_name_goes_here" to "customerFirstNameGoesHere",
                "customer name" to "customer name")

        givenData(data) {
            val (value, expected) = it
            on("calling camelize on String", {
                val actual = value.camelize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
                "SomeTitle" to "some_title",
                "someTitle" to "some_title",
                "some title" to "some_title",
                "some title that will be underscored" to "some_title_that_will_be_underscored",
                "SomeTitleThatWillBeUnderscored" to "some_title_that_will_be_underscored")

        givenData(data) {
            val (value, expected) = it
            on("calling underscore on String", {
                val actual = value.underscore()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }
    }
}
