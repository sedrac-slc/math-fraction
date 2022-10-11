package com.ei.math.fraction.text;

import com.ei.math.fraction.FractionConverter;
import com.ei.math.fraction.FractionRegex;

public class FractionTextParseHtml {
    
    public static String parse(String expression){
        if(expression.matches(FractionRegex.FRACTION))
            return FractionConverter.parse(expression).html(true);
        if(expression.matches(FractionRegex.FRACTION_MMC)){
            int tam = expression.length();
            int start = expression.indexOf("(");
            String frac = expression.substring(0, start);
            String mmc = expression.substring(start+1,tam-1);
            return FractionConverter.parse(frac).html(Long.parseLong(mmc));
        }
        return "";
    }
   
    
}
