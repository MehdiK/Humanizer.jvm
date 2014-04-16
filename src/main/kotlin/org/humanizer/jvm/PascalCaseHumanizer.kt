package org.humanizer.jvm



 fun String.humanize(): String {
     // this is just a template. needs a lot of work.
    return this.replaceAll("[A-Z]", " $0").trim()
 }

