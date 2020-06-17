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
public class p150 {
    public static void main(String[] args) {
        System.out.println(new p150().run());
   }
    private static final int ROWS=1000;  
    public String run() {
        LcgRandom rand=new LcgRandom();
        // Generate the triangle
        int triangle[][]=new int[ROWS][];
        for(int i=0;i<triangle.length;i++){
            triangle[i]=new int[i+1];
            for(int j=0;j<=i;j++)
                triangle[i][j]=rand.next();
        }
        // Calculate cumulative sums for each row
        int rowSums[][]=new int[triangle.length][];
        for(int i=0;i<rowSums.length;i++){
            rowSums[i]=new int[triangle[i].length+1];
            rowSums[i][0]=0;
            for(int j=0;j<=i;j++)
                rowSums[i][j+1]=rowSums[i][j]+triangle[i][j];
        }
        // Calculate minimum subtriangle sum for each apex position
        long minSum=0;
        for(int i=0;i<triangle.length;i++)
        {   
            for(int j=0;j<triangle[i].length;j++)
            {
                // Apex element selected at triangle[i][j]
                long curSum=0;
                for(int k=i;k<triangle.length;k++)
                {
                    curSum += rowSums[k][k-i+1+j]-rowSums[k][j];
                    minSum=Math.min(curSum,minSum);
                }
            }
        }
        return Long.toString(minSum);
    }
    private static final class LcgRandom{
        private int state;
        public LcgRandom(){
            state=0;
        }
        public int next(){
            state=(615949*state+797807)&((1<<20)-1);
            return state-(1<<19);
            
        }
    }
}
