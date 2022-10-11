package com.ei.math.fraction.util;

public class Numbers {
    
    public static boolean isPrime(int numero) {
        for (int j = 2; j < numero; j++) 
            if (numero % j == 0) 
                return false;
        return true;
   }
    
    public static boolean isPrime(long numero) {
        for (long j = 2; j < numero; j++) 
            if (numero % j == 0) 
                return false;
        return true;
   }



}
