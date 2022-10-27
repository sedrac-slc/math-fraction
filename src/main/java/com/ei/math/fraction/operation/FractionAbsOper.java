package com.ei.math.fraction.operation;

import com.ei.math.Step;
import com.ei.math.fraction.Fraction;
import com.ei.math.fraction.FractionResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Setter
public class FractionAbsOper {
    protected List<Step> list;
    
    {list = new ArrayList<>();}
    
    public FractionResponse solve(Fraction first, Fraction second){return null;}
   
    public FractionResponse solve(String expression, String method){return null;}
    public FractionResponse solve(String expression){return null;}
    
}
