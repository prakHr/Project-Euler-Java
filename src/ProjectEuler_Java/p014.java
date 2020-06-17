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


public class p014 {
    public static void main(String[] args) {
	System.out.println(new p014().run());
    }
/* 
 * We compute the Collatz chain length for every integer in the range according to the iteration rule.
 * Also, we cache the Collatz value for small integer arguments to speed up the computation.
 */
    private static final int LIMIT=Library.pow(10,6);

    public String run(){
        int maxArg=-1;
        int maxChain=0;
        for(int i=1;i<LIMIT;i++){
            int chainLen=collatzChainLength(BigInteger.valueOf(i));
            if(chainLen>maxChain){
                maxArg=i;
                maxChain=chainLen;
            }
        }
        return Integer.toString(maxArg);
    }
    // Can be set to any non-negative number, but there are diminishing returns as you go larger
    private static final BigInteger CACHE_SIZE = BigInteger.valueOf(LIMIT);
        
    private int[] collatzChainLength = new int[CACHE_SIZE.intValue()];
        
    // Returns the Collatz chain length of the given integer with automatic caching.
    private int collatzChainLength(BigInteger n){
        if(n.signum()<0)
            throw new IllegalArgumentException();
        if(n.compareTo(CACHE_SIZE)>=0)
            return collatzChainLengthDirect(n);
        int index=n.intValue();
        if(collatzChainLength[index]==0)
            collatzChainLength[index]=collatzChainLengthDirect(n);
        return collatzChainLength[index];
    }
    // Returns the Collatz chain length of the given integer, with the
    // first step uncached but the remaining steps using automatic caching.
    private int collatzChainLengthDirect(BigInteger n)
    {
        if(n.equals(BigInteger.ONE))
            return 1;
        else if(!n.testBit(0))
            return collatzChainLength(n.shiftRight(1))+1;
        else
            return collatzChainLength(n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE))+1;
    }
}

