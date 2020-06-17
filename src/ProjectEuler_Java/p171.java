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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Prakhar Gandhi
 */
public class p171 {
    public static void main(String[] args) {
        System.out.println(new p171().run());
   }
    
    private static final int LENGTH=20;
    private static final int BASE=10;
    private static final int MODULUS=Library.pow(10,9);
    /* 
     * The key insight is to use dynamic programming to build up the answer one digit at a time.
     * 
     * Let Num(n, s) denote the set of numbers of length n (with leading zeros) whose squared digits sum to s.
     * For example, Num(2, 25) = {05, 34, 43, 50}.
     * Then for any particular n and s, we know that Num(n, s) = union of
     *   (prepend 0 to each of Num(n-1, s - 0*0)),
     *   (prepend 1 to each of Num(n-1, s - 1*1)),
     *   ...,
     *   (prepend 9 to each of Num(n-1, s - 9*9)).
     * 
     * However, keeping track of these sets of numbers explicitly is just as slow as iterating over
     * all the numbers by brute force. So instead, we only store the sums and counts of these sets,
     * and these two pieces of information are enough to determine the final answer.
     * (Furthermore, these can be reduced by the modulus.)
     */
    
    public String run() {
        // Maximum possible squared digit sum (for 99...99)
        int MAX_SQR_DIGIT_SUM=(BASE-1)*(BASE-1)*LENGTH;
        
        // sum[n][s] is the sum of all length-n numbers with a square digit sum of s, modulo MODULUS
        long  sum[][]=new long[LENGTH+1][MAX_SQR_DIGIT_SUM+1];
        // count[n][s] is the count of all length-n numbers with a square digit sum of s, modulo MODULUS
        long  count[][]=new long[LENGTH+1][MAX_SQR_DIGIT_SUM+1];
        count[0][0]=1;
        for(int i=1;i<=LENGTH;i++){
            for(int j=0;j<BASE;j++){
                for(int k=0;k+j*j<=MAX_SQR_DIGIT_SUM;k++)
                {
                    sum[i][k+j*j]=(sum[i][k+j*j]+sum[i-1][k]+Library.powMod(BASE,i-1,MODULUS)*j%MODULUS*count[i-1][k])%MODULUS;
                    count[i][k+j*j]=(count[i][k+j*j]+count[i-1][k])%MODULUS;
                    
                }
            }
        }
        long s=0;
        for(int i=1;i*i<=MAX_SQR_DIGIT_SUM;i++)
            s=(s+sum[LENGTH][i*i])%MODULUS;
        return String.format("%09d", s);
    }
   
}
