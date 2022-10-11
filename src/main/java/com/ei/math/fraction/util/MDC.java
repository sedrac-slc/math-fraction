package com.ei.math.fraction.util;

public class MDC {
   
    public static int solve(int x){ return x;}
    public static long solve(long x){ return x;}
   
    public static long solve(long x, long y) { //return y == 0 ? x : base(y, x % y);
        long resto, mdc = 0;
        do {
            resto = x % y;
            if (resto != 0) {
                x = y;
                y = resto;
            } else  mdc = y;
        } while (resto != 0);
        return mdc;
    }
    public static int solve(int x,int y){ return solve(x, y);}
    
}
