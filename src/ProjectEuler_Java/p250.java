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

import custom_utils_pack.Rational;

/**
 *
 * @author Prakhar Gandhi
 */
public class p250 {
    public static void main(String[] args) {
        System.out.println(new p250().run());
   }
    
    private static final long MODULUS = 10000000000000000L;
      
    public String run() {
        // numSubsets[i] is {the number of subsets with sum equal to i mod 250} mod 10^16
        long numSubsets[]=new long[250];
        numSubsets[0]=1;
        for(int i=1;i<=250250;i++){
            int temp=Library.powMod(i, i, 250);
            long newArray[]=new long[numSubsets.length];
            for(int j=0;j<250;j++)
            {
                newArray[(j+temp)%250]=(numSubsets[j]+numSubsets[(j+temp)%250])%MODULUS;
            }    
            numSubsets=newArray;
        
        }
        return Long.toString((numSubsets[0]-1+MODULUS)%MODULUS);
        
    }
}
