package com.ei.math.fraction.util;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResult;
import com.ei.math.fraction.text.FractionFormatter;
import java.util.List;

public class FractionPartStepMethods {
    
  public static long mmcSig(Fraction first,Fraction second, long mmc,String sig){
        long num = 0;
        if(sig.equals("+"))
            num = first.getNumerator()*(mmc/first.getDenominator())+second.getNumerator()*(mmc/second.getDenominator());
        if(sig.equals("-"))
            num = first.getNumerator()*(mmc/first.getDenominator())-second.getNumerator()*(mmc/second.getDenominator());
        return num;
    }  
  
  public static long crossSig(Fraction first,Fraction second, String sig){
        long num = 0;
        if(sig.equals("+"))
            num = first.getNumerator()*second.getDenominator()+first.getDenominator()*second.getNumerator();
        if(sig.equals("-"))
            num = first.getNumerator()*second.getDenominator()-first.getDenominator()*second.getNumerator();
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
    
  public static FractionResult baseCase(List<Step> list,Fraction first, Fraction second,String signal){
        if(signal.equals("-")) second = second.isPositive() ? second.negative() : second;
        list.add(FractionFormatter.startSumOrSub(first,second));
        list.add(FractionFormatter.stepOneDenominatorEquals(first, second,signal));
        list.add(FractionFormatter.stepTwoDenominatorEquals(first, second,signal));
        long num = numeratorsSumOrSub(first, second, signal);
        Fraction fraction = Fraction.of(num,second.getDenominator());
  
         FractionPartStepMethods.simplyVerif(list, fraction, 3, 4);
        return (new FractionResult()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }    
  
  public static String numeratorMultDenominator(Fraction first,Fraction second, boolean isNumeratorOrDenominator){
       String sig = FractionUtil.isPositive(first,second)? "" : "-";
       first = first.positive();
       second = second.positive();
      return isNumeratorOrDenominator
       ? sig+first.getNumerator()+"*"+second.getNumerator()
       : first.getDenominator()+"*"+second.getDenominator();
  }
  
  public static String numeratorMultDenominatorOper(Fraction first,Fraction second, boolean isNumeratorOrDenominator){
      return isNumeratorOrDenominator
       ? first.getNumerator()*second.getNumerator()+""
       : first.getDenominator()*second.getDenominator()+"";
  } 
  
    
     public static void simplyVerif(List<Step> list, Fraction fraction, int posSimply, int posFinish) {
        if(!fraction.isIrreducible()){
            list.add(FractionFormatter.stepSimply(fraction, posSimply));
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,posFinish));
        }
    }  
  
}
