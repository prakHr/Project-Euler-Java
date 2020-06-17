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
public class p050 {
    public static void main(String[] args) {
	System.out.println(new p050().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    private static final int LIMIT = Library.pow(10, 6);
    public String run() {
	boolean[] isPrime=Library.listPrimality(LIMIT);
        int[] primes=Library.listPrimes(LIMIT);
        
        long maxSum=0;
        int maxRun=-1;
        for(int i=0;i<primes.length;i++){
            int sum=0;
            for(int j=i;j<primes.length;j++){
                sum+=primes[j];
                if(sum>LIMIT)break;
                else if(j-i>maxRun && sum>maxSum && isPrime[sum]){
                    maxSum=sum;
                    maxRun=j-i;
                }
                    
            }
        }
        return Long.toString(maxSum);
        
    }
    
}
