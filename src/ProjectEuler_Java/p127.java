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

import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p127 {
  public static void main(String[] args) {
	System.out.println(new p127().run());
   }
  /* 
	 * A straightforward solution would look like this:
	 *   for (int c = 2; c < LIMIT; c++) {
	 *      for (int a = 1; a < c; a++) {
	 *        int b = c - a;
	 *        if (isAbcHit(a, b, c))
	 *          ans += c;
	 *      }
	 *   }
	 * 
	 * Here are some observations that lead to optimizations:
	 * - By Euclid's GCD algorithm, gcd(c,b) = gcd(a+b,b) = gcd(a,b) = gcd(a,a+b) = gcd(a,c).
	 *   Hence gcd(a,b) = 1 if and only if gcd(a,c) = 1 and gcd(b,c) = 1.
	 *   We only need to compute and check one of these three GCDs.
	 * - Since {a, b, c} are mutually coprime, we have rad(a * b * c) = rad(a) * rad(b) * rad(c).
	 * - For each integer n >= 2, we have 2 <= rad(n) <= n.
	 * - Therefore, it is clear that rad(c) <= rad(a * b * c). If rad(c) = c, then no solution exists for this c.
	 */
	
    private static final int LIMIT = 120000;
    public String run() {
	// Modification of the sieve of Eratosthenes
		int[] rads = new int[LIMIT];
		Arrays.fill(rads, 1, rads.length, 1);
		for (int i = 2; i < rads.length; i++) {
			if (rads[i] == 1) {
				for (int j = i; j < rads.length; j += i)
					rads[j] *= i;
			}
		}
        long sum=0;
        for(int c=2;c<LIMIT;c++){
            if(rads[c]==c)continue;
            //due to symmetry between a,c and c,a we put end=(c-1)/2
            for(int a=1,end=(c-1)/2;a<=end;a++){
                int b=c-a;
                assert a<b;
                if((long)rads[a]*rads[b]*rads[c] < c && Library.gcd(a,b)==1)
                    sum+=c;
            }
        }
        return Long.toString(sum);
    }    
}
