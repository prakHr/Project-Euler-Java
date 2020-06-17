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
public class p035 {
    public static void main(String[] args) {
		System.out.println(new p035().run());
	}
	
    private static final int LIMIT=Library.pow(10, 6);
    private boolean isPrime[]=Library.listPrimality(LIMIT-1);
    public String run() {
            int count=0;
            for(int i=0;i<isPrime.length;i++){
                if(isCircularPrime(i))
                    count++;
            }
            return Integer.toString(count);
	}
    private boolean isCircularPrime(int n){
        String s=Integer.toString(n);
        for(int i=0;i<s.length();i++){
            if(!isPrime[Integer.parseInt(s.substring(i)+s.substring(0,i))])return false;
        }
        return true;
    }
}
