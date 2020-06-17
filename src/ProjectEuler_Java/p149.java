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
public class p149 {
    public static void main(String[] args) {
        System.out.println(new p149().run());
   }
    private static final int SIZE=2000;
    private int[][] grid;
    public String run() {
        grid= new int[SIZE][SIZE];
        //Lagged Fibonacci Generator
        LfgRandom rand=new LfgRandom();
        for(int y=0;y<grid.length;y++)
        {
            for(int x=0;x<grid[y].length;x++)
               grid[y][x]=rand.next();
        }
        // Scan along all line directions and positions
        int max=0;
        for(int i=0;i<SIZE;i++){
            max=Math.max(getMaxSubstringSum(0,i,1,0), max);// Horizontal from left edge
            max=Math.max(getMaxSubstringSum(0,i,1,1), max);// Vertical from top edge
            max=Math.max(getMaxSubstringSum(i,0,0,1), max);// Diagonal from left edge
            max=Math.max(getMaxSubstringSum(i,0,1,1), max); // Diagonal from top edge
            max=Math.max(getMaxSubstringSum(i,0,-1,1), max);// Anti-diagonal from top edge
            max=Math.max(getMaxSubstringSum(SIZE-1,i,-1,1), max); // Anti-diagonal from right edge
            
        }
        return Integer.toString(max);
        
    }
    // For the sequence of numbers in the grid at positions (x, y), (x+dx, y+dy), (x+2*dx, y+2*dy), ... until the
    // last in-bounds indices, this function returns the maximum sum among all possible substrings of this sequence.
    private int getMaxSubstringSum(int x,int y,int dx,int dy){
        int max=0;
        for(int cur=0;0<=x && x<SIZE && 0<=y && y<SIZE;x+=dx,y+=dy)
        {
            cur=Math.max(cur+grid[y][x], 0);// Reset the running sum if it goes negative
            max=Math.max(cur,max); // Keep track of the best seen running sum
        }
        return max;
    }
    
    private static final class LfgRandom{
        //Circular buffer
        private int[] history;
        private int index;
        
        private int k;// The 1-based index of the next sequence item, but saturates at 56
        
        public LfgRandom(){
            k=1;
            history=new int[55];
            index=0;
        }
        public int next(){
            int result;
            if(k<=55){
                result=(int)((100003L - 200003L*k + 300007L*k*k*k) % 1000000) - 500000;
                k++;
                
            }
            else{
                result=(getHistory(24)+getHistory(55) + 1000000) % 1000000 - 500000;
            }
            history[index]=result;
            index=(index+1)%history.length;
            return result;
        }
     // Returns the number that was generated n steps ago, where 1 <= n <= history.length.
        private int getHistory(int n){
            if(n<=0 || n>history.length)
                throw new IllegalArgumentException();
            return history[(index-n+history.length)%history.length];
        }
    }
}
