![Logo](https://raw.github.com/MehdiK/Humanizer/master/logo.png)

Humanizer.jvm is an adaptation of the humanizer framework for .Net which is made for the jvm and is written in Kotlin.
Humanizer.jvm meets all your jvm needs for manipulating and displaying strings, enums, dates, times, timespans, numbers and quantities.

The current build status on the CI server is [![status](http://teamcity.jetbrains.com/app/rest/builds/buildType:(id:HumanizerJvm_FullBuildandTests)/statusIcon)](http://teamcity.jetbrains.com/viewType.html?buildTypeId=HumanizerJvm_FullBuildAndTests&guest=1)

# Table of contents
 - [Features](#features)
   - [Humanize date](#humanize-date)
   - [Ordinalize](#ordinalize)
   - [Truncate](#truncate)
   - [Inflector](#inflector)
   - [Number to words](#numbertowords)
   - [To quantity](#toquantity)
   - [Humanize](#humanize)
   - [DeHumanize](#dehumanize)
   - [Roman numerals](#romannumerals)

# <a id="features">Features</a>

## <a id="humanize-date">Humanize date</a>

### Extension methods Humanize for Java.Util.Date objects

You can `Humanize` an instance of `Java.Util.Date` and get back a string telling how far back or forward in time that is compared to a given date:

```kotlin
val cal = GregorianCalendar()
val dateToUse = GregorianCalendar(2014,Calendar.JANUARY, 5).getTime()
cal.setTime(dateToUse)
cal.add(Calendar.DATE, -1)
cal.getTime().Humanize(dateToUse) => "yesterday"
cal.add(Calendar.HOURS, -2)
cal.getTime.Humanize(dateToUse) => "2 hours ago"

cal.add(Calendar.HOURS, 30)
cal.Humanize(dateToUse) => "tomorrow"
cal.getTime.add(Calendar.HOURS, 2)
cal.getTime().Humanize(dateToUse) => "2 hours from now"
```

Or you can `Humanize` an instance of `Java.Util.Date` and get back a string telling how far back or forward in time that is compared to the current date:

```kotlin
val cal = GregorianCalendar()
cal.add(Calendar.DATE, -1)
cal.getTime().Humanize() => "yesterday"
cal.add(Calendar.HOURS, -2)
cal.getTime.Humanize() => "2 hours ago"

cal.add(Calendar.HOURS, 30)
cal.Humanize() => "tomorrow"
cal.getTime.add(Calendar.HOURS, 2)
cal.getTime().Humanize() => "2 hours from now"
```

## <a id="millisecondstotimespan">Milliseconds to timespan</a>

### Extension method millisecondsToTimespan for Int and Long objects

Since difference between dates are returned as milliseconds this method turns them into a readable form/
 This is a naive implementation and does not account for leapseconds, this is the nature of this method.
 By default the milliseconds precision is turned off but you can add it by passing true.

```kotlin
1.milliSecondsToTimespan() => "0 seconds"
1.milliSecondsToTimespan(true) => "0 seconds and 1 millisecond"

99999999.milliSecondsToTimespan() => "1 day and 3 hours and 46 minutes and 39 seconds"
99999999.milliSecondsToTimespan(true) => "1 day and 3 hours and 46 minutes and 39 seconds and 999 milliseconds"
```

## <a id="ordinalize">Ordinalize</a>

### Extension method Ordinalize for Int objects

You can `Ordinalize` an instance of `Int` and get back a string with the ordinalized number:

```kotlin
var num = 1
num.ordinalize() => "1st"
num = 100
num.ordinalize() => "100th"
```

### Extension method Ordinalize for String objects

You can `Ordinalize` an instance of `String` and get back a string with the ordinalized number:

```kotlin
var num = "1"
num.ordinalize() => "1st"
num = "100"
num.ordinalize() => "100th"
```

## <a id="truncate">Truncate</a>

### Extension method truncate for String objects

You can `Truncate` an instance of `String` and get back a string truncated with … at the end if needed:

```kotlin
var t = "a"
t.truncate(10) => "a"
t = "longer text then the length"
t.truncate(4) => "long…"
```

### Extension method truncate for String objects with Truncator option

You can `Truncate` an instance of `String` and get back a string truncated with … at the end if needed:
Truncator Enum
    * FixedLength = counts all characters
    * FixedNumberOfCharacters = counts only letters and digits
    * FixedNumberOfWords = counts the words by splitting on whitespace.

#### FixedLength

```kotlin
var t = "a"
t.truncate(10, truncator = Truncator.FixedLength) => "a"
t = "longer text then the length"
t.truncate(4, truncator = Truncator.FixedLength) => "long…"
```

#### FixedNumberOfCharacters

```kotlin
var t = "a"
t.truncate(10, truncator = Truncator.FixedNumberOfCharacters) => "a"
t = "Text with more characters than truncate length"
t.truncate(10, truncator = Truncator.FixedNumberOfCharacters) => "Text with m…"
```

#### FixedNumberOfWords

```kotlin
var t = "a"
t.truncate(10, truncator = Truncator.FixedNumberOfWords) => "a"
t = "Text with more words than truncate length"
t.truncate(4, truncator = Truncator.FixedNumberOfWords) => "Text with more words…"
```

### Extension method truncate for String objects with TruncatorString option

You can `Truncate` an instance of `String` and get back a string truncated with a custom string at the end if needed:

```kotlin
var t = "a"
t.truncate(10, truncationString = "...") => "a"
t = "Text with more words than truncate length"
t.truncate(10, truncationsString = "...") => "Text wi..."
```

### Extension method truncate for String objects with TruncatorString option

You can `Truncate` an instance of `String` and get back a string truncated from the left:

```kotlin
var t = "a"
t.truncate(10, truncateFrom = TruncateFrom.Left) => "a"
t = "Text with more words than truncate length"
t.truncate(10, truncateFrom = TruncateFrom.Left) => "…te length"
```

Or you can use a combination of the above parameters length, truncationString, truncator, truncateFrom.

## <a id="inflector">Inflector</a>

### Extension method camelize for String objects

Replaces underscores with hyphens in as String

Decapitalizes first word and removes underscores while capitalizing the next letter in a String

```kotlin
"customer_first_name".camelize() => "customerFirstName"
```

### Extension method pascalize for String objects

Capitalizes first word and removes underscores while capitalizing the next letter in a String

```kotlin
"customer_first_name".pascalize() => "CustomerFirstName"
```

### Extension method underscore for String objects

Replaces spaces with underscores and makes everything lowercase or looks for capitalized words and replaces them with underscore and lowercase in a String

```kotlin
"SomeTitleThatWillBeUnderscored".underscore() => "some_title_that_will_be_underscored"
```

### Extension method titleize for String objects

Replaces underscores and dashes with spaces and capitalizes each word in a String

```kotlin
"some-title: The begining".titleize() => "Some Title: The Begining"
```

### Extension method dasherize for String objects

Replaces underscores with dashes in a String.

```kotlin
"some_title".dasherize() => "some-title"
```

### Extension method hyphenate for String objects

Replaces underscores with hyphens in a String.

```kotlin
"some_title".hyphenate() => "some-title"
```

### Extension method pluralize for String objects

Gives the plural of a certain word.

```kotlin
"test".pluralize() => "tests"

"test".pluralize(Plurality.CouldBeEither) => "tests"
"tests".pluralize(Plurality.CouldBeEither) => "tests"
```

### Extension method singularize for String objects

gives the singular of a certain word.

```kotlin
"tests".singularize() => "test"

"test".singularize(Plurality.CouldBeEither) => "test"
"tests".singularize(Plurality.CouldBeEither) => "test"
```

## <a id="numbertowords">Number to words</a>

### Extension method toWords for String objects

Gives the value in words.

```kotlin
1.toWords() => "one"
10.toWords() => "ten"
```

### Extension method toOrdinalWords for String objects

Gives the value in ordinal words.

```kotlin
1.toOrdinalWords() => "first"
10.toOrdinalWords() => "tenth"
```

## <a id="toquantity">To quantity</a>

### Extension method toQuantity for String objects

```kotlin
"case".toQuantity(1) => "1 case"
"cases".toQuantity(1) => "1 case"
"case".toQuantity(10) => "10 cases"

"cases".toQuantity(1, showAsQuantity = ShowQuantityAs.None) => "case"
"cases".toQuantity(2, showAsQuantity = ShowQuantityAs.None) => "cases"

"cases".toQuantity(1, showAsQuantity = ShowQuantityAs.Numeric) => "1 case"
"cases".toQuantity(2, showAsQuantity = ShowQuantityAs.Numeric) => "1 case"

"cases".toQuantity(1, showAsQuantity = ShowQuantityAs.Words) => "one case"
"cases".toQuantity(2, showAsQuantity = ShowQuantityAs.Words) => "two cases"
```

### Extension method toQuantity for Int objects

```kotlin
1.toQuantity("case") => "1 case"
1.toQuantity("cases") => "1 case"
10.toQuantity("case") => "10 cases"

1.toQuantity("cases", showAsQuantity = ShowQuantityAs.None) => "case"
2.toQuantity("cases", showAsQuantity = ShowQuantityAs.None) => "cases"

1.toQuantity("cases", showAsQuantity = ShowQuantityAs.Numeric) => "1 case"
2.toQuantity("cases", showAsQuantity = ShowQuantityAs.Numeric) => "1 case"

1.toQuantity("cases", showAsQuantity = ShowQuantityAs.Words) => "one case"
2.toQuantity("cases", showAsQuantity = ShowQuantityAs.Words) => "two cases"
```

## <a id="humanize">Humanize</a>

### Extension method humanize for String objects

Turns pascalcased strings into sentences.

```kotlin
"PascalCaseInputStringIsTurnedIntoSentence".humanize() => "Pascal case input string is turned into sentence"
"Underscored_input_String_is_turned_INTO_sentence".humanize() => "Underscored input String is turned INTO sentence"
"HTMLIsTheLanguage".humanize() => "HTML is the language"

"CanReturnTitleCase".humanize(LetterCasing.Title) => "Can Return Title Case"

"CanReturnLowerCase".humanize(LetterCasing.LowerCase) => "can return lower case"

"CanReturnSentenceCase".humanize(LetterCasing.Sentence) => "Can return sentence case"

"CanHumanizeIntoUpperCase".humanize(LetterCasing.AllCaps) => "CAN HUMANIZE INTO UPPER CASE"
```

## <a id="dehumanize">Dehumanize</a>

### Extension method dehumanize for String objects

Turns sentences into pascalcased strings.

```kotlin
"Pascal case input string is turned into sentence".dehumanize() => "PascalCaseInputStringIsTurnedIntoSentencePascal case input string is turned into sentence"
```

## <a id="romannumerals">RomanNumerals</a>

### Extension method toRoman for Int objects

Turns an Int into Roman numeral. Limit from 1 to 3999.

```kotlin
1.toRoman() => "I"
2.toRoman() => "II"
4.toRoman() => "IV"
```

### Extension method fromRoman for String objects

Turns a Roman numeral into an Int. Limit from 1 to 3999.

```kotlin
"I".toRoman() => 1
"II".toRoman() => 2
"IV".toRoman() => 4
```
