
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
import java.math.BigInteger;

public class p034 {
    public static void main(String[] args) {
		System.out.println(new p034().run());
	}
	
         private final int LIMIT=100000;
	public String run() {
            int sum=0;
            for(int i=10;i<=LIMIT;i++){
                if(isCurious(i))
                {
                    sum+=i;
                    System.out.println(sum);
                }
            }
            return Integer.toString(sum);
        }
        private static boolean isCurious(int num){
            int temp=num;
            BigInteger temp1=BigInteger.valueOf(num);
            BigInteger sum=BigInteger.ZERO;
            while(temp!=0){
                sum=sum.add(Library.factorial(temp%10));
                temp=temp/10;
            }
            return temp1.equals(sum);
        }
        
    
}
