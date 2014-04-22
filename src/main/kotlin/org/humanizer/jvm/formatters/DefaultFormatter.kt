package org.humanizer.jvm.formatters.dateHumanizer

import java.util.Date
import org.humanizer.jvm.getDateDiff
import java.util.concurrent.TimeUnit

public class DefaultDateFormatter() {

    private var suffix: String = "ago"

    private fun makeSuffix(difference: Long)
    {
        suffix = "ago"
        if (difference > 0) suffix = "from now"
    }

    fun secondFormatter(input: Date, toCompareAgainst: Date): String {
        var difference = input.getDateDiff(toCompareAgainst, TimeUnit.SECONDS)
        makeSuffix(difference)
        difference = Math.abs(difference)
        if (difference == 1.toLong()) {
            return "one second " + suffix
        }
        if (difference > 1.toLong() && difference < 60.toLong()) {
            return (difference).toString() + " seconds " + suffix
        }
        return "a minute " + suffix
    }

    fun minuteFormatter(input: Date,toCompareAgainst: Date): String {
        var difference = input.getDateDiff(toCompareAgainst, TimeUnit.MINUTES)
        makeSuffix(difference)
        difference = Math.abs(difference)
        if (difference == 1.toLong()) {
            return "a minute " + suffix
        }
        if (difference > 1.toLong() && difference < 60.toLong()) {
            return (difference).toString() + " minutes " + suffix
        }
        return "an hour " + suffix
    }

    fun hourFormatter(input: Date,toCompareAgainst: Date): String {
        var difference = input.getDateDiff(toCompareAgainst, TimeUnit.HOURS)
        makeSuffix(difference)
        difference = Math.abs(difference)
        if (difference == 1.toLong()) {
            return "an hour " + suffix
        }
        if (difference > 1.toLong() && difference < 24.toLong()) {
            return (difference).toString() + " hours " + suffix
        }
        return "a day " + suffix
    }

    fun dayFormatter(input: Date,toCompareAgainst: Date): String {
        var difference = input.getDateDiff(toCompareAgainst, TimeUnit.DAYS)
        makeSuffix(difference)
        if (difference == -1.toLong()) {
            return "yesterday"
        }
        if (difference == 1.toLong()) {
            return "tomorrow"
        }
        if (Math.abs(difference) > 1.toLong() && Math.abs(difference) < 31.toLong()) {
            return (Math.abs(difference)).toString() + " days " + suffix
        }
        return "one month " + suffix
    }

    fun monthFormatter(input: Date,toCompareAgainst: Date): String {
        var difference = getMonthsDifference(input, toCompareAgainst)
        makeSuffix(difference.toLong())
        difference = Math.abs(difference)
        if (difference == 1) {
            return "one month " + suffix
        }
        if (Math.abs(difference) > 1.toLong() && Math.abs(difference) < 12.toLong()) {
            return (Math.abs(difference)).toString() + " months " + suffix
        }
        return "one year " + suffix
    }

    fun yearFormatter(input: Date,toCompareAgainst: Date): String {
        var difference = input.getYear() - toCompareAgainst.getYear()
        makeSuffix(difference.toLong())
        difference = Math.abs(difference)
        if (difference == 1) {
            return "one year " + suffix
        }
        return (Math.abs(difference)).toString() + " years " + suffix
    }

    private fun getMonthsDifference(date1: Date, date2: Date) : Int
    {
        val m1 = date1.getYear() * 12 + date1.getMonth()
        val m2 = date2.getYear() * 12 + date2.getMonth()
        return m1 - m2;
    }
}
