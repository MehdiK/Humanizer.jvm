package org.humanizer.jvm

import org.humanizer.jvm.truncators.*
import org.humanizer.jvm.exceptions.UnsupportedTruncatorException

fun String.truncate(length: Int, truncationString: String = "…", truncator: Truncator = Truncator.FixedLength, truncateFrom: TruncateFrom = TruncateFrom.Right) : String {
    when (truncator) {
        Truncator.FixedLength -> return truncateFixedLength(this,length,truncationString,truncateFrom)
        Truncator.FixedNumberOfCharacters -> return truncateFixedNumberOfCharacters(this,length,truncationString,truncateFrom)
        Truncator.FixedNumberOfWords -> return truncateFixedNumberOfWords(this,length,truncationString,truncateFrom)
        else -> throw UnsupportedTruncatorException()
    }
}