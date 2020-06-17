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
public class p136 {
    public static void main(String[] args) {
        System.out.println(new p136().run());
   }
      
    /* 
	 * Let x = m, y = m - k, z = m - 2k (this is an arithmetic sequence).
	 * By tedious but straightforward algebra, x^2 - y^2 - z^2 = (m - k)(5k - m).
	 * 
	 * For the sequence to have positive descending terms, we require m > 0, k > 0, and 2k < m.
	 * We know y = m - k > 0, so this term in the product (m - k)(5k - m) is positive.
	 * Since we want x^2 - y^2 - z^2 > 0, this means we also require the term (5k - m) > 0, so 5k > m.
	 * Putting these facts together, we have m/5 < k < m/2. Note: k > m/5 is equivalent to k >= floor(m/5) + 1.
	 * 
	 * As for the search range of m, since (m - k) and (5k - m) are both positive integers,
	 * we know that (m - k)(5k - m) >= m - k > m/2. So m/2 < x^2 - y^2 - z^2 < 10^6.
	 * This means we search with 0 < m < 2 * 10^6.
	 */
    private static final int LIMIT=50*Library.pow(10, 6);
    public String run() {
        int solutions[] =new int [LIMIT];
        for(int m=1;m<2*LIMIT;m++)
        {
            for(int k=m/5+1;m>2*k;k++){
                long temp=(long)(m-k)*(5*k-m);
                if(temp>=solutions.length)break;
                solutions[(int)temp]++;
            }
        }
        int count=0;
        for(int x:solutions){
            if(x==1)count++;
        }
        return Integer.toString(count);
        
    }
    
    
}
