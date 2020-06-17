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

public class p017 {
    public static void main(String[] args) {
	System.out.println(new p017().run());
   }
	
    public String run() {
        int sum=0;
        for(int i=1;i<=1000;i++)
            sum+=toEnglish(i).length();
        return Integer.toString(sum);
	
    }
    private static String toEnglish(int n){
        if(0<=n && n<20)
            return ONES[n];
        else if(20<=n && n<100)
            return TENS[n/10]+(n%10!=0 ? ONES[n%10]:"");
        else if(100<=n && n<1000)
            return ONES[n/100]+"hundred"+(n%100!=0 ? "and"+toEnglish(n%100):"");
        else if (1000 <= n && n < 1000000)
            return toEnglish(n/1000)+"thousand"+(n%1000!=0 ? toEnglish(n%1000):"");
        else
            throw new IllegalArgumentException();
    }
    
    private static String[] ONES = {
		"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
    private static String[] TENS = {
		"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
}
