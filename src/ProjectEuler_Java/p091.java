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
public class p091 {
    public static void main(String[] args) {
	System.out.println(new p091().run());
   }
	/* 
	 * Computers are fast, so we can implement this solution directly without any clever math.
	 * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
	 */
    private static final int LIMIT=50;
    public String run() {
        int count=0;
        for(int x1=0;x1<=LIMIT;x1++){
            for(int y1=0;y1<=LIMIT;y1++){
                for(int x2=0;x2<=LIMIT;x2++)
                {
                    for(int y2=0;y2<=LIMIT;y2++)
                    {
                        if(x2*y1<x1*y2 && isRightTriangle(x1,x2,y1,y2))
                            count++;
                    }
                
                }
            
            
            }
        }
	return Integer.toString(count);
    } 
    private static boolean isRightTriangle(int x1,int x2,int y1,int y2)
    {
        int a=x1*x1+y1*y1;
        int b=x2*x2+y2*y2;
        int c=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        if(a+b==c || a+c==b || b+c==a)return true;
        return false;
    }
}
