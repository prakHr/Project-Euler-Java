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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author HP
 */
public class p074 {
    
    public static void main(String[] args) {
	System.out.println(new p074().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    private static final int LIMIT = Library.pow(10, 6);
    public String run() {
	int count = 0;
        for(int i=0;i<LIMIT;i++){
            if(getChainLength(i)==60)
                count++;
        }
        return Integer.toString(count);
    }
    private static int getChainLength(int n){
        Set<Integer> seen=new HashSet<>();
        while(true){
            if(!seen.add(n))
                return seen.size();
            n=factorialize(n);
        }
    }
    // Hard-coded values for factorial(0), factorial(1), ..., factorial(9)
    private static int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    private static int factorialize(int n)
    {
        int sum=0;
//        for(;n!=0;n/=10)
//            sum+=FACTORIAL[n%10];
        while(n!=0){
            sum+=FACTORIAL[n%10];
            n=n/10;
        }
        return sum;
    }
}
