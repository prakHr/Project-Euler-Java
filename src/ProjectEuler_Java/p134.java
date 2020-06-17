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
public class p134 {
    public static void main(String[] args) {
	System.out.println(new p134().run());
   }
    /* 
    * Let p and q be the two primes. Let k be the smallest power of 10 that exceeds p.
    * The number that we seek is n = mk + p, where n is divisible by q, and m is minimized.
    * (For example, p = 19, q = 23, k = 100, m = 12, n = 1219.)
    * 
    * Firstly, n = mk + p = 0 mod q. By rearrangement, m = -p k^-1 mod q. (k^-1 exists because q is coprime with 10.)
    * Then of course the smallest m that satisfies the divisibility condition is the one such that 0 <= m < q.
    */
	
    public String run() {
        long sum=0;
        int primes[]=Library.listPrimes(2000000);
        for(int i=2;primes[i]<=1000000;i++){
            int p=primes[i];
            int q=primes[i+1];
            int k=1;
            while(k<p)k=k*10;
            long m=(long)(q-p)*Library.reciprocalMod(k%q, q)%q;
            sum+=m*k+p;
            
        }
        return Long.toString(sum);
    }
    
}
