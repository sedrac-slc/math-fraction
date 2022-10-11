package com.ei.math.fraction.util;

public class MMC {
    
    public static int solve(int x){ return x;}
    public static long solve(long x){ return x;}
   
    public static long solve(long x, long y) { //return y == 0 ? x : base(y, x % y);
        return (x*y)/MDC.solve(x,y);
    }
    public static int solve(int x,int y){ return solve(x, y);}
    
}
