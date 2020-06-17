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

public class p040 {
    public static void main(String[] args) {
	System.out.println(new p040().run1());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    private final int LIMIT=Library.pow(10, 6);//for n=5 ,488895
    public String run() {
        String ans="";
        for(int i=1;i<=LIMIT;i++)
        {
            ans=ans+Integer.toString(i);
            
        }
        System.out.println(ans.length());
        int ret=Integer.parseInt(ans.substring(0,1))*Integer.parseInt(ans.substring(9,10))*Integer.parseInt(ans.substring(99,100))*Integer.parseInt(ans.substring(999,1000))*Integer.parseInt(ans.substring(9999,10000))*Integer.parseInt(ans.substring(99999,100000))*Integer.parseInt(ans.substring(999999,1000000));
        return Integer.toString(ret);//0 based indexing
    } 
    public String run1(){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<LIMIT;i++){
            sb.append(i);
        }
        int prod=1;
        for(int i=0;i<=6;i++){
            prod*=sb.charAt(Library.pow(10, i)-1)-'0';
           
        }
        return Integer.toString(prod);
    } 
}
