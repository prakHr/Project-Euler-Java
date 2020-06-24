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
public class p038 {
    public static void main(String[] args) {
        System.out.println(new p038().run());
   }
        
    public String run() {
        int max=-1;
        for(int n=2;n<=9;n++){
            for(int i=1;i<Library.pow(10, 9/n);i++){
                String concat="";
                for(int j=1;j<=n;j++)
                    concat+=i*j;
                if(isPandigital(concat))
                    max=Math.max(Integer.parseInt(concat), max);
            }
        }
        return Integer.toString(max);
    } 
    private static boolean isPandigital(String s){
        if(s.length()!=9)return false;
        char temp[]=s.toCharArray();
        Arrays.sort(temp);
        return new String(temp).equals("123456789");
    }
}
