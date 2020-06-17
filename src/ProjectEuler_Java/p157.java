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
import custom_utils_pack.Euler;

/**
 *
 * @author Prakhar Gandhi
 */
public class p157 {
    public static void main(String[] args) {
        System.out.println(new p157().run());
   }
       
    private static final int N=9;
    private static final int LIMIT=10;
    public String run() {
        int matches=0;
        Set<Long> set=new TreeSet<Long>();
        
        for(int a=0;a<=LIMIT;a++)
        {
            for(int b=0;b<=LIMIT;b++)
            {
                for(int c=0;c<=LIMIT;c++)
                {
                    for(int d=0;d<=LIMIT;d++)
                    {
                        long i=pow(2,a)*pow(5,b)
                                +pow(2,c)*pow(5,d);
                        while(i%2==0)
                            i=i/2;
                        while(i%5==0)
                            i=i/5;
                        
                        for(long long1:Euler.divisorList(i))
                            set.add(long1);
                        
                    }
                }
                
            }
        }
        int iteration=0;
        for(long i:set){
            System.out.println(matches+" ("+(++iteration)+"/"+set.size()+")");
            for(int a2s=0;a2s<=N+1;a2s++){
                for(int a5s=0;a5s<=N+1;a5s++)
                {
                    BigInteger A=BigInteger.valueOf(i).multiply(BigInteger.valueOf(2).pow(a2s)).multiply(BigInteger.valueOf(5).pow(a5s));
                    for(int b2s=0;b2s<=N+1;b2s++)
                    {
                        for(int b5s=0;b5s<=N+1;b5s++)
                        {
                            BigInteger B=BigInteger.valueOf(i).multiply(BigInteger.valueOf(2).pow(b2s)).multiply(BigInteger.valueOf(5).pow(b5s));
                            if(A.compareTo(B)==1)
                                continue;
                            
                            for(int n=1;n<=N;n++){
                                if(BigInteger.TEN.pow(n).multiply(A.add(B)).mod(A.multiply(B)).equals(BigInteger.ZERO))
                                    matches++;
                            }

                        }
                    }
        }
                }  
            
            }
        return "Solution: "+Integer.toString(matches)+" ";
        }
    
    private static long pow(int i, int a) {
	return (long)Math.pow(i, a);
        }
    
    
}
