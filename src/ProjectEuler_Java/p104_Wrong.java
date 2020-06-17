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

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p104_Wrong {
     public static void main(String[] args) {
        
	System.out.println(new p104_Wrong().run());
   }
	
    public String run() {
	BigInteger f1=BigInteger.ONE;
        BigInteger f2=BigInteger.ONE;
        long k=1;
        while(true){
        
            if(isPandigital(f1)||isPandigital(f2))
                return Long.toString(k);
            BigInteger temp=f1.add(f2);
            f1=f2;
            f2=temp;
            System.out.println(k);
            k+=1;
        }
    } 
    private static boolean isPandigital(BigInteger f){
        String converted=f.toString();
        int n=converted.length();
        
        if(n<9)return false;
        char[] first=converted.substring(0,9).toCharArray();
        Arrays.sort(first);
        String conv1=first.toString();
        char [] last=converted.substring(n-9,n).toCharArray();
       Arrays.sort(first);
       String conv2=last.toString();
       if(conv1.equals("123456789") && conv2.equals("123456789"))
           return true;
       return false;
    }
 
    
}
