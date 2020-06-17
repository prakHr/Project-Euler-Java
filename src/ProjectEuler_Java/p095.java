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

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Prakhar Gandhi
 */

public class p095 {
private static final int LIMIT = Library.pow(10, 6);
public static void main(String[] args) {
	System.out.println(new p095().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    public String run() {
	// divisorSum[n] is the sum of all the proper divisors of n
        int divisorSum[]= new int[LIMIT+1];
        for(int i=1;i<=LIMIT;i++)
        {
            for(int j=i+i;j<=LIMIT;j+=i)
                divisorSum[j]+=i;
        }
        // Analyze the amicable chain length for each number in ascending order
        int maxChainLen=0;
        int minChainElem=-1;
        for(int i=0;i<=LIMIT;i++){
            Set<Integer> visited=new HashSet<>();
            for(int count=1,cur=i;;count++){
                visited.add(cur);
                int next=divisorSum[cur];
                if(next==i)
                {
                    if(count>maxChainLen){
                        minChainElem=i;
                        maxChainLen=count;
                        
                    }
                    break;
                }
                // Exceeds limit or not a chain (a rho shape instead)
                else if(next>LIMIT || visited.contains(next))
                    break;
                else
                    cur=next;
            }
        }
        return Integer.toString(minChainElem);
    } 
    
}
