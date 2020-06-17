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
public class p214 {
    public static void main(String[] args) {
        System.out.println(new p214().run());
   }
    private static final int LIMIT = 40000000;
    
    public String run() {
        int totient[]=Library.listTotients(LIMIT-1);
        int totientChainLength[]=new int[totient.length];
        totientChainLength[0]=0;
        long sum=0;
        // Fill table in ascending order because totient chains are strictly decreasing

        for(int i=1;i<totient.length;i++){
            int chainlen = totientChainLength[totient[i]]+1;
            totientChainLength[i]=chainlen;
            if(chainlen==25 && totient[i]==i-1)
                sum+=i;
        }
        return Long.toString(sum);
    }
    
}
