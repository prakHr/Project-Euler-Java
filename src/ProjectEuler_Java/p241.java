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
import custom_utils_pack.Rational;
import java.util.List;

/**
 *
 * @author Prakhar Gandhi
 */
public class p241 {
    public static void main(String[] args) {
        System.out.println(new p241().run());
   }
    private final long LIMIT=Library.pow(10, 9);
    public String run() {
//        long num=2;
//        long den=4;
//        Rational a=new Rational(num,den); 
//        
//        a.simplify();
//        return a.toString();
          long sum=0;
          for(long n=8910720;n<=LIMIT;n++){
              long num=sigma(n);
              long den=n;
              Rational a=new Rational(num,den);
              //if(num==2*n)continue;
              a.simplify();
              long numSimple=a.n;
              long denSimple=a.d;
              
              if(numSimple%2==1 && denSimple==2){
                  System.out.println("num/den="+num+"/"+den+"="+numSimple+"/"+denSimple);
                  sum+=n;
              }
                  
          }
          return Long.toString(sum);
    }
    private static long sigma(long n){
        long sum=0;
        List<Long> myList= Euler.divisorList(n);
        for(int i=0;i<myList.size();i++)
            sum+=myList.get(i);
        return sum;
            
    
    }
}
