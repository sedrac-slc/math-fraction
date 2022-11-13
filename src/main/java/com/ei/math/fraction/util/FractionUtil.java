package com.ei.math.fraction.util;

import com.ei.math.fraction.Fraction;
import java.util.List;

public class FractionUtil {

    public static boolean isPositive(Fraction... fracsOther){
        return List.of(fracsOther).stream().allMatch(Fraction::isPositive);
    }

   public static Fraction crossSystem(Fraction first, Fraction second){
    long num = (first.getNumerator()*second.getDenominator())+(first.getDenominator()*second.getNumerator());   
    long den = first.getDenominator()* second.getDenominator();
    return Fraction.of(num, den);
  }
    
   public static Fraction mult(Fraction first, Fraction second){
    long num = first.getNumerator()*second.getNumerator();   
    long den = first.getDenominator()* second.getDenominator();
    return Fraction.of(num, den);
  }
    
  public static Fraction div(Fraction first, Fraction second){
    long num = first.getNumerator()*second.getDenominator();
    long den = first.getDenominator()* second.getNumerator();
    return Fraction.of(num, den);
  }  
    
    
}
