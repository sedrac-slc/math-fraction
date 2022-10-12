package com.ei.math.fraction.text;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.registory.FractionMessage;
import com.ei.math.fraction.util.FractionCalculate;

final public class FractionFormatter {
    private static final  FractionMessage message;
    
    static{
        message = new FractionMessage();
    }
 /*
     * retorn expression a/b(c)+d/e(f) 
     */
    public static Step finish(Fraction fraction, int pos){
       String msg = String.format(message.getString("step.frac.irreducible"));
       return (new Step()).toBuilder().text(fraction.text()).html(fraction.html()).message(msg).codigo(pos).build();
    }    
    /*
     * retorn expression a/b(c)+d/e(f) 
     */
    public static Step stepOneMMC(long mmc, Fraction first, Fraction second){
       String msg = String.format(message.getString("step.one.mmc"),
                    first.getDenominator(),second.getDenominator(),mmc);
       String text = FractionText.operationStepOneMMC(first, second, mmc);
       String html = FractionHtml.operationStepOneMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(1).message(msg).build();
    }
    /*
     * retorn expression (a*b+d*c)/e
     */
    public static Step stepTwoMMC(long mmc, Fraction first, Fraction second){
       String msg = message.getString("step.two.mmc");        
       String text = FractionText.operationStepTwoMMC(first, second, mmc);
       String html = FractionHtml.operationStepTwoMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).message(msg).build();
    }
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeMMC(long mmc, Fraction first, Fraction second){
       String msg = String.format(message.getString("step.three.mmc"),"+");        
       String text = FractionText.operationStepThreeMMC(first, second, mmc);
       String html = FractionHtml.operationStepThreeMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(3).message(msg).build();
    }         
    /*
     * retorn expression a/b
     */
    public static Step stepFourMMC(long mmc, Fraction first, Fraction second){
       String msg = message.getString("step.four.mmc");         
       String text = FractionText.operationStepFourMMC(first, second, mmc);
       String html = FractionHtml.operationStepFourMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(4).message(msg).build();
    }     
    /*
     * retorn expression (a*e)/b+(d*b)/(e*b) 
     */
    public static Step stepOneCrossSystem(Fraction first, Fraction second,String signal){
       String msg = String.format(message.getString("step.one.cross"),signal);
       String text = FractionText.operationStepOneCrossSystem(first, second);
       String html = FractionHtml.operationStepOneCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(1).message(msg).build();
    }    
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepTwoCrossSystem(Fraction first, Fraction second,String signal){
       String msg = String.format(message.getString("step.two.cross"),signal);
       String text = FractionText.operationStepTwoCrossSystem(first, second);
       String html = FractionHtml.operationStepTwoCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).message(msg).build();
    } 
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeCrossSystem(Fraction first, Fraction second){
       String msg = message.getString("step.three.cross");
       String text = FractionText.operationStepThreeCrossSystem(first, second);
       String html = FractionHtml.operationStepThreeCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(3).message(msg).build();
    }    

    public static Step stepOneDenominatorEquals(Fraction first, Fraction second,String signal) {
        second = second.positive();
        String num = first.getNumerator()+signal+second.getNumerator();
        String den = second.getDenominator().toString();
        String msg = String.format(message.getString("step.one.den.equals"),signal,den);
        return new Step().toBuilder()
                         .text("("+num+")/"+den)
                         .html(FractionHtml.template(num,den))
                         .message(msg)
                         .build();
    }

    public static Step stepTwoDenominatorEquals(Fraction first, Fraction second,String signal) {
        String num = FractionCalculate.numeratorsSumOrSub(first, second, signal)+"";
        String den = second.getDenominator().toString();
        String msg = String.format(message.getString("step.two.den.equals"),den);        
        return new Step().toBuilder()
                         .text(num+"/"+den)
                         .html(FractionHtml.template(num,den))
                         .message(msg)
                         .build();
    }
    
}
