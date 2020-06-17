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
public class p112 {
     public static void main(String[] args) {
	System.out.println(new p112().run());
   }
	
    public String run() {
	int bouncy = 0;
	for(int i=1;;i++){
            if(isBouncy(i))
                bouncy++;
            if(bouncy*100==i*99)
                return Integer.toString(i);
        }
    } 
    private static boolean isBouncy(int x)
    {
        if(x<100)//no bouncing property in two or a single digits
            return false;
        else{
            boolean nonIncreasing=true;
            boolean nonDecreasing=true;
            int lastDigit=x%10;
            x=x/10;
            while(x!=0){
                int digit=x%10;
                if(digit>lastDigit)
                    nonDecreasing=false;
                else if(lastDigit>digit)
                    nonIncreasing=false;
                lastDigit=digit;
                x=x/10;
            }
            return !nonIncreasing && !nonDecreasing;
        }
    }
}
