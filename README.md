<p><img src="https://raw.github.com/MehdiK/Humanizer/master/logo.png" alt="Logo" style="max-width:100%;" /></p>

Humanizer.jvm is an adaptation of the humanizer framework for .Net which is made for the jvm and is written in kotlin.
Humanizer.jvm meets all your jvm needs for manipulating and displaying strings, enums, dates, times, timespans, numbers and quantities.

The current build status on the CI server is <a href="http://teamcity.ginnivan.net/viewType.html?buildTypeId=HumanizerJvm_CI&guest=1">
<img src="http://teamcity.ginnivan.net/app/rest/builds/buildType:(id:HumanizerJvm_CI)/statusIcon"/></a>

###Table of contents
 - [Features](#features)
   - [Humanize date](#humanize-date)

# <a id="features">Features</a>

## <a id="humanize-date>Humanize date</a>

### Extension methods Humanize for Java.Util.Date objects

You can `Humanize` an instance of `Jav.Util.Date` and get back a string telling how far back or forward in time that is comapered to a given date:

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

Or you can `Humanize` an instance of `Jav.Util.Date` and get back a string telling how far back or forward in time that is comapered to the current date:

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

