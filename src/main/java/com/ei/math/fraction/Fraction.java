package com.ei.math.fraction;

import com.ei.math.fraction.exception.FractionDenominatorIsZeroException;
import com.ei.math.fraction.text.FractionHtml;
import com.ei.math.fraction.text.FractionText;
import com.ei.math.fraction.util.MDC;
import com.ei.math.fraction.util.Numbers;
import java.io.Serializable;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public final class Fraction extends Number implements Comparable< Fraction > , Serializable{
    protected Long numerator;
    protected Long denominator;

    public final static long MAX_VALUE_NUMERATOR = Long.MAX_VALUE;
    public final static long MIN_VALUE_NUMERATOR = Long.MIN_VALUE;
    
    public final static long MAX_VALUE_DENOMINATOR = Long.MAX_VALUE;
    public final static long MIN_VALUE_DENOMINATOR = Long.MIN_VALUE;

    protected Fraction(Long numerator) {
        this.numerator = numerator;
    }

    protected Fraction(Long numerator, Long denominator) throws FractionDenominatorIsZeroException{
        if(Objects.equals(this.denominator, 0.0)) throw new FractionDenominatorIsZeroException();
        this.numerator = numerator;
        this.denominator = denominator;    
        changeSignal();
    }

    protected Fraction(Integer numerator, Integer denominator) throws FractionDenominatorIsZeroException{
        if(Objects.equals(this.denominator, 0)) throw new FractionDenominatorIsZeroException();
        this.numerator = numerator.longValue();
        this.denominator = denominator.longValue();  
        changeSignal();
    }
   
    private void changeSignal(){
        if(numerator > 0 && denominator < 0){
            numerator = numerator * (-1);
            denominator = Math.abs(denominator);
        }
        if(numerator < 0 && denominator < 0){
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
    }
    
    public static Fraction of(){return new Fraction(1, 1);}
    public static Fraction of(Integer numerator){return new Fraction(numerator, 1);}
    public static Fraction of(Long numerator){return new Fraction(numerator, 1L);}
    public static Fraction of(Double number){
        return FractionConverter.parse(number).simplify();
    } 
    
    public static Fraction of(Integer numerator,Integer denominator){return new Fraction(numerator, denominator);}
    public static Fraction of(Long numerator,Long denominator){return new Fraction(numerator, denominator);}
    public static Fraction of(Double numerator,Double denominator){
        if(numerator.equals(denominator)) of(1);
        return FractionConverter.parse(numerator).div(FractionConverter.parse(denominator)).simplify();
    }    
        
    public static Fraction of(Integer numerator,Long denominator){return new Fraction(numerator.longValue(), denominator);}
    public static Fraction of(Long numerator,Integer denominator){return new Fraction(numerator, denominator.longValue());}
    
    public static Fraction of(Integer numerator,Double denominator){
        return of(numerator).div(FractionConverter.parse(denominator)).simplify();
    }
    public static Fraction of(Double numerator,Integer denominator){
        return FractionConverter.parse(numerator).div(of(denominator)).simplify();
    }    
    
    public static Fraction of(Long numerator,Double denominator){
        return of(numerator).div(FractionConverter.parse(denominator)).simplify();
    }
    public static Fraction of(Double numerator,Long denominator){
        return FractionConverter.parse(numerator).div(of(denominator)).simplify();
    }     
    
    public boolean isInteger(){
        return denominator == 1;
    }
    
    public boolean isPositive() {
       return (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);
    }

    public boolean isNegative() {
        return !isPositive();
    }
    
    public boolean isProper(){
        return numerator < denominator;
    }
    
    public boolean isImproper(){
        return numerator > denominator;
    }    
    
    public boolean isApparent(){
        return numerator % denominator == 0;
    }
    
    public boolean isIrreducible(){
        return Numbers.isPrime(numerator) || Numbers.isPrime(denominator);
    }
    
    public Fraction positive(){
        return new Fraction(Math.abs(numerator), Math.abs(denominator));
    }
    
    public Fraction sum(Fraction fraction){
        if(denominator.equals(fraction.getDenominator()))
            return new Fraction(numerator + fraction.getNumerator(), denominator).simplify();
        long num = numerator * fraction.getDenominator() + denominator * fraction.getNumerator();
        long den = denominator * fraction.getDenominator();
        return new Fraction(num, den).simplify();
    }
    
    public Fraction sub(Fraction fraction){
        if(denominator.equals(fraction.getDenominator()))
            return new Fraction(numerator - fraction.getNumerator(), denominator).simplify();        
        long num = numerator * fraction.getDenominator() - denominator * fraction.getNumerator();
        long den = denominator * fraction.getDenominator();
        return new Fraction(num, den).simplify();
    }    
    
    public Fraction div(Fraction fraction) {
        return new Fraction(numerator * fraction.getDenominator(),denominator * fraction.getNumerator())
                    .simplify();
    }

    public Fraction mult(Fraction fraction) {
        return new Fraction(numerator * fraction.getNumerator(),denominator * fraction.getDenominator())
                    .simplify();
    }    
    
    public Fraction simplify(){
        long mdc = MDC.solve(numerator, denominator);
        return new Fraction(numerator / mdc, denominator / mdc);
    }
    
    public Fraction pow(int expoente){
        return pow(Integer.valueOf(expoente).longValue());
    }
    
    public Fraction pow(long number) {
        if (number > 0) {
            long num = (long) Math.pow(numerator, number);
            long den = (long) Math.pow(denominator, number);
            return new Fraction(num, den);
        } else if (number < 0) {
            number = Math.abs(number);
            long num = (long) Math.pow(numerator, number);
            long den = (long) Math.pow(denominator, number);
            return new Fraction(den, num);
        }
        return new Fraction(1, 1);
    }   
    
    public String text(){
        return FractionText.template(this);
    }
    
    public String text(boolean signal){
        return FractionText.template(this,signal);
    }
    
    public String text(long mmc){
        return FractionText.template(this,mmc);
    }
    
    public String text(long mmc, boolean signal){
        return FractionText.template(this,mmc, signal);
    }       
    
    public String html(){
        return FractionHtml.template(this);
    }
    
    public String html(boolean signal){
        return FractionHtml.template(this,signal);
    }
    
    public String html(long mmc){
        return FractionHtml.template(this,mmc);
    }
    
    public String html(long mmc, boolean signal){
        return FractionHtml.template(this,mmc, signal);
    }    
    
    /*
        en=>
        pt=>retorna a inversa da fração 2/5->5/2
    */
    public Fraction reverse() throws FractionDenominatorIsZeroException{
      if(Objects.equals(this.numerator, 0.0)) throw new FractionDenominatorIsZeroException();
      return new Fraction(denominator,numerator);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.numerator);
        hash = 97 * hash + Objects.hashCode(this.denominator);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if(!(obj instanceof Fraction)) return false;
      Fraction fraction = (Fraction) obj;
      return numerator.equals(fraction.getNumerator())
          && denominator.equals(fraction.getDenominator());
    }
    /*
        en=>fraction:
        pt=>fração: compara se as frações são equivalente 1/2=2/4,1/3=1/3
    */
    @Override
    public int compareTo(Fraction fraction) {
        long num = numerator * fraction.getDenominator();
        long den = denominator * fraction.getNumerator();
        return Long.valueOf(num).compareTo(den);
    }

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
    }
    
    @Override
    public long longValue() {return numerator / denominator;}
    @Override
    public int intValue() {return numerator.intValue() / denominator.intValue();}
    @Override
    public float floatValue() { return numerator.floatValue() / denominator.floatValue(); }
    @Override
    public double doubleValue() { return numerator.doubleValue() / denominator.doubleValue();}   
    
}
