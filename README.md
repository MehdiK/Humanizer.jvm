<p><img src="https://raw.github.com/MehdiK/Humanizer/master/logo.png" alt="Logo" style="max-width:100%;" /></p>

Humanizer.jvm is an adaptation of the humanizer framework for .Net which is made for the jvm and is written in kotlin.
Humanizer.jvm meets all your jvm needs for manipulating and displaying strings, enums, dates, times, timespans, numbers and quantities.

The current build status on the CI server is <a href="http://teamcity.ginnivan.net/viewType.html?buildTypeId=HumanizerJvm_CI&guest=1">
<img src="http://teamcity.ginnivan.net/app/rest/builds/buildType:(id:HumanizerJvm_CI)/statusIcon"/></a>

###Table of contents
 - [Features](#features)
   - [Humanize date](#humanize-date)
   - [Ordinalize](#ordinalize)
   - [Truncate] (#truncate)

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

## <a id="ordinalize">Ordinalize</a>

### Extension method Ordinalize for Int objects

You can `Ordinalize` an instance of `Int` and get back a string with the ordinalized number:

```kotlin
val num = 1
num.ordinalize() => "1st"
num = 100
num.ordinalize() => "100th"
```

### Extension method Ordinalize for String objects

You can `Ordinalize` an instance of `String` and get back a string with the ordinalized number:

```kotlin
val num = "1"
num.ordinalize() => "1st"
num = "100
num.ordinalize() => "100th"
```

## <a id="truncate">Truncate</a>

### Extension method truncate for String objects

You can `Truncate` an instance of `String` and get back a string truncated with … at the end if needed:

```kotlin
val t = "a"
num.truncate(10) => "a"
t = "longer text then the length"
num.truncate(4) => "long…"
```

### Extension method truncate for String objects with Truncator option

You can `Truncate` an instance of `String` and get back a string truncated with … at the end if needed:
Truncator Enum
    * FixedLength = counts all characters
    * FixedNumberOfCharacters = counts only letters and digits
    * FixedNumberOfWords = counts the words by splitting on whitespace.

#### FixedLength

```kotlin
val t = "a"
num.truncate(10, truncator = Truncator.FixedLength) => "a"
t = "longer text then the length"
num.truncate(4, truncator = Truncator.FixedLength) => "long…"
```

#### FixedNumberOfCharacters

```kotlin
val t = "a"
num.truncate(10, truncator = Truncator.FixedNumberOfCharacters) => "a"
t = "Text with more characters than truncate length"
num.truncate(10, truncator = Truncator.FixedNumberOfCharacters) => "Text with m…"
```

#### FixedNumberOfWords

```kotlin
val t = "a"
num.truncate(10, truncator = Truncator.FixedNumberOfWords) => "a"
t = "Text with more words than truncate length"
num.truncate(4, truncator = Truncator.FixedNumberOfWords) => "Text with more words…"
```

### Extension method truncate for String objects with TruncatorString option

You can `Truncate` an instance of `String` and get back a string truncated with a custom string at the end if needed:

```kotlin
val t = "a"
num.truncate(10, truncationString = "...") => "a"
t = "Text with more words than truncate length"
num.truncate(10, truncationsString = "...") => "Text wi..."
```

### Extension method truncate for String objects with TruncatorString option

You can `Truncate` an instance of `String` and get back a string truncated from the left:

```kotlin
val t = "a"
num.truncate(10, truncateFrom = TruncateFrom.Left) => "a"
t = "Text with more words than truncate length"
num.truncate(10, truncateFrom = TruncateFrom.Left) => "…te length"
```

Or you can use a combination of the above parameters length, truncationString, truncator, truncateFrom.