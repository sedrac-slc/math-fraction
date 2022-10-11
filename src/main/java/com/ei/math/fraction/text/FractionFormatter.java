package com.ei.math.fraction.text;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.registory.FractionMessage;

final public class FractionFormatter {
    private static final  FractionMessage message;
    
    static{
        message = new FractionMessage();
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
       String msg = String.format(message.getString("step.two.mmc"),
                    first.getDenominator(),second.getDenominator(),mmc);        
       String text = FractionText.operationStepTwoMMC(first, second, mmc);
       String html = FractionHtml.operationStepTwoMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).message(msg).build();
    }
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeMMC(long mmc, Fraction first, Fraction second){
       String msg = String.format(message.getString("step.three.mmc"),
                    first.getDenominator(),second.getDenominator(),mmc);        
       String text = FractionText.operationStepThreeMMC(first, second, mmc);
       String html = FractionHtml.operationStepThreeMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(3).message(msg).build();
    }         
    /*
     * retorn expression a/b
     */
    public static Step stepFourMMC(long mmc, Fraction first, Fraction second){
       String msg = String.format(message.getString("step.four.mmc"),
                    first.getDenominator(),second.getDenominator(),mmc);         
       String text = FractionText.operationStepFourMMC(first, second, mmc);
       String html = FractionHtml.operationStepFourMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(4).message(msg).build();
    }     
    /*
     * retorn expression (a*e)/b+(d*b)/(e*b) 
     */
    public static Step stepOneCrossSystem(Fraction first, Fraction second){
       String text = FractionText.operationStepOneCrossSystem(first, second);
       String html = FractionHtml.operationStepOneCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(1).build();
    }    
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepTwoCrossSystem(Fraction first, Fraction second){
       String text = FractionText.operationStepTwoCrossSystem(first, second);
       String html = FractionHtml.operationStepTwoCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).build();
    } 
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeCrossSystem(Fraction first, Fraction second){
       String text = FractionText.operationStepThreeCrossSystem(first, second);
       String html = FractionHtml.operationStepThreeCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(3).build();
    }    
    
}
