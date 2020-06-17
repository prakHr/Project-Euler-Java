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

import custom_utils_pack.Euler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Prakhar Gandhi
 */
public class p223 {
    public static void main(String[] args) {
        System.out.println(new p223().run1());
   }
    public String run1(){
        long count=0;
        Map<Long,Long> sqrts=new HashMap<>();
        for(long i=0;i*i<LIMIT;i++)
        {
            sqrts.put(i*i,i);
        }
        for(long b=1;b<LIMIT;b++){
            if(b%1000==0)System.out.println(b+" "+count);
            for(long a=1;a<b;a++){
                if(Euler.isPerfectSquare(a*a+b*b-1))
                {
                    long c=(long)Math.sqrt(a*a+b*b-1);
                    if(a+b+c<=LIMIT)
                        count++;
                    else{
                        break;
                    }
                }
            }
        }
        return Long.toString(count);
    }
    private final int LIMIT=25*Library.pow(10, 6);
    public String run() {
        long count=0;
        for(long a=1;a<=LIMIT;a++){
            for(long b=1;b<=a;b++){
                if(b%1000==0)System.out.println(b+" "+count);
                long squared=a*a+b*b-1;
                
                if(!Euler.isPerfectSquare(squared))
                    continue;
                long c=(long)Math.sqrt(squared);
                long perimeter=a+b+c;
                if(b<=c && a+b>=c && b+c>=a && c+a>=b && perimeter<=LIMIT)
                    count++;
                        
            }
        }
        return Long.toString(count);
        
    }
    
}
