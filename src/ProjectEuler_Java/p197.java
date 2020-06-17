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
public class p197 {
    public static void main(String[] args) {
        System.out.println(new p197().run());
   }
    private static long ITERATIONS = 1000000000000L;
	
    public String run() {
        // Floyd's cycle-finding algorithm
        double x=-1;
        double y=-1;
        long i=0;
        for(;i<ITERATIONS;i++){
            // Here at the top of the loop, x = f^i(-1) and y = f^{2i}(-1)
            if(i>0 && x==y)// This means index i is part of the cycle, and (2i - i) = i is some multiple of the true cycle length
                break;
            // Advance the states at different speeds
            x=f(x);//hare
            y=f(f(y));//rabbit
            
        }
        // Advance by many multiples of the cycle length, then deal with the remaining iterations
        long remain=(ITERATIONS-i)%i;
        for(;remain>0;remain--)
            x=f(x);
        double ans=x+f(x);
        ans=Math.floor(ans*1e9)/1e9; // Truncate to 9 digits after the decimal point
        
        return String.format("%.9f", ans);
    } 
    private static double f(double x){
        return Math.floor(Math.pow(2, 30.403243784-x*x))/1e9;
    }
    
}
