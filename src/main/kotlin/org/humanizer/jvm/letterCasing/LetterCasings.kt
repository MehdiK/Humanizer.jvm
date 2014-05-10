package org.humanizer.jvm.letterCasings

fun letterCasingRegex(suffix:String = "") : String{
    return "(?<=[a-z])(?=[A-Z0-9])|(?<=[0-9])(?=[A-Za-z])|(?<=[A-Z])(?=[0-9])|(?<=[A-Z])(?=[A-Z][a-z])$suffix"
}

fun String.checkAllCaps(): Boolean
{
    return this.all{it.isUpperCase()}
}

fun String.letterCasingUpperCase() : String {
    return this
            .replaceAll(letterCasingRegex("|(_)|(-)"), " $0")
            .trim()
            .replace("_","")
            .toUpperCase()
}

fun String.letterCasingTitle(): String {
    return this
            .split(letterCasingRegex("|(_)|(-)"))
            .let{ it.map{ if(it.checkAllCaps() && it.length() > 1) it else it.capitalize()} }
            .makeString(" ")
}

fun String.letterCasingLowerCase() : String {
    return this
            .replaceAll(letterCasingRegex("|(_)|(-)"), " $0")
            .trim()
            .replace("_","")
            .toLowerCase()
}

fun String.letterCasingSentence(): String {
    if(this.contains("_"))
        return this.replace("_"," ")
    else
        return this
                .split(letterCasingRegex())
                .let{ it.map{ if(it.checkAllCaps() && it.length() > 1) it else it.toLowerCase()} }
                .makeString(" ")
                .capitalize()
                .replace(" i ", " I ")
}

enum class LetterCasing {
    Title
    AllCaps
    LowerCase
    Sentence
}


