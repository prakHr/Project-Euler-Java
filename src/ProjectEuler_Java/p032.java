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

public class p032 {
    public static void main(String[] args) {
		System.out.println(new p032().run());
	}
	
	/* 
	 * For contradiction suppose a candidate (x, y, z) has z >= 10000.
	 * Then x*y consumes at least 5 digits. With the 4 (or fewer)
	 * remaining digits, even the upper bound of x=99 and y=99
	 * produces a product of x*y < 10000, which is unequal to z.
	 * 
	 * Therefore we need the product z < 10000 to be able to find
	 * possible x and y values.
	 */
	public String run() {
                int sum=0;
                for(int i=1;i<10000;i++){
                    if(hasPandigitalProduct(i))
                        sum+=i;
                }
                return Integer.toString(sum);
	}
        private static boolean hasPandigitalProduct(int n){
            for(int i=1;i<=n;i++)
            {
                if(n%i==0 && isPandigital(""+n+i+n/i))
                    return true;
            }
            return false;
        }
        private static boolean isPandigital(String num){
            if(num.length()!=9)return false;
            char s[]=num.toCharArray();
            Arrays.sort(s);
            String sorted=new String(s);
            if(sorted.equals("123456789"))return true;
            return false;
        
        }
}
