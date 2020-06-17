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
public class p201 {
    public static void main(String[] args) {
        System.out.println(new p201().run());
   }
        /* 
         * Computers are fast, so we can implement this solution directly without any clever math.
         * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
         */
    public String run() {
        int ALL=0;
        for(int i=1;i<=100;++i)
            ALL+=i*i;
        
        int exist[][]=new int[51][ALL+1];
        exist[0][0]=1;
        int sum=0;
        for(int i=1;i<=100;i++){
            int next[][]=new int[51][ALL+1];
            for(int j=0;j<50;j++){
                for(int k=0;k<=sum;k++){
                    next[j][k]+=exist[j][k];
                    next[j+1][k+i*i]+=exist[j][k];
                }
            }
            for(int k=0;k<=sum;k++)
            {
                next[50][k]+=exist[50][k];
            }
            sum+=i*i;
            exist=next;
        }
        int ans=0;
        for(int i=0;i<=ALL;i++)
        {
            if(exist[50][i]==1)
                ans+=i;
            
        }
        return Integer.toString(ans);
        
    } 
    
}
