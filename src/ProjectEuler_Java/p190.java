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
public class p190 {
    public static void main(String[] args) {
       
        System.out.println(new p190().run());
   }
    /* 
     *x1+x2/2+x2/2+x3/3+x3/3+x3/3...+xm/m*m=m>=(x1*(x2/2)*(x2/2)*...(xm/m)**m)**1/m
     *2**2*3**3...m**(m+1)=(Pm)
     */
    public String run() {
        BigInteger sum = BigInteger.ZERO;
        for(int m=2;m<=15;m++)
            sum=sum.add(getMaximizedWeightedProd(m));
        return sum.toString();
    } 
    private static BigInteger getMaximizedWeightedProd(int m)
    {
        BigInteger num=BigInteger.valueOf(2).pow(m*(m+1)/2);
        BigInteger den=BigInteger.valueOf(m+1).pow(m*(m+1)/2);
        for(int i=1;i<=m;i++)
            for(int j=0;j<i;j++)
                num=num.multiply(BigInteger.valueOf(i));
        return num.divide(den);
    }
    
}
