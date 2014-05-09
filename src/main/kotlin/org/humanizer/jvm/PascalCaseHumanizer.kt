package org.humanizer.jvm



 fun String.humanize(letterCasing : LetterCasing = LetterCasing.Sentence): String {
     val regex = "(?<=[a-z])(?=[A-Z0-9])|(?<=[0-9])(?=[A-Za-z])|(?<=[A-Z])(?=[0-9])|(?<=[A-Z])(?=[A-Z][a-z])"

     if(letterCasing == LetterCasing.LowerCase) return this.replaceAll("${regex}|(_)|(-)", " $0").trim().replace("_","").toLowerCase()
     if(letterCasing == LetterCasing.Title) {
         return this
                 .split("${regex}|(_)|(-)")
                 .let{ it.map{ if(it.checkAllCaps() && it.length() > 1) it else it.capitalize()} }
                 .makeString(" ")}
     if(letterCasing == LetterCasing.AllCaps) return this.replaceAll("${regex}|(_)|(-)", " $0").trim().replace("_","").toUpperCase()
     if(letterCasing == LetterCasing.Sentence) {
         if(this.contains("_"))
             return this.replace("_"," ")
         else
            return this
                 .split(regex)
                 .let{ it.map{ if(it.checkAllCaps() && it.length() > 1) it else it.toLowerCase()} }
                 .makeString(" ")
                 .capitalize()
                 .replace(" i ", " I ")}
     return this
 }

fun String.checkAllCaps(): Boolean
{
   return this.all{it.isUpperCase()}
}

fun String.removerUnderscore()
{}

enum class LetterCasing
{
    Title
    AllCaps
    LowerCase
    Sentence
}

