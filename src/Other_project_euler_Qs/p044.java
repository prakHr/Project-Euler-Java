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
package Other_project_euler_Qs;

/**
 *
 * @author Prakhar Gandhi
 */
public class p044 {
    public static void main(String[] args) {
        System.out.println(new p044().run());
   }
    public String run() {
        long minD=-1;// -1 means not found yet, positive number means found a candidate
        // For each upper pentagonal number index, going upward
        for(int i=2;;i++){
            long pentI=pentagonalNumber(i);
            // If the next number down is at least as big as a found difference, then conclude searching
            if(minD!=-1 && pentI-pentagonalNumber(i-1)>=minD)
                break;
            // For each lower pentagonal number index, going downward
            for(int j=i-1;j>=1;j--)
            {  
                long pentJ=pentagonalNumber(j);
                long diff=pentI-pentJ;
                if(minD!=-1 && diff>=minD)
                    break;
                else if(isPentagonalNumber(pentI+pentJ) && isPentagonalNumber(diff))
                    minD=diff;
            }
            
            
        }
        return Long.toString(minD);
    }
    private static long pentagonalNumber(int x){
        if (x <= 0)throw new IllegalArgumentException();
        return (long)x*(x*3-1)>>>1;
    }
    private static boolean isPentagonalNumber(long y){
    /* 
     * If y = pentagonalNumber(x) = x(3x-1) / 2,
     * then by the quadratic formula, the positive solution is x = (sqrt(24y + 1) + 1) / 6.
     * There exists a solution for x if and only if both of these conditions hold:
     * (24y + 1) is a perfect square, and sqrt(24y + 1) + 1 mod 6 = 0.
     * The second condition is equivalent to sqrt(24y + 1) = 5 mod 6.
     */
    
        long temp=24*y+1;
        long sqrt=Library.sqrt(temp);
        return sqrt*sqrt==temp && sqrt%6==5;
    }
}
