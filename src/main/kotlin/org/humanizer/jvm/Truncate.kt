package org.humanizer.jvm

fun String.truncate(length: Int) : String{
    return this.truncate(length, Truncator.FixedLength)
}

fun String.truncate(length: Int, truncator: Truncator) : String{
    if(truncator == Truncator.FixedLength){
        if(this.length > length) {
            return "${this.substring(0, length - 1)}…"
        }
        return this
    }
    if(truncator == Truncator.FixedNumberOfCharacters) {
        var l = 0
        for (c in this)
            if (Character.isLetterOrDigit(c)) l++
        if(length < l) {
            var t = ""
            var l2 = 0
            for (c in this) {
                if (Character.isLetterOrDigit(c)) l2++
                if(length > l2){ t = t+c}
            }
            return "${t}…"
        }
        return this
    }
    if(truncator == Truncator.FixedNumberOfWords){
        if(length < this.split("\\s+").count()) {
            var t = ""
            var l2 = 0
            for (c in this) {
                if (Character.isWhitespace(c)) l2++
                if(length > l2){ t = t+c}
            }
            return "${t}…"
        }
        return this
    }
    return this
}

enum class Truncator {
    FixedLength
    FixedNumberOfCharacters
    FixedNumberOfWords
}