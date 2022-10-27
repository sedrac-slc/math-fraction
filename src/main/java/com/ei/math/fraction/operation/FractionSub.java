package com.ei.math.fraction.operation;

import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionPartStepMethods;
import com.ei.math.MMC;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;

public class FractionSub extends FractionAbsOper{
     
    public FractionResponse minMultiploCommon(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "-");
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
        return (new FractionResponse()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }
    
    public FractionResponse crossSystem(Fraction first, Fraction second){
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "-");    
        Fraction secondF = second.isPositive()? second.negative() : second;
        list.add(FractionFormatter.stepOneCrossSystem(first, secondF,"-"));
        list.add(FractionFormatter.stepTwoCrossSystem(first, secondF,"-"));
        list.add(FractionFormatter.stepThreeCrossSystem(first, secondF));
        Fraction fraction = first.sub(second);
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,5));
        } 
        return (new FractionResponse()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }

    @Override
    public FractionResponse solve(Fraction first, Fraction second) {
        return crossSystem(first, second);
    }

    @Override
    public FractionResponse solve(String expression, String method) {
        String[] numbs;
        Fraction fractionOne, fractionTwo;
        if(expression.matches("\\-?"+FractionRegex.SUM)){
            numbs = expression.split("\\+");
            fractionOne = FractionConverter.parse(numbs[1]);
            fractionTwo = FractionConverter.parse(numbs[0].substring(1)).negative();
        }else if(expression.matches("\\-?"+FractionRegex.SUB)){
            expression = expression.substring(1);
            numbs = expression.split("\\-");
            fractionOne = FractionConverter.parse(numbs[0]).negative();
            fractionTwo = FractionConverter.parse(numbs[1]).negative();
        }else{
            if(!expression.matches("\\+?"+FractionRegex.SUB)) 
                return new FractionResponse().toBuilder().build();
            if(expression.charAt(0) == '+') expression = expression.substring(1);
            numbs = expression.split("\\-");
            fractionOne = FractionConverter.parse(numbs[0]);
            fractionTwo = FractionConverter.parse(numbs[1]).negative();
        }
        FractionResponse fractionResponse = method.equalsIgnoreCase("crossSystem")
                ? crossSystem(fractionOne, fractionTwo)
                : minMultiploCommon(fractionOne, fractionTwo);
        return  fractionResponse;  
    }    
    
    @Override
    public FractionResponse solve(String expression) {
        return solve(expression,"crossSystem");
    }
    
      
}
 