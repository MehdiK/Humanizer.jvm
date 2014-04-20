package org.humanizer.jvm

import java.util.Date
import java.util.concurrent.TimeUnit

fun Date.humanize(toCompareAgainst: Date): String {
    val difference = this.getDateDiff(toCompareAgainst, TimeUnit.SECONDS)
    if (difference == -1.toLong())
    {
        return "one second ago"
    }
    if (difference < -1.toLong() && difference > -60.toLong())
    {
        return (-difference).toString() + " seconds ago"
    }
    if (difference == -60.toLong())
    {
        return "one minute ago"
    }
    return "None of the above"
}

// based on this SO answer http://stackoverflow.com/a/10650881
fun Date.getDateDiff(date2:Date, timeUnit:TimeUnit): Long
{
    val diffInMillies = this.getTime() - date2.getTime()
    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS)
}
