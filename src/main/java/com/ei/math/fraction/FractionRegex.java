package com.ei.math.fraction;

public class FractionRegex {
    public static final String FRACTION = "[\\+|\\-]?\\d+(\\.\\d+)?/\\d+(\\.\\d+)?";
    public static final String FRACTION_MMC = FRACTION+"\\(\\d+\\)";
}
