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
public class p005 {
     public static void main(String[] args) {
	System.out.println(new p005().run());
    }
     /* 
	 * The smallest number n that is evenly divisible by every number in a set {k1, k2, ..., k_m}
	 * is also known as the lowest common multiple (LCM) of the set of numbers.
	 * The LCM of two natural numbers x and y is given by LCM(x, y) = x * y / GCD(x, y).
	 * When LCM is applied to a collection of numbers, it is commutative, associative, and idempotent.
	 * Hence LCM(k1, k2, ..., k_m) = LCM(...(LCM(LCM(k1, k2), k3)...), k_m).
	 */
     public String run(){
         BigInteger allLcm=BigInteger.ONE;
         for(int i=1;i<=20;i++){
             allLcm=lcm(BigInteger.valueOf(i),allLcm);
             
         }
         return allLcm.toString();
     }
     private static BigInteger lcm(BigInteger x,BigInteger y){
         return x.divide(x.gcd(y)).multiply(y);
     }
}
