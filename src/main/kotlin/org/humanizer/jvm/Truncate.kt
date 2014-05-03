package org.humanizer.jvm

import org.humanizer.jvm.truncators.FixedLengthTruncator
import org.humanizer.jvm.truncators.FixedNumberOfCharactersTruncator
import org.humanizer.jvm.truncators.FixedNumberOfWordsTruncator


fun String.truncate(length: Int, truncationString: String = "…", truncator: Truncator = Truncator.FixedLength, truncateFrom: TruncateFrom = TruncateFrom.Right) : String {
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