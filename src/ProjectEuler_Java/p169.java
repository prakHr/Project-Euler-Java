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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Prakhar Gandhi
 */
public class p169 {
    public static void main(String[] args) {
        System.out.println(new p169().run());
   }
    /* 
     * ways(n, i, j) is the number of ways that the number n can be expressed as
     * an unordered sum of powers of 2 such that all these conditions are true:
     * - The highest possible power is 2^i
     * - The 2^i term is used between 0 and j times
     * - All lower powers of 2 are used no more than 2 times
     */
    private static final BigInteger NUMBER=BigInteger.TEN.pow(25);
    private Map<List<BigInteger>,BigInteger> ways=new HashMap<>();
    // Memoization

    public String run() {
        
        return countWays(NUMBER,NUMBER.bitLength()-1,2).toString();
    }
    private BigInteger countWays(BigInteger number,int exponent,int repetitions){
        List<BigInteger> key=Arrays.asList(number,BigInteger.valueOf(exponent),BigInteger.valueOf(repetitions));
        if(ways.containsKey(key))
            return ways.get(key);
        
        BigInteger result;
        if(exponent<0)
            result=number.equals(BigInteger.ZERO) ? BigInteger.ONE : BigInteger.ZERO;
        else{
            result=countWays(number,exponent-1,2);
            BigInteger pow=BigInteger.ONE.shiftLeft(exponent);
            BigInteger upper=pow.multiply(BigInteger.valueOf(repetitions+2));
            if(repetitions>0 && pow.compareTo(number)<=0 && number.compareTo(upper)<0)
                result=result.add(countWays(number.subtract(pow),exponent,repetitions-1));
        }
        ways.put(key, result);
        return result;
    }
    
    
}
