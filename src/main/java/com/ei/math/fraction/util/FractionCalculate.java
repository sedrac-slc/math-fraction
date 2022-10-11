package com.ei.math.fraction.util;

import com.ei.math.fraction.Fraction;

public class FractionCalculate {
    
  public static long mmcSig(Fraction first,Fraction second, long mmc,String sig){
        long num = 0;
        if(sig.equals("+"))
            num = first.getNumerator()*(mmc/first.getDenominator())+second.getNumerator()*(mmc/second.getDenominator());
        if(sig.equals("-"))
            num = first.getNumerator()*(mmc/first.getDenominator())-second.getNumerator()*(mmc/second.getDenominator());
        return num;
    }  
  
    public static long numeratorsSumOrSub(Fraction first,Fraction second,String sig){
        long num = 0;
        if(sig.equals("+"))
            num = first.getNumerator()+second.getNumerator();
        if(sig.equals("-"))
            num = first.getNumerator()-second.getNumerator();
        return num;
    }  
  
}
