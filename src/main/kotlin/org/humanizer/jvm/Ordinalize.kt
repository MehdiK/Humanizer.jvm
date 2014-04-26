package org.humanizer.jvm

fun String.ordinalize() : String{
    if(this.endsWith("1") && !this.equals("11")) return this + "st"
    if(this.endsWith("2") && !this.equals("12")) return this + "nd"
    if(this.endsWith("3") && !this.equals("13")) return this + "rd"
    return this + "th"
}

fun Int.ordinalize() : String{
    return this.toString().ordinalize()
}

