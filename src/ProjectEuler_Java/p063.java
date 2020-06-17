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
import java.math.BigInteger;

/**
 *
 * @author HP
 */
public class p063 {
    public static void main(String[] args) {
	System.out.println(new p063().run());
   }
	
	/* 
	 * Let's examine n^k for different values of n and k and see which
	 * choices cannot possibly work (i.e. not being exactly k digits long).
	 * 
	 * When n = 10, for each k, n^k has exactly k+1 digits, so these are excluded.
	 * By extension, when n > 10, for each k, n^k has at least k+1 digits, so these are excluded.
	 * Thus we should only consider 1 <= n <= 9.
	 * 
	 * When n = 9, k = 22, then n^k has 21 digits which is insufficient.
	 * Extending this, when n = 9 and k > 22, n^k has fewer than k digits.
	 * Furthermore, when n < 9, n^k will have start to have
	 * fewer than k digits at some value of k with k < 22.
	 * Therefore we should only consider 1 <= k <= 21.
	 * 
	 * We handle the rest of the testing by brute force.
	 */
    public String run() {
        int count=0;
        for(int n=1;n<=9;n++){
            for(int k=1;k<=21;k++)
            {
                if(BigInteger.valueOf(n).pow(k).toString().length()==k)
                    count++;
            }
        }
	return Integer.toString(count);
    }
    
}
