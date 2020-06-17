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

import java.math.BigInteger;

/**
 *
 * @author Prakhar Gandhi
 */
public class p206 {
    public static void main(String[] args) {
        //System.out.println(isConcealedSquare(BigInteger.valueOf(1389019170)));
        System.out.println(new p206().run());
   }
     public String run() {
        BigInteger ans=BigInteger.valueOf(100000000);
        while(true){
            if(isConcealedSquare(ans))
                return ans.toString();
            System.out.println(ans);
            ans=ans.add(BigInteger.valueOf(10));
        }
    }
     private static boolean isConcealedSquare(BigInteger x){
     
          
         BigInteger temp=x.multiply(x);
         int index=0;
         String conv="";
         while(!temp.equals(BigInteger.ZERO)){
             if(index%2==0)
                 conv=temp.mod(BigInteger.valueOf(10)).toString()+conv;
             temp=temp.divide(BigInteger.valueOf(10));
             index+=1;
         }
         //System.out.println("conv:"+conv);
         if(conv.equals("1234567890"))
             return true;
         return false;
     }
    
}
