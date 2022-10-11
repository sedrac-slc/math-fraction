package com.ei.math.fraction.operation;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionCalculate;
import com.ei.math.fraction.util.MMC;
import java.util.ArrayList;
import java.util.List;

public class FractionSum {
    List<Step> list;
    
    {list = new ArrayList<>();}
    
    public FractionResponse baseCase(Fraction first, Fraction second){
        list.add(FractionFormatter.stepOneDenominatorEquals(first, second));
        list.add(FractionFormatter.stepTwoDenominatorEquals(first, second,"+"));
        long num = FractionCalculate.numeratorsSumOrSub(first, second, "+");
        Fraction fraction = Fraction.of(num,second.getDenominator());
        System.out.println("fraction:"+fraction.isIrreducible());
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction, 3));
        }
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).build();
    }
    
    public FractionResponse minMultiploCommon(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return baseCase(first, second);
        long mmc = MMC.solve(first.getDenominator(), second.getDenominator());
        list.add(FractionFormatter.stepOneMMC(mmc, first, second));
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
            return baseCase(first, second);        
        list.add(FractionFormatter.stepOneCrossSystem(first, second));
        list.add(FractionFormatter.stepTwoCrossSystem(first, second));
        list.add(FractionFormatter.stepThreeCrossSystem(first, second));
        Fraction fraction = first.sum(second);
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(new Step(4, fraction.text(), fraction.html(),""));
        }        
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).build();
    }
      
    public static void main(String[] args) {
        FractionSum sum = new FractionSum();
        sum.minMultiploCommon(Fraction.of(11,2),Fraction.of(7,3)).getSteps().forEach(e->{ 
            System.out.println(e.getText()+" - "+e.getMessage());
        });
    }
    
}
