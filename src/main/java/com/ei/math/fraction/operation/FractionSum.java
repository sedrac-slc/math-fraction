package com.ei.math.fraction.operation;

import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResult;
import com.ei.math.fraction.text.FractionFormatter;
import com.ei.math.fraction.util.FractionPartStepMethods;
import com.ei.math.MMC;
import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;
import com.ei.math.fraction.util.FractionUtil;
import java.util.concurrent.ThreadLocalRandom;
/**
 *{@code FractionSum} is the concrete class that represents the addition operation between fraction
 * 
 * @author  Sedrac Lucas Calupeteca
 * @since   1.0
 */
public class FractionSum extends FractionOper{
    public final static String METHOD_MMC = "mmc";
    public final static String METHOD_CROSS_SYSTEM = "crossSystem";
    public final static String METHOD_RANDOM = "random";
    /**
     * Returns the sum or addition of two fractions using the least common multiple method
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * @see com.ei.math.MMC
     * @see com.ei.math.fraction.FractionResult
     * @return a FractionResult object, which brings the result of the operation 
     * and the steps to arrive at the result.
     */      
    public FractionResult minMultiploCommon(Fraction first, Fraction second){
        init();
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "+");
        long mmc = MMC.solve(first.getDenominator(), second.getDenominator());
        list.add(FractionFormatter.startSumOrSub(first, second));
        list.add(FractionFormatter.stepOneMMC(mmc, first, second));
        list.add(FractionFormatter.stepTwoMMC(mmc, first, second));
        list.add(FractionFormatter.stepThreeMMC(mmc, first, second));
        list.add(FractionFormatter.stepFourMMC(mmc, first, second));
        long num = first.getNumerator()*(mmc/first.getDenominator())+
                   second.getNumerator()*(mmc/second.getDenominator());
        Fraction fraction = Fraction.of(num, mmc);
        FractionPartStepMethods.simplify(list, fraction, 5, 6);
        return (new FractionResult()).toBuilder().steps(list).fraction(fraction).status(true).build();
    }
    /**
     * Returns the sum or addition of two fractions using the cross system method
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * @see com.ei.math.fraction.FractionResult
     * @return a FractionResult object, which brings the result of the operation 
     * and the steps to arrive at the result.
     */      
    public FractionResult crossSystem(Fraction first, Fraction second){
        init();
        if(first.getDenominator().equals(second.getDenominator()))
            return FractionPartStepMethods.baseCase(list, first, second, "+");  
        list.add(FractionFormatter.startSumOrSub(first, second));
        list.add(FractionFormatter.stepOneCrossSystem(first, second,"+"));
        list.add(FractionFormatter.stepTwoCrossSystem(first, second,"+"));
        list.add(FractionFormatter.stepThreeCrossSystem(first, second));
        Fraction fraction = FractionUtil.crossSystem(first, second);
        FractionPartStepMethods.simplify(list, fraction, 4, 5);
        return (new FractionResult()).toBuilder().steps(list).fraction(fraction).status(true).build();
    }
    /**
     * Returns the sum or addition of two fractions using the standard method (cross system)
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * @return crossSystem(first, second);
     */    
    @Override
    public FractionResult solve(Fraction first, Fraction second) {
        return crossSystem(first, second); 
    }
    /**
     * Return the sum or addition of expression using method
     * @param expression {@code String} represents the regular expression. Example: 5/7+3/5
     * @param method {@code String} represents the sum or addition operation methods. Values:(mmc, crossSystem)
     * @return a FractionResult object, which brings the result of the operation 
     * and the steps to arrive at the result.
     */   
    @Override
    public FractionResult solve(String expression, String method) {
        if(!expression.matches("\\+?"+FractionRegex.SUM)) 
            return new FractionResult().toBuilder().build();
        if(expression.charAt(0) == '+') expression = expression.substring(1);
        String[] numbs = expression.split("\\+");
        Fraction fractionOne = FractionConverter.parse(numbs[0]);
        Fraction fractionTwo = FractionConverter.parse(numbs[1]);
        FractionResult fractionResponse = method.equalsIgnoreCase("mmc")
                ? minMultiploCommon(fractionOne, fractionTwo)
                : crossSystem(fractionOne, fractionTwo);
        return  fractionResponse;
    }
    /**
     * Return the sum or addition of expression using the standard method (cross system)
     * @param expression {@code String} represents the regular expression. Example: 5/7+3/5
     * @return solve(expression, FractionSub.METHOD_CROSS_SYSTEM);
     */     
    @Override
    public FractionResult solve(String expression) {
        return solve(expression, FractionSub.METHOD_CROSS_SYSTEM);
    }
    /**
     * Return the sum or addition of expression using the standard method (cross system)
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * @param method {@code String} represents the sum or addition operation methods. Values:(mmc, crossSystem)
     * @return a FractionResult object, which brings the result of the operation 
     * and the steps to arrive at the result.
     */   
    @Override
    public FractionResult solve(Fraction first, Fraction second, String method) {
        switch(method){
            case FractionSub.METHOD_MMC:
                return minMultiploCommon(first, second);
            case FractionSub.METHOD_CROSS_SYSTEM:
                return crossSystem(first, second);
            default:
                boolean par = ThreadLocalRandom.current().nextInt(1,10) % 2 == 0;
                return par ? minMultiploCommon(first, second) : crossSystem(first, second);
        }
    }
         
}
