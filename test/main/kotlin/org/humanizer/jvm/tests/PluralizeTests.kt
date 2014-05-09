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
                "thesaurus" to "thesauri",

                "criterion" to "criteria",
                "perihelion"  to "perihelia",
                "aphelion" to "aphelia",
                "phenomenon" to "phenomena",
                "prolegomenon" to "prolegomena",
                "noumenon" to "noumena",
                "organon" to "organa",
                "asyndeton" to "asyndeta",
                "hyperbaton" to "hyperbata",

                "alumna" to "alumnae",
                "alga" to "algae",
                "vertebra" to "vertebrae",
                "persona" to "personae",

                "albino" to "albinos",
                "archipelago" to "archipelagos",
                "armadillo" to "armadillos",
                "commando" to "commandos",
                "crescendo" to "crescendos",
                "fiasco" to "fiascos",
                "ditto" to "dittos",
                "dynamo" to "dynamos",
                "embryo" to "embryos",
                "ghetto" to "ghettos",
                "guano" to "guanos",
                "inferno" to "infernos",
                "jumbo" to "jumbos",
                "lumbago" to "lumbagos",
                "magneto" to "magnetos",
                "manifesto" to "manifestos",
                "medico" to "medicos",
                "octavo" to "octavos",
                "pro" to "pros",
                "quarto" to "quartos",
                "canto" to "cantos",
                "lingo" to "lingos",
                "generalissimo" to "generalissimos",
                "stylo" to "stylos",
                "rhino" to "rhinos",
                "casino" to "casinos",
                "auto" to "autos",
                "macro" to "macros",
                "zero" to "zeros",

                "solo" to "solos",
                "soprano" to "sopranos",
                "basso" to "bassos",
                "alto" to "altos",
                "contralto" to "contraltos",
                "tempo" to "tempos",
                "piano" to "pianos",
                "virtuoso" to "virtuosos",

                "stamen" to "stamina",
                "foramen" to "foramina",
                "lumen" to "lumina",

                "anathema" to "anathemas",
                "enema" to "enemas",
                "oedema" to "oedemas",
                "bema" to "bemas",
                "enigma" to "enigmas",
                "sarcoma" to "sarcomas",
                "carcinoma" to "carcinomas",
                "gumma" to "gummas",
                "schema" to "schemas",
                "charisma" to "charismas",
                "lemma" to "lemmas",
                "soma" to "somas",
                "diploma" to "diplomas",
                "lymphoma" to "lymphomas",
                "stigma" to "stigmas",
                "dogma" to "dogmas",
                "magma" to "magmas",
                "stoma" to "stomas",
                "drama" to "dramas",
                "melisma" to "melismas",
                "trauma" to "traumas",
                "edema" to "edemas",
                "miasma" to "miasmas",

                "afreet" to "afreeti",
                "afrit" to "afriti",
                "efreet" to "efreeti",

                "cherub" to "cherubim",
                "goy" to "goyim",
                "seraph" to "seraphim",

                "human" to "humans",
                "Alabaman" to "Alabamans",
                "Bahaman" to "Bahamans",
                "Burman" to "Burmans",
                "German" to "Germans",
                "Hiroshiman" to "Hiroshimans",
                "Liman" to "Limans",
                "Nakayaman" to "Nakayamans",
                "Oklahoman" to "Oklahomans",
                "Panaman" to "Panamans",
                "Selman" to "Selmans",
                "Sonaman" to "Sonamans",
                "Tacoman" to "Tacomans",
                "Yakiman" to "Yakimans",
                "Yokohaman" to "Yokohamans",
                "Yuman" to "Yumans"
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
                val doubles = data.groupBy { it.component1() }.map {
                    val key = it.key
                    val count = data.count { it.first == key }
                    Pair(key, count)
                }.filter { it.second > 1 }.map { it.first }.makeString(",")
                it("should be empty for all groups", {
                    shouldEqual("", doubles)
                })
            })
        }
    }
}
