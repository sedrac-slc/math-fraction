package com.ei.math.fraction.util;

import com.ei.math.fraction.Fraction;
import java.util.List;

public class FractionUtil {

public static boolean isPositive(Fraction... fracsOther){
    return List.of(fracsOther).stream().allMatch(Fraction::isPositive);
}
    
}
