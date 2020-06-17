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
public class p039 {
    public static void main(String[] args) {
	System.out.println(new p039().run());
   }
	
    public String run() {
        int maxPerimeter=0;//not max actually
        int maxTriangles=0;//max
        for(int p=1;p<=1000;p++){
            int triangles=countSolutions(p);
            if(triangles>maxTriangles){
                maxTriangles=triangles;
                maxPerimeter=p;
            }
        }
	return Integer.toString(maxPerimeter);
    }
    private static int countSolutions(int p){
        int count=0;
        for(int a=1;a<=p;a++){
            for(int b=a;b<=p;b++){
                int c=p-a-b;
                if(b<=c && a*a+b*b==c*c)
                    count++;
            }
        }
        return count;
    }
    
}
