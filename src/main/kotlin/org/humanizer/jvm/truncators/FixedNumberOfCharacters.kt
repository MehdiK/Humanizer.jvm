package org.humanizer.jvm.truncators

import org.humanizer.jvm.TruncateFrom

public class FixedNumberOfCharactersTruncator
{
    fun truncate(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom) : String {
        var adjustedLength = length - (truncationString.length - 1)
        var adjustedTruncationString = truncationString
        if (adjustedLength <= 0) {
            adjustedLength = length + 1
            adjustedTruncationString = ""
        }
        if (length >= value.count { Character.isLetterOrDigit(it) }) return value
        if(truncateFrom == TruncateFrom.Right) {
            var t = ""
            var l2 = 0
            value.forEach {
                if (Character.isLetterOrDigit(it)) l2++
                if (adjustedLength > l2) {
                    t = t + it
                }
            }
            return "${t}${adjustedTruncationString}"
        }
        if(truncateFrom == TruncateFrom.Left) {
            var t = ""
            var l2 = 0
            value.reverse().forEach {
                if (Character.isLetterOrDigit(it)) l2++
                if (adjustedLength > l2) {
                    t = t + it
                }
            }
            return "${adjustedTruncationString}${t.reverse()}"
        }
        return value
    }
}

