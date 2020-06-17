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
public class p138 {
    
    public static void main(String[] args) {
        System.out.println(new p138().run());
   }
        
    public String run() {
        // Starting with (b/2)^2 + h^2 = L^2 and h = b +- 1
	// Using substitution, L^2 = 5x^2 +- 4x + 1
	// This is a quadratic diophantine equation (similar to Problem 94)
        // Using http://www.alpertron.com.ar/QUAD.HTM to solve the positive version
	// (https://en.wikipedia.org/wiki/Diophantine_equation#External_links)
        long sum=0;
        long x=0;
        long y=-1;
        for(int i=0;i<12;i++){
            long nx=(-9*x)+(4*y)-4;
            long ny=(20*x)+(-9*y)+8;
            
            x=nx;
            y=ny;
            
            sum+=Math.abs(y);
        }
        return Long.toString(sum);
    
    }
    
}
