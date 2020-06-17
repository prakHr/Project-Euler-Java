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

/**
 *
 * @author Prakhar Gandhi
 */

public class p123 {
    private static final int PRIME_LIMIT = 1000000;
    private static final long THRESHOLD = 10000000000L;
    
     public static void main(String[] args) {
	System.out.println(new p123().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    public String run() {
	int primes[]=Library.listPrimes(PRIME_LIMIT);
        for(int n=5;n<=primes.length;n+=2){
            /* 
            * Using the result from Project Euler #120, we know that
            * (a-1)^n + (a+1)^n mod a^2 = if n is even then 2 else 2an.
            * Since 2 is tiny, we can skip the n is even case.
            * a is the n'th (1-based) prime number, so a > n. In fact for n >= 5,
            * we have a > 2n, so we can take 2an directly without moduloing it by a^2.
            */
            long rem=2*primes[n-1]*(long)n;
            if(rem>THRESHOLD)
                return Integer.toString(n);
        
        }
        throw new AssertionError("Not Found");
    } 
}
