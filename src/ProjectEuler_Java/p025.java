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


public class p025 {
    public static void main(String[] args) {
		System.out.println(new p025().run());
	}
	
	public String run() {
            /*
             * Computes the count of fibonacci numbers that has length of 1000 digit  
             */
		BigInteger a=BigInteger.ONE;
                BigInteger b=BigInteger.ONE;
                int index=1;
                while(true){
                  if(Contains1000Digits(a) || Contains1000Digits(b)){
                      break;
                  }
                  System.out.println(a);
                  
                  BigInteger temp =(a.add(b));
                  b=a;
                  a=temp;
                  
                  
                  
                  index+=1;
                }
                return Integer.toString(index+1);
	}
        public boolean Contains1000Digits(BigInteger x){
            String a=x.toString();
            return a.length()==1000;
        }
    
}
