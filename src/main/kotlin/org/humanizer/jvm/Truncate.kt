package org.humanizer.jvm

fun String.truncate(length: Int) : String{
    if(this.length > length) {
        return "${this.substring(0, length-1)}..."
    }
    return this
}