package com.ei.math.fraction.operation;

import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;
import com.ei.math.fraction.FractionResult;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionPartStepMethods;
import com.ei.math.fraction.util.FractionUtil;
/**
 *{@code FractionDiv} is the concrete class that represents the division operation between fraction
 * 
 * @author  Sedrac Lucas Calupeteca
 * @since   1.0
 */
public class FractionDiv extends FractionOper{
    /**
     * Returns the division of two fractions using the standard method
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * <pre>{
     *  Fraction fraction = first.div(second);
     *  list.add(FractionFormatter.stepOneDiv(first, second));
     *  second = second.reverse();
     *  list.add(FractionFormatter.stepTwoMult(first, second,2));
     *  if(!fraction.isIrreducible()){
     *      fraction = fraction.simplify();
     *      list.add(FractionFormatter.finish(fraction,3));
     *  }  
     * }</pre>
     * @return (new FractionResult()).toBuilder().steps(list).status(true).fraction(fraction).build();
     */  
    @Override
    public FractionResult solve(Fraction first, Fraction second) {
        init();
        list.add(FractionFormatter.starMultOrDiv(first, second, ":"));
        list.add(FractionFormatter.stepOneDiv(first, second));
        list.add(FractionFormatter.stepTwoMult(first, second.reverse(),2));
        Fraction fraction = FractionUtil.div(first, second);
        FractionPartStepMethods.simplify(list, fraction, 3, 4);     
        return (new FractionResult()).toBuilder().steps(list).status(true).fraction(fraction).build();
    }
    /**
     * Returns the division of two fractions using the standard method
     * @param expression {@code String} represents the regular expression. Example: 5/7:3/5
     * @return solve(expression, "div");
     */ 
    @Override
    public FractionResult solve(String expression) {
        return solve(expression,"div"); 
    }
    /**
     * Returns the division of two fractions using the standard method
     * @param expression {@code String} represents the regular expression. Example: 5/7:3/5
     * @param method {@code String} represents the sum operation methods. Values:(mmc, crossSystem)
     * @return a FractionResult object, which brings the result of the operation 
     * and the steps to arrive at the result.
     */  
    @Override
    public FractionResult solve(String expression, String method) {
        if(!expression.matches("\\+?"+FractionRegex.DIV)) 
           return new FractionResult().toBuilder().build();
        if(expression.charAt(0) == '+') expression = expression.substring(1);
        String[] numbs = expression.split(":");
        Fraction fractionOne = FractionConverter.parse(numbs[0]);
        Fraction fractionTwo = FractionConverter.parse(numbs[1]);
        return solve(fractionOne, fractionTwo);
    }    
    /**
     * Returns the division of two fractions using the standard method
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * @param method {@code String} this parameter has no use in this function it just exists because of the inheritance of the FractionOper class
     * @return solve(first, second);
     */ 
    @Override
    public FractionResult solve(Fraction first, Fraction second, String method) {
        return solve(first, second);
    }
      
    
}
