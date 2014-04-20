package org.humanizer.tests



 fun String.humanize(): String {
     // this is just a template. needs a lot of work.
    return this.replaceAll("[A-Z]", " $0").trim()
 }

