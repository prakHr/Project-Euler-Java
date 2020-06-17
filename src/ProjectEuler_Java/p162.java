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

import java.math.BigInteger;

/**
 *
 * @author Prakhar Gandhi
 */
public class p162 {
    public static void main(String[] args) {
        System.out.println(new p162().run());
   }
    /* 
     * Among the set of n-digit hexadecimal numbers, how many of them:
     *   
     *   Are there in total?: 15*16^(n-1).
     *   
     *   Have no 0?: 15^n.
     *   Have no 1?: 14*15^(n-1).
     *   Have no A?: 14*15^(n-1).
     *   
     *   Have some 0?: 15*16^(n-1) - 15^n.
     *   Have some 1?: 15*16^(n-1) - 14*15^(n-1).
     *   Have some A?: 15*16^(n-1) - 14*15^(n-1).
     *   
     *   Have no 0 and have no 1?: 14^n.
     *   Have no 0 and have no A?: 14^n.
     *   Have no 1 and have no A?: 13*14^(n-1).
     *   
     *   Have some 0 or have some 1: 15*16^(n-1) - 14^n.
     *   Have some 0 or have some A: 15*16^(n-1) - 14^n.
     *   Have some 1 or have some A: 15*16^(n-1) - 13*14^(n-1).
     *   
     *   Note: (Have X) + (Have Y) = (Have X or have Y) + (Have X and have Y).
     *   Have some 0 and have some 1: (15*16^(n-1) - 15^n) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14^n) = 15*16^(n-1) - 29*15^(n-1) + 14^n.
     *   Have some 0 and have some A: (15*16^(n-1) - 15^n) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14^n) = 15*16^(n-1) - 29*15^(n-1) + 14^n.
     *   Have some 1 and have some A: (15*16^(n-1) - 14*15^(n-1)) + (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 13*14^(n-1)) = 15*16^(n-1) - 28*15^(n-1) + 13*14^(n-1).
     *   
     *   Have no 0 and have no 1 and have no A?    : 13^n.
     *   Have some 0 or have some 1 or have some A?: 15*16^(n-1) - 13^n.
     *   
     *   Note: (Have 0 or have 1 or have A) = (Have 0) + (Have 1) + (Have A) - (Have 0 and have 1) - (Have 0 and have A) - (Have 1 and have A) + (Have 0 and have 1 and have A).
     *   Therefore:
     *     Have 0 and have 1 and have A
     *     = (15*16^(n-1) - 13^n) - (15*16^(n-1) - 15^n) - (15*16^(n-1) - 14*15^(n-1)) - (15*16^(n-1) - 14*15^(n-1)) + (15*16^(n-1) - 29*15^(n-1) + 14^n) + (15*16^(n-1) - 29*15^(n-1) + 14^n) + (15*16^(n-1) - 28*15^(n-1) + 13*14^(n-1))
     *     = 15*16^(n-1) - 43*15^(n-1) + 41*14^(n-1) - 13^n.
     */
        
    public String run() {
        BigInteger sum=BigInteger.ZERO;
        for(int n=1;n<=16;n++){
            sum=sum
                    .add(bi(15).multiply(bi(16).pow(n-1)))
                    .subtract(bi(43).multiply(bi(15).pow(n-1)))
                    .add(bi(41).multiply(bi(14).pow(n-1)))
                    .subtract(bi(13).pow(n));
        
        }
        return sum.toString(16).toUpperCase();
        
    }
    private static BigInteger bi(int n){
        return BigInteger.valueOf(n);
    }
    
}
