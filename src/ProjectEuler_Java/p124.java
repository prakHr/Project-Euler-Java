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

import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p124 {
     public static void main(String[] args) {
	System.out.println(new p124().run());
   }

    private static final int LIMIT=100000;
    public String run() {
	// Modification of the sieve of Eratosthenes
        int rads[]=new int[LIMIT+1];
        //fills val=1 from fromIndex to toIndex
        Arrays.fill(rads, 1, rads.length, 1);
        
        
        //method to fill radicals
        for(int i=2;i<rads.length;i++)
        {
            if(rads[i]==1){
                for(int j=i;j<rads.length;j+=i)
                    rads[j]*=i;
            }
        }
        //pair of integers of(rad(n),n)
        IntPair data[]=new IntPair[LIMIT];
        for(int i=0;i<data.length;i++){
            data[i]=new IntPair(rads[i+1],i+1);
            
        }
        Arrays.sort(data);
        return Integer.toString(data[10000-1].b);
        
    } 

    private static final class IntPair implements Comparable<IntPair> {
        
        public final int a,b;
        public IntPair(int a ,int b) {
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(IntPair other) {
             //To change body of generated methods, choose Tools | Templates.
             if(a!=other.a)
                 return Integer.compare(a, other.a);
             else
                 return Integer.compare(b, other.b);
        }
    }
}
