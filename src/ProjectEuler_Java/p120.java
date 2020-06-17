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
public class p120 {
    public static void main(String[] args) {
		System.out.println(new p120().run());
	}
	
	
	/* 
	 * For a given a, what is the n that maximizes the remainder, and what is the value of this remainder?
	 * 
	 * Let's simplify one term, mod a^2:
	 *   (a+1)^n = 1^n + (n choose 1) a 1^(n-1) + (n choose 2) a^2 1^(n-2) + ...  (by the binomial theorem)
	 *           = 1 + an + 0.  (remaining addends are 0 because they have a to the power of 2 or more, mod a^2)
	 * Similarly for the other term, mod a^2:
	 *   (a-1)^n = (-1)^n + (n choose 1) a (-1)^(n-1) + ...
	 *           = (-1)^(n-1) (-1 + an + 0)
	 *           = if n is even then (1 - an) else (an - 1).
	 * Therefore, adding the two terms:
	 *   (a+1)^n + (a-1)^n
	 *   = if n is even then 2 else 2an.
	 * 
	 * We can always make 2an >= 2 by taking n=1, for example. So we can disregard the "n is even" case.
	 * Maximizing 2an mod a^2 for n is the same as maximizing 2n mod a for n.
	 *   If a is even,  then the maximum achievable value is a - 2 by setting n = a/2 - 1.
	 *   Else a is odd, then the maximum achievable value is a - 1 by setting n = (a - 1) / 2.
	 * 
	 * In conclusion, if a is even, the maximum remainder is a(a-2);
	 * otherwise a is odd, the maximum remainder is a(a-1).
	 */
	public String run() {
		int sum = 0;
		for (int a = 3; a <= 1000; a++)
			sum += a * (a - (a % 2 == 0 ? 2 : 1));
		return Integer.toString(sum);
	}
    
}
