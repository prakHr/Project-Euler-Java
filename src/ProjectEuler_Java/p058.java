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
/**
 *
 * @author HP
 */
public class p058 {

public static void main(String[] args) {
	System.out.println(new p058().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    public String run() {
	int numPrimes=0;
        for(int n=1;;n+=2){
            for(int i=0;i<4;i++)
            {
                if(Library.isPrime(n*n-i*(n-1)))
                    numPrimes++;
            }
            if(n>1 && numPrimes*10<2*n-1)
                return Integer.toString(n);
        }
    }
/* 
	 * From the diagram, let's observe the four corners of an n * n square (where n is odd).
	 * It's not hard to convince yourself that:
	 * - The bottom right corner always has the value n^2.
	 * Working clockwise (backwards):
	 * - The bottom left corner has the value n^2 - (n - 1).
	 * - The top left corner has the value n^2 - 2(n - 1).
	 * - The top right has the value n^2 - 3(n - 1).
	 * 
	 * Furthermore, the number of elements on the diagonal is 2n - 1.
	 */    
}

