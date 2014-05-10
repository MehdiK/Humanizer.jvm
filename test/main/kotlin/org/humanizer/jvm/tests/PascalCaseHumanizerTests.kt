package org.humanizer.jvm.tests

import org.junit.Test as Test
import kotlin.test.assertEquals
import java.util.ArrayList
import java.util.HashMap
import org.spek.*
import org.humanizer.jvm.humanize
import org.humanizer.jvm.letterCasings.checkAllCaps
import org.humanizer.jvm.letterCasings.LetterCasing

public class PascalCaseHumanizerTests(): Spek() {
    {

        var data = listOf(
        "PascalCaseInputStringIsTurnedIntoSentence" to"Pascal case input string is turned into sentence",
        "WhenIUseAnInputAHere" to"When I use an input a here",
        "10IsInTheBegining" to"10 is in the begining",
        "NumberIsAtTheEnd100" to"Number is at the end 100",
        "XIsFirstWordInTheSentence" to"X is first word in the sentence")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize()
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "Underscored_input_string_is_turned_into_sentence" to"Underscored input string is turned into sentence",
        "Underscored_input_String_is_turned_INTO_sentence" to"Underscored input String is turned INTO sentence")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize()
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "HTML" to"HTML",
        "TheHTMLLanguage" to"The HTML language",
        "HTMLIsTheLanguage" to"HTML is the language",
        "TheLanguageIsHTML" to"The language is HTML",
        "HTML5" to"HTML 5",
        "1HTML" to"1 HTML")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize()
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "CanReturnTitleCase" to"Can Return Title Case",
        "Can_return_title_Case" to"Can Return Title Case",
        "Title_humanization_Honors_ALLCAPS" to"Title Humanization Honors ALLCAPS")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize(LetterCasing.Title)
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "CanReturnLowerCase" to"can return lower case",
        "Can_Return_Lower_Case" to"can return lower case",
        "LOWERCASE" to"lowercase")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize(LetterCasing.LowerCase)
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "CanReturnSentenceCase" to"Can return sentence case",
        "Can_Return_Sentence_Case" to"Can Return Sentence Case",
        "" to"")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize(LetterCasing.Sentence)
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        data = listOf(
        "CanHumanizeIntoUpperCase" to"CAN HUMANIZE INTO UPPER CASE",
        "Can_Humanize_into_Upper_case" to"CAN HUMANIZE INTO UPPER CASE")

        givenData(data) {
            val (input ,expected) = it
            on("calling humanize on $input",{
                val actual = input.humanize(LetterCasing.AllCaps)
                it("should become ${it.component2()}",{
                    shouldEqual(expected, actual)
                })
            })
        }

        given("A word in all caps"){
            on("calling checkAllCaps", {
                it("should be true", {
                    shouldEqual(true, "HTML".checkAllCaps())
                })
            })
        }

        given("A word in all lowercase"){
            on("calling checkAllCaps", {
                it("should be false", {
                    shouldEqual(false, "html".checkAllCaps())
                })
            })
        }

}}








