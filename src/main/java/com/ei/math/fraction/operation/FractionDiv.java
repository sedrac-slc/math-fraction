package com.ei.math.fraction.operation;

import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;

public class FractionDiv extends FractionAbsOper{

    @Override
    public FractionResponse solve(Fraction first, Fraction second) {
        Fraction fraction = first.div(second);
        list.add(FractionFormatter.stepOneDiv(first, second));
        second = second.reverse();
        list.add(FractionFormatter.stepTwoMult(first, second,2));
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,3));
        }      
        return (new FractionResponse()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }

    @Override
    public FractionResponse solve(String expression) {
        return solve(expression,"div"); 
    }

    @Override
    public FractionResponse solve(String expression, String method) {
        if(!expression.matches("\\+?"+FractionRegex.DIV)) 
           return new FractionResponse().toBuilder().build();
        if(expression.charAt(0) == '+') expression = expression.substring(1);
        String[] numbs = expression.split(":");
        Fraction fractionOne = FractionConverter.parse(numbs[0]);
        Fraction fractionTwo = FractionConverter.parse(numbs[1]);
        return solve(fractionOne, fractionTwo);
    }    
    
    
}
