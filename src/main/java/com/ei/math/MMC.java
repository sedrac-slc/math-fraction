package com.ei.math;

public class MMC {
    
    public static int solve(int x){ return x;}
    public static long solve(long x){ return x;}
   
    public static long solve(long x, long y) { //return y == 0 ? x : base(y, x % y);
        return (x*y)/MDC.solve(x,y);
    }
    
    public static int solve(int x,int y){ 
        return (int) solve(Integer.valueOf(x).longValue(), Integer.valueOf(y).longValue());
    }
    
}
