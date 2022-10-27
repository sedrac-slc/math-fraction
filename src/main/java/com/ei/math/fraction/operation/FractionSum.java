package com.ei.math.fraction.operation;

import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionPartStepMethods;
import com.ei.math.MMC;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;

public class FractionSum extends FractionAbsOper{
    
    public FractionResponse minMultiploCommon(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "+");
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
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).status(true).build();
    }
    
    public FractionResponse crossSystem(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "+");    
        list.add(FractionFormatter.stepOneCrossSystem(first, second,"+"));
        list.add(FractionFormatter.stepTwoCrossSystem(first, second,"+"));
        list.add(FractionFormatter.stepThreeCrossSystem(first, second));
        Fraction fraction = first.sum(second);
        System.out.println(fraction+":"+fraction.isIrreducible());
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,4));
        }        
        return (new FractionResponse()).toBuilder().steps(list).fraction(fraction).status(true).build();
    }

    @Override
    public FractionResponse solve(Fraction first, Fraction second) {
        return crossSystem(first, second); 
    }

    @Override
    public FractionResponse solve(String expression, String method) {
        if(!expression.matches("\\+?"+FractionRegex.SUM)) 
            return new FractionResponse().toBuilder().build();
        if(expression.charAt(0) == '+') expression = expression.substring(1);
        String[] numbs = expression.split("\\+");
        Fraction fractionOne = FractionConverter.parse(numbs[0]);
        Fraction fractionTwo = FractionConverter.parse(numbs[1]);
        FractionResponse fractionResponse = method.equalsIgnoreCase("crossSystem")
                ? crossSystem(fractionOne, fractionTwo)
                : minMultiploCommon(fractionOne, fractionTwo);
        return  fractionResponse;
    }
    
    @Override
    public FractionResponse solve(String expression) {
        return solve(expression, "crossSystem");
    }
       
  
}
