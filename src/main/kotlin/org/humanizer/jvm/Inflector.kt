package org.humanizer.jvm

fun String.camelize() : String{
    var previousWasUnderscore = false
    var t = ""
    this.decapitalize().forEach {
        if (it.toString().equals("_")) previousWasUnderscore = true
        if(Character.isLetterOrDigit(it) && previousWasUnderscore) {
            previousWasUnderscore = false
            t = "${t}${it.toString().toUpperCase()}"
        }
        else
        {
            t = "${t}${it}"
        }
    }
    return t.replace("_","")
}

fun String.pascalize() : String{
    var previousWasUnderscore = false
    var t = ""
    this.capitalize().forEach {
        if (it.toString().equals("_")) previousWasUnderscore = true
        if(Character.isLetterOrDigit(it) && previousWasUnderscore) {
            previousWasUnderscore = false
            t = "${t}${it.toString().toUpperCase()}"
        }
        else
        {
            t = "${t}${it}"
        }
    }
    return t.replace("_","")
}

fun String.underscore() : String{
    var previousWasCapital = false
    var t = ""
    this.decapitalize().forEach {
        if (Character.isUpperCase(it)) previousWasCapital = true
        if(Character.isLetterOrDigit(it) && previousWasCapital) {
            previousWasCapital = false
            t = "${t}_${it.toString().toLowerCase()}"
        }
        else
        {
            t = "${t}${it}"
        }
    }
    return t.replace(" ","_")
}

fun String.titleize() : String{
    var previousWasWhitespace = false
    var t = ""
    this.replace("-"," ").replace("_", " ").capitalize()
            .forEach {
        if (Character.isWhitespace(it) || !Character.isLetterOrDigit(it)) previousWasWhitespace = true
        if(Character.isLetterOrDigit(it) && previousWasWhitespace) {
            previousWasWhitespace = false
            t = "${t}${it.toString().toUpperCase()}"
        }
        else
        {
            t = "${t}${it}"
        }
    }
    return t
}

fun String.dasherize() : String{
    return this.replace("_", "-")
}

fun String.hyphenate() : String{
    return this.replace("_", "-")
}

