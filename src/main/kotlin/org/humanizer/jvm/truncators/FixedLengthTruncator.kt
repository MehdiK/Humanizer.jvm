package org.humanizer.jvm.truncators

import org.humanizer.jvm.Truncator
import org.humanizer.jvm.TruncateFrom

public class FixedLengthTruncator
{
    fun truncate(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom) : String
    {
        var adjustedLength = length - (truncationString.length - 1)
        var adjustedTruncationString = truncationString
        if(adjustedLength <= 0) {
            adjustedLength = length + 1
            adjustedTruncationString = ""
        }
        if (value.length <= length) return value
        if (truncateFrom == TruncateFrom.Left) return "${adjustedTruncationString}${value.substring(value.length - adjustedLength + 1, value.length)}"
        return "${value.substring(0, adjustedLength - 1)}${adjustedTruncationString}"
    }
}
