package org.humanizer.jvm

import org.humanizer.jvm.localisation
import java.util.Locale

fun Int.toWords(): String {
    return this.toLong().toWords()
}

fun Long.toWords(): String {
    when(Locale.getDefault().getLanguage()) {
        "nl" -> return localisation.nl.NumberToWords().toWords(this)
        else -> return localisation.en.NumberToWords().toWords(this)
    }
}

fun Int.toOrdinalWords(): String {
    when(Locale.getDefault().getLanguage()) {
        "nl" -> return localisation.nl.NumberToWords().toOrdinalWords(this)
        else -> return localisation.en.NumberToWords().toOrdinalWords(this)
    }
}

