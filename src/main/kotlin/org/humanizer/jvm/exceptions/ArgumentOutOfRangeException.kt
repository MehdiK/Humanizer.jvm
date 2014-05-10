package org.humanizer.jvm.exceptions

class ArgumentOutOfRangeException(argument: Int, minValue: Int, maxValue:Int): Exception("The argument ${argument} is out of range, the range is $minValue to $maxValue.")

