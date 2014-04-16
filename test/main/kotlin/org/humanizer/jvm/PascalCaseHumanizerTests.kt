package org.humanizer.jvm

import org.junit.Test as Test
import kotlin.test.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import java.util.ArrayList
import java.util.HashMap

public class PascalHumanizerTests() {

    Test
    public fun canHumanizeStringInPascalCase() {
        val inputs =  hashMapOf(
                "ThisIsATest" to "This Is A Test",
                "ThisIsAnotherTest" to "This Is Another Test"
                )
        inputs.forEach {
            val result = it.key.humanize()
            assertEquals(it.value, result)
        }
    }



}



