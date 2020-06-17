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
public class p160 {
    public static void main(String[] args) {
        //System.out.println(new p160().BruteForceRun());
        System.out.println(new p160().run());
   }
    
    public String run(){
         //It was obvious to me that a zero is appended to a factorial whenever the current number is a multiple of 5
         //Actually, some of the previous numbers in the factorial needs to be a multiple of 2 because only 2*5=10 produces a zero
         //but there are far more numbers which are a multiple of 2 than a multiple of 5.
        //The concept was to multiply all odd number (except those ending with 5) modulo 10000.<br>
        //Then multiply all even numbers, but divided by 2
        //Count the number of multiples of 2 (let's call them "twos") and count the multiple of 5 ("fives")
        //and multiply the result by 2^{twos-fives}
             
        return Long.toString(factorialSuffix(1000000000000L));
        
    }
    // The last 5 digits of n!, excluding trailing zeros.
    private static long factorialSuffix(long n) {
        long twos = countFactors(n, 2) - countFactors(n, 5);  // Always non-negative for every n
        // We can reduce 'twos' because there is a cycle: 2^5 = 2^2505 = 32 mod 100000
        if (twos >= 2505)twos = (twos - 5) % 2500 + 5;
        return factorialish(n) * Library.powMod(2, (int)twos, 100000) % 100000;
    }


    // Equal to n! but with all factors of 2 and 5 removed and then modulo 10^5.
    // The identity factorialIsh(n) = oddFactorialish(n) * evenFactorialish(n) (mod 10^5) is true by definition.
    private static long factorialish(long n) {
        return evenFactorialish(n) * oddFactorialish(n) % 100000;
    }


    // The product of {all even numbers from 1 to n}, but with all factors of 2 and 5 removed and then modulo 10^5.
    // For example, evenFactorialish(9) only considers the numbers {2, 4, 6, 8}. Divide each number by 2 to get {1, 2, 3, 4}. Thus evenFactorialish(9) = factorialish(4).
    private static long evenFactorialish(long n) {
        if (n == 0)return 1;
        else    return factorialish(n / 2);
    }


    // The product of {all odd numbers from 1 to n}, but with all factors of 2 and 5 removed and then modulo 10^5.
    // By definition, oddFactorialish() never considers any number that has a factor of 2. The product of the numbers that not a multiple of 5 are accumulated by factorialCoprime().
    // Those that are a multiple of 5 are handled recursively by oddFactorialish(), noting that they are still odd after dividing by 5.
    private static long oddFactorialish(long n) {
        if (n == 0)return 1;
        else    return oddFactorialish(n / 5) * factorialCoprime(n) % 100000;
    }


    // The product of {all numbers from 1 to n that are coprime with 10}, modulo 10^5.
    // The input argument can be taken modulo 10^5 because factorialoid(10^5) = 1, and each block of 10^5 numbers behaves the same.
    private static long factorialCoprime(long n) {
        n %= 100000;
        long product = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0 && i % 5 != 0)product = i * product % 100000;
        }
        return product;
    }


    // Counts the number of factors of n in the set of integers {1, 2, ..., end}.
    // For example, countFactors(25, 5) = 6 because {5, 10, 15, 20} each has one factor of 5, and 25 has two factors of 5.
    private static long countFactors(long end, long n) {
        if (end == 0)return 0;
        else    return end / n + countFactors(end / n, n);
    }
    private static final long LIMIT_1=1000000000000L;
    private static final BigInteger LIMIT=BigInteger.valueOf(20);
    
    public String BruteForceRun() {
        BigInteger it;
        BigInteger fact=BigInteger.ONE;
        for(it=BigInteger.ONE;it.compareTo(LIMIT)==-1;it=it.add(BigInteger.ONE))
        {
            fact=fact.multiply(it);
            //System.out.println(fact);
        
        }
        fact=fact.multiply(it);
        return fact.toString();
        
    }
    
}
