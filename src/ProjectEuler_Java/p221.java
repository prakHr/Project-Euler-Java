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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Prakhar Gandhi
 */
public class p221 {
    public static void main(String[] args) {
        System.out.println(new p221().run());
   }
        /* 
         * A=(p*q*r)/(p*q+q*r+r*p)=(p*q*r)
         * r=(1-p*q)/(p+q) => (1-p*q)=0 mod(p+q)
        */
    private static final int limit=156000;
    public String run() {
        String ans="";
        Set<BigInteger> set=new TreeSet<BigInteger>();
        
        for(long p=0;p<=limit;p++){
            if(p%1000==0){
                System.out.println(p);
                int count=0;
                for(BigInteger A:set){
                    count++;
                    if(count==150000){
                        System.out.println("A:"+A);
                        
                        break;
                    }
                }
            }
            for(long q=-p;q<0;q++){
                if(p==-q)continue;
                if((1-p*q)%(p+q)==0){
                    long r=(1-p*q)/(p+q);
                    BigInteger A=BigInteger.valueOf(p).multiply(BigInteger.valueOf(q)).multiply(BigInteger.valueOf(r)).abs();
                    set.add(A);
                }
            }
        }
        System.out.println("Size of set:"+set.size());
        int count=0;
        for(BigInteger A:set){
            count++;
            if(count==6 || count==1000){
                System.out.println(A);
               
            }
            else if(count==150000){
                ans=A.toString();
                break;
            }
                
        }
        return ans;
    }
    
}
