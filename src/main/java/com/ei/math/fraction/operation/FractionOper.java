package com.ei.math.fraction.operation;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResult;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
/**
 *{@code FractionOper} is the super class for the operation classes (FractionSum, FractionSub, FractionMult, FractionDiv)
 * 
 * @author  Sedrac Lucas Calupeteca
 * @since   1.0
 */
@Setter
public abstract class FractionOper {
    protected List<Step> list;
    
    {list = new ArrayList<>();}
    
    protected  void init(){
        list = new ArrayList<>();
    }
    
    public abstract FractionResult solve(Fraction first, Fraction second);
    public abstract FractionResult solve(Fraction first, Fraction second,String method);
    public abstract FractionResult solve(String expression, String method);
    public abstract FractionResult solve(String expression);
    
}
