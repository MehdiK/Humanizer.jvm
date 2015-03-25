package org.humanizer.jvm

fun truncateFixedLength(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom) : String
{
    var adjustedLength = length - (truncationString.length() - 1)
    var adjustedTruncationString = truncationString
    if(adjustedLength <= 0) {
        adjustedLength = length + 1
        adjustedTruncationString = ""
    }
    if (value.length() <= length) return value
    if (truncateFrom == TruncateFrom.Left) return "${adjustedTruncationString}${value.substring(value.length() - adjustedLength + 1, value.length())}"
    return "${value.substring(0, adjustedLength - 1)}${adjustedTruncationString}"
}

fun truncateFixedNumberOfCharacters(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom) : String {
    var adjustedLength = length - (truncationString.length() - 1)
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
    else {
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
}

fun truncateFixedNumberOfWords(value: String, length: Int, truncationString: String, truncateFrom: TruncateFrom): String {
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
        value.trimEnd().reverse().forEach {
            if (Character.isWhitespace(it)) l2++
            if(length > l2){ t = t+it}
        }
        return "${truncationString}${t.reverse()}"
    }
}

enum class Truncator {
    FixedLength
    FixedNumberOfCharacters
    FixedNumberOfWords
}

enum class TruncateFrom {
    Left
    Right
}
