package org.humanizer.jvm.tests

import org.spek.Spek
import org.spek.givenData
import org.humanizer.jvm.titleize
import org.spek.shouldEqual
import org.humanizer.jvm.pluralize
import org.humanizer.jvm.singularize
import java.util.GregorianCalendar
import java.util.Calendar
import org.humanizer.jvm.humanize
import java.util.ArrayList

public class PluralizeTests() : Spek() {
    {
        var data = listOf(
                "search" to  "searches",
                "switch" to  "switches",
                "fix" to  "fixes",
                "box" to  "boxes",
                "process" to  "processes",
                "address" to  "addresses",
                "case" to  "cases",
                "stack" to  "stacks",
                "wish" to  "wishes",
                "fish" to  "fish",

                "category" to  "categories",
                "query" to  "queries",
                "ability" to  "abilities",
                "agency" to  "agencies",
                "movie" to  "movies",

                "archive" to  "archives",

                "index" to  "indices",

                "wife" to  "wives",
                "safe" to  "saves",
                "half" to  "halves",

                "move" to  "moves",

                "salesperson" to  "salespeople",
                "person" to  "people",

                "spokesman" to  "spokesmen",
                "man" to  "men",
                "woman" to  "women",

                "basis" to  "bases",
                "diagnosis" to  "diagnoses",

                "datum" to  "data",
                "medium" to  "media",
                "analysis" to  "analyses",

                "node_child" to  "node_children",
                "child" to  "children",

                "experience" to  "experiences",
                "day" to  "days",

                "comment" to  "comments",
                "foobar" to  "foobars",
                "newsletter" to  "newsletters",

                "old_news" to  "old_news",
                "news" to  "news",

                "series" to  "series",
                "species" to  "species",

                "quiz" to  "quizzes",

                "perspective" to  "perspectives",

                "ox" to  "oxen",
                "photo" to  "photos",
                "buffalo" to  "buffaloes",
                "tomato" to  "tomatoes",
                "dwarf" to  "dwarves",
                "elf" to  "elves",
                "information" to  "information",
                "equipment" to  "equipment",
                "bus" to  "buses",
                "status" to  "statuses",
                "status_code" to  "status_codes",
                "mouse" to  "mice",

                "louse" to  "lice",
                "house" to  "houses",
                "octopus" to  "octopi",
                "virus" to  "viri",
                "alias" to  "aliases",
                "portfolio" to  "portfolios",

                "vertex" to  "vertices",
                "matrix" to  "matrices",

                "axis" to  "axes",
                "testis" to  "testes",
                "crisis" to  "crises",

                "rice" to  "rice",
                "shoe" to  "shoes",

                "horse" to  "horses",
                "prize" to  "prizes",
                "edge" to  "edges",

                "deer" to  "deer",
                "sheep" to  "sheep",
                "wolf" to  "wolves",

                "codex" to "codices",

                "radix" to "radices",

                "bacterium" to "bacteria",
                "agendum" to "agenda",
                "desideratum" to "desiderata",
                "erratum" to "errata",
                "stratum" to "strata",
                "ovum" to "ova",
                "extremum" to "extrema",
                "candelabrum" to "candelabra",

                "alumnus" to "alumni",
                "alveolus" to "alveoli",
                "bacillus" to "bacilli",
                "bronchus" to "bronchi",
                "locus" to "loci",
                "nucleus" to "nuclei",
                "stimulus" to "stimuli",
                "meniscus" to "menisci",
                "thesaurus" to "thesauri"
        )

        givenData(data) {
            val (value, expected) = it
            on("calling pluralize on String", {
                val actual = value.pluralize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        givenData(data) {
            val (expected, value) = it
            on("calling singularize on String", {
                val actual = value.singularize()
                it("should be ${expected}", {
                    shouldEqual(expected, actual)
                })
            })
        }

        given("datalist should not contain doubles") {
            on("grouping by plural", {
                val grouped = data.groupBy { it.component1() }
                val counts = ArrayList<Pair<String, Int>>()
                grouped.mapTo(counts,{
                    val key = it.key
                    val count = data.count{it.first == key}
                    Pair(key ,count)
                } )
                it("should be empty for all groups", {
                    //if not it will show you which values are doubles, which is clever
                    shouldEqual("", counts.filter { it.second > 1 }.map { it.first}.makeString(","))
                })
            })
        }
    }
}
