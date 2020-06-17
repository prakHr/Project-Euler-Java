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

public class p003 {
    public static void main(String[] args) {
		System.out.println(new p003().run());
	}
    /* 
     * By the fundamental theorem of arithmetic, every integer n > 1 has a unique factorization as a product of prime numbers.
     * In other words, the theorem says that n = p_0 * p_1 * ... * p_{m-1}, where each p_i > 1 is prime but not necessarily unique.
     * Now if we take the number n and repeatedly divide out its smallest factor (which must also be prime), then the last
     * factor that we divide out must be the largest prime factor of n. For reference, 600851475143 = 71 * 839 * 1471 * 6857.
     */
    public String run(){
        long n=600851475143L;
        while(true){
            long p=smallestFactor(n);
            if(p<n)n=n/p;
            else return Long.toString(n);
        }
    }
    
    // Returns the smallest factor of n, which is in the range [2, n]. The result is always prime.
    private static long smallestFactor(long n){
        if(n<=1)
            throw new IllegalArgumentException();
        for(long i=2,end=(long)Math.sqrt(n);i<=end;i++){
            if(n%i==0)
                return i;
        }
        return n;
    }
}
