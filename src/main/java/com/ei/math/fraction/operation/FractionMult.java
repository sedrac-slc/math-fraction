package com.ei.math.fraction.operation;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;
import com.ei.math.fraction.FractionResponse;
import com.ei.math.fraction.text.FractionFormatter;

public class FractionMult extends FractionAbsOper{

    @Override
    public FractionResponse solve(Fraction first, Fraction second) {
        list.add(FractionFormatter.stepOneMult(first, second));
        list.add(FractionFormatter.stepTwoMult(first, second));
        Fraction fraction = first.mult(second);
        if(!fraction.isIrreducible()){
            fraction = fraction.simplify();
            list.add(FractionFormatter.finish(fraction,3));
        }        
        return (new FractionResponse()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }

    @Override
    public FractionResponse solve(String expression) {
        return solve(expression,"mult");
    }

    @Override
    public FractionResponse solve(String expression, String method) {
        if(!expression.matches("\\+?"+FractionRegex.MULT)) 
           return new FractionResponse().toBuilder().build();
        if(expression.charAt(0) == '+') expression = expression.substring(1);
        String[] numbs = expression.split("\\*");
        Fraction fractionOne = FractionConverter.parse(numbs[0]);
        Fraction fractionTwo = FractionConverter.parse(numbs[1]);
        return solve(fractionOne, fractionTwo);
    }
    
}
