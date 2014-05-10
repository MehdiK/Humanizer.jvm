package org.humanizer.jvm

import org.humanizer.jvm.letterCasings.*

fun String.humanize(letterCasing : LetterCasing = LetterCasing.Sentence): String {
     when (letterCasing) {
         LetterCasing.LowerCase -> return this.letterCasingLowerCase()
         LetterCasing.AllCaps -> return this.letterCasingUpperCase()
         LetterCasing.Title -> return this.letterCasingTitle()
         LetterCasing.Sentence -> return this.letterCasingSentence()
     }
    return this
 }



