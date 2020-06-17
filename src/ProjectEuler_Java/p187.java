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
public class p187 {
    public static void main(String[] args) {
        System.out.println(new p187().run());
   }
    private static final int LIMIT = Library.pow(10, 8) - 1;
	
	
	/* 
	 * LIMIT is the highest number that we will test for being semiprime.
	 * Make a list of primes: 2, 3, 5, 7, ... . Stop beyond LIMIT/2, because one of the prime factors in the semiprime is at least 2.
	 * For each prime p in the list, look at the set of numbers q such that q >= p and pq <= LIMIT.
	 * Actually, we can stop when p^2 > LIMIT, as we'll see later.
	 * In this algorithm, we find the index 'end' such that primes[i] * primes[end] > LIMIT.
	 * So for that p, we have (end - i) different choices for q. Since q >= p, all these pairs are unique.
	 * Furthermore, by the fundamental theorem of arithmetic, all the products pq are unique.
	 */

    public String run() {
        int count = 0;
        
        int primes[]=Library.listPrimes(LIMIT/2);
        for(int i=0,sqrt=Library.sqrt(LIMIT);i<primes.length && primes[i]<=sqrt;i++)
        {
            int end=Arrays.binarySearch(primes, LIMIT/primes[i]);
            if(end>=0)
                end++;
            else
                end=-end-1;
            count+=(end-i);
            
        }
        
        return Integer.toString(count);
    } 
    
}
