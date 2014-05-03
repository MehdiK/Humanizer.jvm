package org.humanizer.jvm.truncators

import org.humanizer.jvm.TruncateFrom

public class FixedNumberOfWordsTruncator {
    fun truncate(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom): String {
        if(length >= value.split("\\s+").count()) return value
        if(truncateFrom == TruncateFrom.Right){
            var t = ""
            var l2 = 0
            value.forEach {
                if (Character.isWhitespace(it)) l2++
                if(length > l2){ t = t+it}
            }
            return "${t}${truncationString}"
        }
        else {
            var t = ""
            var l2 = 0
            value.trimTrailing().reverse().forEach {
                if (Character.isWhitespace(it)) l2++
                if(length > l2){ t = t+it}
            }
            return "${truncationString}${t.reverse()}"
        }
    }
}
