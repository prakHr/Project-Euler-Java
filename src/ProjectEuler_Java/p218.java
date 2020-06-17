/*
 * The MIT License
 *
 * Copyright 2020 Prakhar Gandhi.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ProjectEuler_Java;

import custom_utils_pack.Euler;
import java.math.BigInteger;

/**
 *
 * @author Prakhar Gandhi
 */
public class p218 {
    public static void main(String[] args) {
        System.out.println(new p218().run());
   }
     public String run() {
        int perfect=0;
        int superperfect=0;
        for(long k=0;k<100000;k++)
        {
            if(k%1000==0)
                System.out.println(k+" "+perfect);
            for(long j=1;j<k;j++){
                long m=k*k-j*j;
                long n=2*k*j;
                long o=k*k+j*j;
                if(o>Math.pow(10, 8))
                    break;
                
                long a=Math.abs(m*m-n*n);
                long b=2*m*n;
                long c=o*o;
                
                if(isPrimitive(a,b,c)){
                    perfect++;
                    if(isSuperPerfect(a,b)){
                        superperfect++;
                    }
                }
            }
        }
        
        return Long.toString(Math.abs(perfect-superperfect));
    }
     
     private static boolean isPrimitive(long a,long b,long c){
         return Euler.gcd(a, b)==1 && Euler.gcd(b, c)==1;
     }
     private static boolean isSuperPerfect(long a,long b){
         BigInteger area= BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(2));
         return area.mod(BigInteger.valueOf(28)).equals(BigInteger.ZERO) && area.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO);
     }
    
}
