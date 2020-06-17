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
public class p012 {
    public static void main(String[] args) {
		System.out.println(new p012().run());
	}
	
	public String run() {
		int triangle=0;
                for(int i=1;;i++){
                    if(i+triangle>Integer.MAX_VALUE)
                        throw new ArithmeticException("Overflow");
                    triangle+=i;
                    if(countDivisors(triangle)>500)
                        return Integer.toString(triangle);
                }
	} 
        // Returns the number of integers in the range [1, n] that divide n.
        private static int countDivisors(int n){
            int count=0;
            int end=(int)Math.sqrt(n);
            for(int i=1;i<end;i++){
                if(n%i==0)count+=2;
            }
            if(end*end==n)count+=1;
            return count;
        }
        
}
