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

public class p047 {
    public static void main(String[] args) {
	System.out.println(new p047().run());
   }
	
    public String run() {
        for(int i=646;;i++){
            if( has4PrimeFactors(i)
              && has4PrimeFactors(i+1)
              && has4PrimeFactors(i+2)
              && has4PrimeFactors(i+3))
            {
                return Integer.toString(i);
            }    
        }
	
    }
    private static boolean has4PrimeFactors(int n){
        return countDistinctPrimeFactors(n)==4;
    }
    private static int countDistinctPrimeFactors(int n)
    {
        int count=0;
        for(int i=2,end=Library.sqrt(n);i<=end;i++)
        {
            if(n%i==0){
                do n/=i;
                while(n%i==0);
                count++;
                end=Library.sqrt(n);
            }
        }
        if(n>1)count++;
        return count;
    }
}
