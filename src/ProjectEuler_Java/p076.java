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
import java.math.BigInteger;

/**
 *
 * @author HP
 */
public class p076 {
    public static void main(String[] args) {
	System.out.println(new p076().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    public String run() {
	return partitions(100,1).subtract(BigInteger.ONE).toString();
    }
    
    private static BigInteger partitions(int n,int k){
        
        BigInteger table[][]=new BigInteger[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=n;j>=0;j--){
                if(i==j)
                    table[i][j]=BigInteger.ONE;
                else if(i<j)
                    table[i][j]=BigInteger.ZERO;
                else if(j==0)
                    table[i][j]=table[i][j+1];
                else
                    table[i][j]=table[i][j+1].add(table[i-j][j]);
            }
        }
        return table[n][k];
    }
}
