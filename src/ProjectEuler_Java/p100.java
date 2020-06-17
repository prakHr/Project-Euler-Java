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
public class p100 {
    public static void main(String[] args) {
	System.out.println(new p100().run());
   }
	
    /* 
	 * Suppose the box has b blue discs and r red discs.
	 * The probability of taking 2 blue discs is [b / (b + r)] * [(b - 1) / (b + r - 1)],
	 * which we want to be equal to 1/2. Rearrange the equation:
	 *   [b(b - 1)] / [(b + r)(b + r - 1)] = 1 / 2.
	 *   2b(b - 1) = (b + r)(b + r - 1).
	 *   2b^2 - 2b = b^2 + br - b + br + r^2 - r.
	 *   b^2 - b = r^2 + 2br - r.
	 *   b^2 - (2r + 1)b + (r - r^2) = 0.
	 * Apply the quadratic equation to solve for b:
	 *   b = [(2r + 1) +/- sqrt((2r + 1)^2 - 4(r - r^2))] / 2
	 *     = r + [1 +/- sqrt(8r^2 + 1)]/2
	 *     = r + [sqrt(8r^2 + 1) + 1]/2.  (Discard the minus solution because it would make b < r)
	 * 
	 * For b to be an integer, we need sqrt(8r^2 + 1) to be odd, and also 8r^2 + 1 be a perfect square.
	 * Assume 8y^2 + 1 = x^2 for some integer x > 0.
	 * We can see this is in fact a Pell's equation: x^2 - 8y^2 = 1.
	 * 
	 * Suppose we have the solution (x0, y0) such that x0 > 0 and x0 is as small as possible.
	 * This is called the fundamental solution, and all other solutions be derived from it (proven elsewhere).
	 * Suppose (x0, y0) and (x1, y1) are solutions. Then we have:
	 *   x0^2 - 8*y0^2 = 1.
	 *   (x0 + y0*sqrt(8))(x0 - y0*sqrt(8)) = 1.
	 *   (x1 + y1*sqrt(8))(x1 - y1*sqrt(8)) = 1.  (Similarly)
	 * Multiply them together:
	 *   [(x0 + y0*sqrt(8))(x0 - y0*sqrt(8))][(x1 + y1*sqrt(8))(x1 - y1*sqrt(8))] = 1 * 1.
	 *   [(x0 + y0*sqrt(8))(x1 + y1*sqrt(8))][(x0 - y0*sqrt(8))(x1 - y1*sqrt(8))] = 1.
	 *   [x0*x1 + x0*y1*sqrt(8) + x1*y0*sqrt(8) + 8y0*y1][x0*x1 - x0*y1*sqrt(8) - x1*y0*sqrt(8) + 8y0*y1] = 1.
	 *   [(x0*x1 + 8y0*y1) + (x0*y1 + x1*y0)*sqrt(8)][(x0*x1 + 8y0*y1) - (x0*y1 + x1*y0)*sqrt(8)] = 1.
	 *   (x0*x1 + 8y0*y1)^2 - 8*(x0*y1 + x1*y0)^2 = 1.
	 * Therefore (x0*x1 + 8y0*y1, x0*y1 + x1*y0) is also a solution.
	 * By inspection, the fundamental solution is (3, 1).
	 */
    public String run() {
        BigInteger x0=BigInteger.valueOf(3);
        BigInteger y0=BigInteger.ONE;
        
        BigInteger x=x0;
        BigInteger y=y0;
        
        while(true){
            //8*y*y+1
            BigInteger sqrt=Library.sqrt(y.multiply(y).multiply(BigInteger.valueOf(8)).add(BigInteger.ONE));
            if(sqrt.testBit(0)){// is odd
                BigInteger blue=sqrt.add(BigInteger.ONE).divide(BigInteger.valueOf(2)).add(y);
                if(blue.add(y).compareTo(BigInteger.TEN.pow(12))==1)
                    return blue.toString();
            }
            BigInteger nextx=x.multiply(x0).add(y.multiply(y0).multiply(BigInteger.valueOf(8)));
            BigInteger nexty=x.multiply(y0).add(y.multiply(x0));
            
            x=nextx;
            y=nexty;
        }
        
	
    } 
    
}
