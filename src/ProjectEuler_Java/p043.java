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

public class p043 {
    public static void main(String[] args) {
	System.out.println(new p043().run());
   }
    private static int[] DIVISIBILITY_TESTS={2,3,5,7,11,13,17};
	
    public String run() {
	long sum=0;
        int[] digits={0,1,2,3,4,5,6,7,8,9};
        outer:
        do{
            for(int i=0;i<DIVISIBILITY_TESTS.length;i++){
                if(toInteger(digits,i+1,3)%DIVISIBILITY_TESTS[i]!=0)
                    continue outer;
            }
            sum+=toInteger(digits,0,digits.length);
        }while(Library.nextPermutation(digits));
        return Long.toString(sum);
    }
    private static long toInteger(int[] digits,int off,int len){
        long result=0;
        for(int i=off;i<off+len;i++)
            result=result*10+digits[i];
        return result;
    }
}
