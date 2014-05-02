package org.humanizer.jvm

import org.humanizer.jvm.truncators.FixedLengthTruncator
import org.humanizer.jvm.truncators.FixedNumberOfCharactersTruncator
import org.humanizer.jvm.truncators.FixedNumberOfWordsTruncator

fun String.truncate(length: Int) : String{
    return this.truncate(length, Truncator.FixedLength)
}

fun String.truncate(length: Int, truncationString: String) : String {
    return this.truncate(length, Truncator.FixedLength, truncationString)
}

fun String.truncate(length: Int, truncator: Truncator) : String {
    return this.truncate(length, truncator, "…")
}

fun String.truncate(length: Int, truncator: Truncator, truncateFrom: TruncateFrom) : String {
    return this.truncate(length, "…", truncator, truncateFrom)
}

fun String.truncate(length: Int, truncator: Truncator, truncationString: String) : String {
    return this.truncate(length,truncationString,truncator, TruncateFrom.Right)
}

fun String.truncate(length: Int, truncationString: String, truncator: Truncator, truncateFrom: TruncateFrom) : String {
   if(truncator == Truncator.FixedLength){
        return FixedLengthTruncator().truncate(this,length,truncationString,truncateFrom)
    }
    if(truncator == Truncator.FixedNumberOfCharacters) {
        return FixedNumberOfCharactersTruncator().truncate(this,length,truncationString,truncateFrom)
    }
    if(truncator == Truncator.FixedNumberOfWords){
        return FixedNumberOfWordsTruncator().truncate(this,length,truncationString,truncateFrom)
    }
    return this
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