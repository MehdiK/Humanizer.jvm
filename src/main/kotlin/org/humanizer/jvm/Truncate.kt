package org.humanizer.jvm

import org.humanizer.jvm.truncators.truncateFixedLength
import org.humanizer.jvm.truncators.truncateFixedNumberOfCharacters
import org.humanizer.jvm.truncators.truncateFixedNumberOfWords
import org.humanizer.jvm.truncators.UnsupportedTruncatorException


fun String.truncate(length: Int, truncationString: String = "…", truncator: Truncator = Truncator.FixedLength, truncateFrom: TruncateFrom = TruncateFrom.Right) : String {
    when (truncator) {
        Truncator.FixedLength -> return truncateFixedLength(this,length,truncationString,truncateFrom)
        Truncator.FixedNumberOfCharacters -> return truncateFixedNumberOfCharacters(this,length,truncationString,truncateFrom)
        Truncator.FixedNumberOfWords -> return truncateFixedNumberOfWords(this,length,truncationString,truncateFrom)
        else -> throw UnsupportedTruncatorException()
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