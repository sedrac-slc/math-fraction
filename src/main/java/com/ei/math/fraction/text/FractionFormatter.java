package com.ei.math.fraction.text;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.registory.FractionMessage;
import com.ei.math.fraction.util.FractionPartStepMethods;
/**
 *{@code FractionFormatter} is a class that contains methods that generate the 
 * steps for solving fraction operations
 * 
 * @author  Sedrac Lucas Calupeteca
 * @since   1.0
 */
final public class FractionFormatter {
    private static final  FractionMessage message;
    
    static{
        message = new FractionMessage();
    }
    /**
     * Returns the expression of a fraction addition or subtraction operation
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * <pre>{
     * String msg = String.format(message.getString("step.start"));
     * }</pre>
     * @return  (new Step()).toBuilder().text(fraction.text()).html(fraction.html()).message(msg).codigo(pos).build();
     */
    public static Step startSumOrSub(Fraction first, Fraction second){
       String msg = String.format(message.getString("step.start"));
       return (new Step()).toBuilder().text(FractionText.join(first, second)).html(FractionHtml.join(first, second)).message(msg).codigo(0).build();
    }  
    /**
     * Returns the expression of a fraction multiplecation or division operation
     * @param first {@code Fraction} first fraction
     * @param second {@code Fraction} second fraction
     * <pre>{
     * String msg = String.format(message.getString("step.start"));
     * }</pre>
     * @param signal
     * @return  (new Step()).toBuilder().text(fraction.text()).html(fraction.html()).message(msg).codigo(pos).build();
     */
    public static Step starMultOrDiv(Fraction first, Fraction second, String signal){
       String msg = String.format(message.getString("step.start"));
       if(second.isNegative() && first.isPositive()){
          first = first.negative(); second = second.positive();
       }if(first.isNegative() && second.isNegative()){
          first = first.positive(); second = second.positive();
       }
       return (new Step()).toBuilder()
                          .text(FractionText.join(first, second,signal)).html(FractionHtml.join(first, second,signal))
                          .message(msg).codigo(0).build();
    }     
    /**
     * Returns the last solve step a fraction operation
     * @param fraction
     * @param pos
     * <pre>{
     * String msg = String.format(message.getString("step.frac.irreducible"));
     * }</pre>
     * @return  (new Step()).toBuilder().text(fraction.text()).html(fraction.html()).message(msg).codigo(pos).build();
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
       String msg = String.format(message.getString("step.two.mmc"),mmc,mmc);        
       String text = FractionText.operationStepTwoMMC(first, second, mmc);
       String html = FractionHtml.operationStepTwoMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).message(msg).build();
    }
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeMMC(long mmc, Fraction first, Fraction second){
       String sig = second.isPositive()? "+"  : "-";
       String msg = String.format(message.getString("step.three.mmc"),sig,mmc);        
       String text = FractionText.operationStepThreeMMC(first, second, mmc);
       String html = FractionHtml.operationStepThreeMMC(first, second, mmc);
       return (new Step()).toBuilder().text(text).html(html).codigo(3).message(msg).build();
    }         
    /*
     * retorn expression a/b
     */
    public static Step stepFourMMC(long mmc, Fraction first, Fraction second){
       String sig = second.isPositive() ? "+" : "-";
       String num = FractionPartStepMethods.mmcSig(first, second,mmc, "+")+"";
       String msg = String.format(message.getString("step.frac.result"),sig,num,mmc);        
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
       String msg = String.format(message.getString("step.two.cross"),signal,first.getDenominator()*second.getDenominator());
       String text = FractionText.operationStepTwoCrossSystem(first, second);
       String html = FractionHtml.operationStepTwoCrossSystem(first, second);
       return (new Step()).toBuilder().text(text).html(html).codigo(2).message(msg).build();
    } 
    /*
     * retorn expression (a+b)/c
     */
    public static Step stepThreeCrossSystem(Fraction first, Fraction second){
       String sig = second.isPositive() ? "+" : "-";
       String num = FractionPartStepMethods.crossSig(first, second, "+")+"";
       String den = first.getDenominator()*second.getDenominator()+"";
       String msg = String.format(message.getString("step.frac.result"),sig,num,den);
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
                         .codigo(1)
                         .message(msg)
                         .build();
    }

    public static Step stepTwoDenominatorEquals(Fraction first, Fraction second,String signal) {
        String num = FractionPartStepMethods.numeratorsSumOrSub(first, second, signal)+"";
        String den = second.getDenominator().toString();
        String msg = String.format(message.getString("step.two.den.equals"),den);        
        return new Step().toBuilder()
                         .text(num+"/"+den)
                         .html(FractionHtml.template(num,den))
                         .codigo(2)
                         .message(msg)
                         .build();
    }

    public static Step stepOneMult(Fraction first, Fraction second,int pos) {
        if(first.isNegative() && second.isNegative()){
            first = first.positive(); second = second.positive();
        }
        String num = FractionPartStepMethods.numeratorMultDenominator(first, second, true);
        String den = FractionPartStepMethods.numeratorMultDenominator(first, second, false);
        String msg = String.format(message.getString("step.one.mult"),num,den);        
        return (new Step()).toBuilder()
                         .text("("+num+")/("+den+")").html(FractionHtml.template(num,den))
                         .message(msg).codigo(pos)
                         .build();                
    }
    
   public static Step stepOneMult(Fraction first, Fraction second){
        return stepOneMult(first, second, 1);
   }    

    public static Step stepTwoMult(Fraction first, Fraction second,int pos) {
        String num = FractionPartStepMethods.numeratorMultDenominatorOper(first, second, true);
        String den = FractionPartStepMethods.numeratorMultDenominatorOper(first, second, false);
        String msg = String.format(message.getString("step.two.mult"),num,den,num,den);        
        return (new Step()).toBuilder()
                         .text(num+"/"+den).html(FractionHtml.template(num,den))
                         .message(msg).codigo(pos)
                         .build(); 
    }
    
    public static Step stepTwoMult(Fraction first, Fraction second){
         return stepTwoMult(first, second, 2);
     }

    public static Step stepOneDiv(Fraction first, Fraction second) {
       if(second.isNegative() && first.isPositive()){
          first = first.negative(); second = second.positive();
       }if(first.isNegative() && second.isNegative()){
          first = first.positive(); second = second.positive();
       }        
        second = second.reverse();
        String num = FractionPartStepMethods.numeratorMultDenominator(first, second, true);
        String den = FractionPartStepMethods.numeratorMultDenominator(first, second, false);
        String msg = String.format(message.getString("step.one.div"),num,den);        
        return (new Step()).toBuilder()
                         .text("("+num+")/("+den+")").html(FractionHtml.template(num,den))
                         .message(msg).codigo(1)
                         .build();         
    }
    
    public static Step stepSimply(Fraction fraction,int pos) {
        long mdc = fraction.mdc();
        String msg = String.format(message.getString("step.simply"),mdc);        
        return (new Step()).toBuilder()
                         .text(FractionText.simply(fraction, mdc))
                         .html(FractionHtml.simply(fraction, mdc))
                         .message(msg)
                         .codigo(pos)
                         .build();         
    }
    
  
    
}
