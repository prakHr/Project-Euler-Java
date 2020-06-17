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
import java.util.Arrays;

public class p041 {
    public static void main(String[] args) {
       // int i=2143;
        //System.out.println(isPandigital(i));
//        if(Library.isPrime(i) && isPandigital(i)){
//                System.out.println(i);
//                
//            }
	System.out.println(new p041().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    private static final int LIMIT=Library.pow(10,7);
    public String run() {
        
        int max=-1;
        for(int i=10;i<LIMIT;i++){
            if(Library.isPrime(i) && isPandigital(i)){
                System.out.println(i);
                if(i>max)max=i;
            }
        }
	return Integer.toString(max);
    } 
    private static boolean isPandigital(int x){
        String converted_x=Integer.toString(x);
        //System.out.println("converted_x:"+converted_x);
        int n=converted_x.length();
        if(n>=10)return false;
        //System.out.println("n:"+n);
        String digits="";
        for(int i=1;i<=n;i++)digits=digits+i;
        //System.out.println("digits:"+digits);
        char arr[]=converted_x.toCharArray();
        Arrays.sort(arr);
        //System.out.println("ärr:"+arr);
        String sorted_x=new String(arr);
        //System.out.println("sorted_x:"+sorted_x);
        return sorted_x.equals(digits);
        
    }
}
