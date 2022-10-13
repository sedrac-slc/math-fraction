package com.ei.math.fraction.operation;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionCalculate;
import com.ei.math.fraction.util.MMC;
import java.util.ArrayList;
import java.util.List;

public class FractionSub {
    List<Step> list;
    
    {list = new ArrayList<>();}
     
    public FractionResponse minMultiploCommon(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionCalculate.baseCase(list, first, second, "-");
        long mmc = MMC.solve(first.getDenominator(), second.getDenominator());
        second = second.isPositive()? second.negative() : second;
        list.add(FractionFormatter.stepOneMMC(mmc, first,second));
        list.add(FractionFormatter.stepTwoMMC(mmc, first, second));
        list.add(FractionFormatter.stepThreeMMC(mmc, first, second));
        list.add(FractionFormatter.stepFourMMC(mmc, first, second));
        long num = first.getNumerator()*(mmc/first.getDenominator())+
                   second.getNumerator()*(mmc/second.getDenominator());
        Fraction fraction = Fraction.of(num, mmc);
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,5));
        }
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).build();
    }
    
    public FractionResponse crossSystem(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionCalculate.baseCase(list, first, second, "-");    
        second = second.isPositive()? second.negative() : second;
        list.add(FractionFormatter.stepOneCrossSystem(first, second,"-"));
        list.add(FractionFormatter.stepTwoCrossSystem(first, second,"-"));
        list.add(FractionFormatter.stepThreeCrossSystem(first, second));
        Fraction fraction = first.sub(second);
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,5));
        } 
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).build();
    }
    
    
}
 