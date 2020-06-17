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
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class p052 {
    public static void main(String[] args) {
	System.out.println(new p052().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    
	
	
	public String run() {
		for (int i = 1; ; i++) {
			if (i > Integer.MAX_VALUE / 6)
				throw new ArithmeticException("Overflow");
			if (multiplesHaveSameDigits(i))
				return Integer.toString(i);
		}
	}
	
	
	private static boolean multiplesHaveSameDigits(int x) {
		for (int i = 2; i <= 6; i++) {
			if (!Arrays.equals(toSortedDigits(x), toSortedDigits(i * x)))
				return false;
		}
		return true;
	}
	
	
	private static char[] toSortedDigits(int x) {
		char[] result = Integer.toString(x).toCharArray();
		Arrays.sort(result);
		return result;
	}
}
