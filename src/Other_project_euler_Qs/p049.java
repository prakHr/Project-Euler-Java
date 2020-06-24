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
package Other_project_euler_Qs;

import java.util.Arrays;

/**
 *
 * @author Prakhar Gandhi
 */
public class p049 {
    public static void main(String[] args) {
        //System.out.println(new p049().BruteForcerun());
        System.out.println(new p049().run());
   }
    private static final int LIMIT=10000;
    public String run(){
        boolean isPrime[]=Library.listPrimality(LIMIT-1);
        for(int base=1000;base<LIMIT;base++){
            if(isPrime[base])
            {
                for(int step=1;step<LIMIT;step++)
                {
                    int a=base+step;
                    int b=a+step;
                    if(a<LIMIT && isPrime[a] && hasSameDigits(a,base)
                   && b<LIMIT && isPrime[b] && hasSameDigits(b,base)
                            &&(base!=1487 || a!=4817))
                        return ""+base+a+b;
                }
            }
        }
        throw new RuntimeException("Not found");
    }
    private static boolean hasSameDigits(int x,int y){
        char[] xD=Integer.toString(x).toCharArray();
        char[] yD=Integer.toString(y).toCharArray();
        Arrays.sort(xD);
        Arrays.sort(yD);
        return Arrays.equals(xD, yD);
    
    }
    public String BruteForcerun() {
        int ans1=0,ans2=0,ans3=0;
        for(int i=1000;i<LIMIT;i++){
            for(int j=i+1;j<LIMIT;j++){
                for(int k=j+1;k<LIMIT;k++)
                {
                    int a=j-i;
                    int b=k-j;
                    int c=i-0;
                    String converted_a=Integer.toString(a);
                    String converted_b=Integer.toString(b);
                    String converted_c=Integer.toString(c);
                    
                    char c_A[]=converted_a.toCharArray();
                    char c_B[]=converted_b.toCharArray();
                    char c_C[]=converted_c.toCharArray();
                    
                    Arrays.sort(c_A);
                    Arrays.sort(c_B);
                    Arrays.sort(c_C);
                    
                    String sorted_a=Arrays.toString(c_A);
                    String sorted_b=Arrays.toString(c_B);
                    String sorted_c=Arrays.toString(c_C);
                    if(a==b && b==c && sorted_a.equals(sorted_c) && sorted_b.equals(sorted_a) && sorted_c.equals(sorted_b) && Library.isPrime(a) && Library.isPrime(b) && Library.isPrime(c))
                    {
                        ans1=a;
                        ans2=b;
                        ans3=c;
                        return Integer.toString(a)+Integer.toString(b)+Integer.toString(c);
                    }
                }
            }
        }
        return "-1";
    } 
    
}
