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
package Other_project_euler_Qs;

import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p051 {
    public static void main(String[] args) {
        System.out.println(new p051().run());
   }
    private static final int LIMIT=1000000;
    public String run() {
        boolean isPrime[]=Library.listPrimality(LIMIT);
        for(int i=0;i<isPrime.length;i++)
        {
            if(!isPrime[i])continue;
            int n[]=toDigits(i);
            //apply all possible mask from 0 to 1<<10
            for(int mask=0;mask<(1<<n.length);mask++){
                int digits[]=doMask(n,mask);//digits with applied mask over it
                int count=0;
                for(int j=0;j<10;j++){
                    //digits[0]==0 that means number is divisible by 10
                    if(digits[0]!=0 && isPrime[toNumber(digits)])
                        count++;//count number of primes family
                    //re add the mask
                    digits=addMask(digits,mask);
                }
                if(count==8)
                {
                    digits=doMask(n,mask);
                    for(int j=0;j<10;j++)
                    {
                        if(digits[0]!=0 && isPrime[toNumber(digits)])
                            return Integer.toString(toNumber(digits));
                        digits=addMask(digits,mask);
                    }
                }
            }
        }
        throw new RuntimeException("Not Found");
        
    } 
    private static int[] toDigits(int n){
        int buf[]=new int[10];
        int i=buf.length;
        while(n!=0){
            i--;
            buf[i]=n%10;
            n=n/10;
        }
        return Arrays.copyOfRange(buf, i, buf.length);
    }
    private static int[] doMask (int digits[],int mask){
        int result[]=new int[digits.length];
        for(int i=0;i<digits.length;i++){
            result[i]=digits[i]*(~mask >>> i&1);
            
        }
        return result;
    }
    private static int toNumber(int digits[]){
        int result=0;
        for(int x:digits)
            result=result*10+x;
        return result;
    }
    private static int[] addMask (int digits[],int mask){
        int result[]=new int[digits.length];
        for(int i=0;i<digits.length;i++){
            result[i]=digits[i]+(mask >>> i&1);
            
        }
        return result;
    }
    
}
