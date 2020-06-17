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

public class p045 {
    public static void main(String[] args) {
        
        //System.out.println(isPentagonal(1));
	System.out.println(new p045().run());
   }
	
    /* n*(n+1)/2,m*(3*m-1)/2,k*(2*k-1)
     * 
     */
    public String run() {
        int i=286;
        int j=166;
        int k=144;
        while(true){
            long triangle=(long)i*(i+1)/2;
            long pentagon=(long)j*(j*3-1)/2;
            long hexagon=(long)k*(k*2-1);
            long min=Math.min(Math.min(hexagon, pentagon), triangle);
            if(min==triangle && min==pentagon && min==hexagon)
                return Long.toString(min);
            if(min==triangle)i++;
            if(min==pentagon)j++;
            if(min==hexagon)k++;
        }
        
    }
    
}
    
