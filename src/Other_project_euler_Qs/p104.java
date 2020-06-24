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
package Other_project_euler_Qs;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p104 {
    public static void main(String[] args) {
        System.out.println(new p104().run());
   }
        /* 
         * Computers are fast, so we can implement this solution directly without any clever math.
         * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
         */
    public String run() {
        int i=0;
        int a=0;
        int b=1;
        while(!isFound(i,a)){
            int c=(a+b)%1000000000;
            a=b;
            b=c;
            i++;
        }
        return Integer.toString(i);
    }
    private static boolean isFound(int n,int fibMod){
        if(!isPandigital(Integer.toString(fibMod)))
            return false;
        BigInteger fib=fibonacci(n)[0];
        return isPandigital(leading9Digits(fib));
             
    }
    private static String leading9Digits(BigInteger x){
        // We know that x.bitLength() = floor(log2(x)) + 1.
	// Now compute an approximate base-10 logarithm, because log10(2) = 0.301... .
	// The computed quantity is no larger than floor(log10(x)).
	int log10 = (x.bitLength() - 1) * 3 / 10;
        
	// Chop off quite a number of rightmost base-10 digits.
	// It is guaranteed that there remains at least 9 digits.
	x = x.divide(BigInteger.TEN.pow(Math.max(log10 + 1 - 9, 0)));
		
	// Deal with the remaining smaller number.
	return x.toString().substring(0, 9);
    }
    private static boolean isPandigital(String s){
        if(s.length()!=9)return false;
        char temp[]=s.toCharArray();
        Arrays.sort(temp);
        return new String(temp).equals("123456789");
    }
    // Returns the pair [fib(n), fib(n + 1)].
    private static BigInteger[] fibonacci(int n)
    {
        if(n==0)
            return new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};
        else{
            BigInteger[] ab=fibonacci(n/2);
            BigInteger a=ab[0];
            BigInteger b=ab[1];
            
            BigInteger c=a.multiply(b.shiftLeft(1).subtract(a));
            BigInteger d=a.multiply(a).add(b.multiply(b));
            if(n%2==0)
                return new BigInteger[]{c,d};
            else
                return new BigInteger[]{d,c.add(d)};
        }
    }
}
