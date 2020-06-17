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

import custom_utils_pack.Euler;
import java.util.List;

/**
 *
 * @author Prakhar Gandhi
 */
public class p159 {
    private static int LIMIT=Library.pow(10, 6);
    private static boolean prime[]=Library.listPrimality(LIMIT);
    private static int mdrs[]=new int[LIMIT];
    
    public static int mdrs(int n){
        if(prime[n])
            return  digitalSum(n);
        else
        {
            //Take all tje divisors list less than n,
            //than split into mdrs[divisor]+mdrs[n/divisor]
            List<Integer> divisors=Euler.divisorList(n);
            int max=digitalSum(n);
            for(int i=1;i<divisors.size();i++)
            {
                int divisor=divisors.get(i);
                max=Math.max(mdrs[divisor]+mdrs[n/divisor], max);
            }
            return max;
            
        }
    }
    public static int digitalSum(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n=n/10;
        }
        if(sum>=10)return digitalSum(sum);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new p159().run());
   }
    
    public String run() {
        int sum=0;
        for(int i=2;i<LIMIT;i++){
            mdrs[i]=mdrs(i);
            sum+=mdrs[i];
        }
        return Integer.toString(sum);
    }
   
}
