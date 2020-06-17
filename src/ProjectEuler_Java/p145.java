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
public class p145 {
    public static void main(String[] args) {
        //System.out.println(p145.isReversible(409));
        System.out.println(new p145().run());
   }
    private static final int LIMIT=Library.pow(10, 8);
    public String run() {
        long count=0;
        for(int i=1;i<LIMIT;i++){
            if(i%10!=0 && isReversible(i))
                count++;
        }
        return Long.toString(count);
    }
    private static boolean isReversible(int n){
        String conv=Integer.toString(n);
        String rev=Library.reverse(conv);
        int reversed_n=Integer.parseInt(rev);
        int x=n+reversed_n;
        while(x!=0){
            int singleDigit=x%10;
            if(singleDigit%2==0)return false;
            x=x/10;
        
        }
        return true;
    }
    
}
