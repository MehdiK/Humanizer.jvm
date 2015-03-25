package org.humanizer.jvm

fun String.dehumanize() : String
{
    return this
            .split(" ")
            .let{it.map{it.capitalize()}}
            .join("")
}