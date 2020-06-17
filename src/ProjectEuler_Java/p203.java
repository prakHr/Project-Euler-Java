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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Prakhar Gandhi
 */
public class p203 {
    
    public static void main(String[] args) {
        System.out.println(new p203().run());
   }
    private long primesSquared[];
    public String run() {
        // Collect unique numbers in Pascal's triangle
        Set<Long> numbers=new HashSet<>();
        long max=0;
        for(int n=0;n<=50;n++){
            for(int k=0;k<=n;k++){
                BigInteger x=Library.binomial(n, k);
                numbers.add(x.longValue());
                max=Math.max(x.longValue(), max);
            
            }
        }
        // Prepare list of squared primes
        int primes[]=Library.listPrimes((int)Library.sqrt(max));
        primesSquared=new long[primes.length];
        for(int i=0;i<primes.length;i++)
        {
            primesSquared[i]=(long)primes[i]*primes[i];
        }
        // Sum up the squarefree numbers
        long sum=0;
        for(long n:numbers){
            if(isSquareFree(n))
                sum+=n;
        }
        return Long.toString(sum);
        
    }
    private boolean isSquareFree(long n){
        for(long p2:primesSquared)
        {
            if(p2>n)break;
            if(n%p2==0)return false;
        }
        return true;
    }
}
