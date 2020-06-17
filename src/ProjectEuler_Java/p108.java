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
public class p108 {
     public static void main(String[] args) {
	System.out.println(new p108().run());
   }
	
     /* 
	 * Rewrite the equation with x = n+i, y = n+j, and manipulate it:
	 *   1/n = 1/x + 1/y
	 *       = 1/(n+i) + 1/(n+j)
	 *       = (2n+i+j) / ((n+i)(n+j)).
	 *   n(2n+i+j) = (n+i)(n+j).
	 *   2n^2 + ni + nj = n^2 + ni + nj + ij.
	 *   n^2 = ij.
	 * Hence i and j are divisors of n^2. To ensure unique solutions,
	 * we impose that x <= y, so i <= j. Also, i > 0, otherwise no j exists.
	 * We have i <= j = n^2 / i, thus i^2 <= n^2. With i being positive, we get that i <= n.
	 * Therefore the number of solutions for i is the number of divisors of n^2 in the range [1, n].
	 * n^2 always has an odd number of divisors. One of them is n. As for the remainder of them, half of them are below n
	 * and half of them are above n. So if n^2 has m divisors, then we want (m+1)/2 of them as solutions for i.
	 */
    public String run() {
        for(int n=1;;n++){
            if((countDivisorsSquared(n)+1)/2>1000)
                return Integer.toString(n);
        }
        
    } 
    // Returns the number of divisors of n^2
    private static int countDivisorsSquared(int n){
        int count=1;
        for(int i=2,end=Library.sqrt(n);i<=end;i++){
            if(n%i==0){
                int j=0;
                do{
                    n/=i;
                    j++;
                }while(n%i==0);
                count*=2*j+1;
                end=Library.sqrt(n);
            }
        }
        if(n!=1)//Remaining largest prime factor
            count*=3;
        return count;
    }
}
