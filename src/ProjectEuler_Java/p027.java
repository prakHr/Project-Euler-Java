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

public class p027 {
    public static void main(String[] args) {
		System.out.println(new p027().run());
	}
	
	public String run() {
            int bestNum=0;
            int bestA=0;
            int bestB=0;
            for(int a=-1000;a<=1000;a++){
                for(int b=-1000;b<=1000;b++){
                    int num=numberOfConsecutivePrimesGenerated(a,b);
                    if(num>bestNum){
                        bestNum=num;
                        bestA=a;
                        bestB=b;
                    }
                }
            }
            return Integer.toString(bestA*bestB);
	}
        private static int numberOfConsecutivePrimesGenerated(int a,int b){
            for(int i=0;;++i){
                int n=i*i+i*a+b;
                if(n<0 || !Library.isPrime(n))
                    return i;
            }
        }
}
