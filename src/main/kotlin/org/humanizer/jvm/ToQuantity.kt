package org.humanizer.jvm

import java.util.Locale
import java.text.NumberFormat

fun String.toQuantity(quantity: Int, showQuantityAs: ShowQuantityAs = ShowQuantityAs.Numeric) : String
{
    if(showQuantityAs == ShowQuantityAs.Numeric)
    {
        var formattedQuantity = quantity.toString()
        if(quantity == 1 || quantity == -1) return "$formattedQuantity ${this.singularize(Plurality.CouldBeEither)}"
        return "$formattedQuantity ${this.pluralize(Plurality.CouldBeEither)}"
    }
    if(showQuantityAs == ShowQuantityAs.None)
    {
        if(quantity == 1 || quantity == -1) return "${this.singularize(Plurality.CouldBeEither)}"
        return this.pluralize(Plurality.CouldBeEither)
    }
    if(showQuantityAs == ShowQuantityAs.Words)
    {
        if(quantity == 1 || quantity == -1) return "${quantity.toWords()} ${this.singularize(Plurality.CouldBeEither)}"
        return "${quantity.toWords()} ${this.pluralize(Plurality.CouldBeEither)}"
    }
    return this
}

fun Int.toQuantity(unit: String, showQuantityAs: ShowQuantityAs = ShowQuantityAs.Numeric) : String
{
    return unit.toQuantity(this, showQuantityAs)
}

enum class ShowQuantityAs
{
        None
        Numeric
        Words
}
