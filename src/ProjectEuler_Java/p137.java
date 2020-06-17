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

/**
 *
 * @author Prakhar Gandhi
 */
public class p137 {
    public static void main(String[] args) {
        //System.out.println(new p137().BruteForcerun());
        System.out.println(new p137().run());
   }
     //Fibonacci number generating function
    //https://en.wikipedia.org/wiki/Fibonacci_number#Power_series
    public String BruteForcerun() {
        BigInteger k = BigInteger.ONE;
        int count=0,limit=15;
        while(count<limit){
            BigInteger a=k.add(BigInteger.ONE);
            BigInteger b=a.multiply(a);
            BigInteger c=k.multiply(BigInteger.valueOf(4)).multiply(k);
            BigInteger discriminantSquared=b.add(c);
            BigInteger discriminant=Library.sqrt(discriminantSquared);
            if(discriminant.multiply(discriminant)==discriminantSquared){
                System.out.println("-----------------");
                System.out.println((count+1)+": "+discriminant+" ");
                System.out.println(k);
                System.out.println("-----------------");
                count++;
            }
            k.add(BigInteger.ONE);
        }
        return k.toString();
    }
    //https://www.mathblog.dk/project-euler-137-fibonacci-golden-nuggets/
    public String run(){
        long result=0;
        for(int k=1;k<16;k++)
            result=Fibonacci(2*k)*Fibonacci(2*k+1);
        
        return Long.toString(result);
    }
    public long Fibonacci(long k){
        double sqrt5=Math.sqrt(5);
        
        return (long)((Math.pow((1+sqrt5)/2, k)-Math.pow((1-sqrt5)/2, k))/sqrt5);
    }
}
