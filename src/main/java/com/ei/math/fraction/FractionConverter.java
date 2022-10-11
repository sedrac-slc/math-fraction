package com.ei.math.fraction;

import com.ei.math.fraction.exception.FractionNumberFormatException;

public class FractionConverter {

   private static Fraction parseDigitsString(String num){
        String[] split = num.split("\\.");
        long numerator = Long.parseLong(split[0]+split[1]);
        long denominator = (long) Math.pow(10, split[1].length());
        return Fraction.of(numerator, denominator).simplify();
   }
    
   public static Fraction parse(double number){
         String num = String.valueOf(number);
        if(num.matches("\\d+\\.0+"))
               return Fraction.of(Double.valueOf(num).longValue());
        return parseDigitsString(num);
    }
   
    public static Fraction parse(String number){   
        if(number.matches("\\d+\\.\\d+")) return parseDigitsString(number);
        if(!number.matches(FractionRegex.FRACTION))
            throw new FractionNumberFormatException();
        String[] numbs = number.split("/");
        double numerator = Double.parseDouble(numbs[0].trim());
        double denominator = Double.parseDouble(numbs[1].trim());
        return Fraction.of(numerator,denominator);
    }
          
}
