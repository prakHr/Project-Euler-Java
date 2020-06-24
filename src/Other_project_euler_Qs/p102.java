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

import static ProjectEuler_Java.p081_file_handling.readFile;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Prakhar Gandhi
 */
public class p102 {
    
    private final static int MatrixLen=1000;
    public static void main(String[] args) {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p102_triangles.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8); //System.out.println(new p042_file_handling().readFile());
        //System.out.println(content);
        String[] namesArray = content.split("\n");
        //System.out.println(namesArray[0].split(","));
        String[][] gridStr =new String[MatrixLen][namesArray.length];
        for(int i=0;i<namesArray.length;i++){
            gridStr[i]=namesArray[i].split(",");
            
        }
        int [][] triangles=new int[MatrixLen][namesArray.length];
        for(int i=0;i<gridStr.length;i++){
            
            for(int j=0;j<gridStr[i].length;j++){
               triangles[i][j]=Integer.parseInt(gridStr[i][j]);
            }
        }
        System.out.println(new p102().run(triangles));
   }
        /* 
         * Computers are fast, so we can implement this solution directly without any clever math.
         * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
         */
    public String run(int triangles[][]) {
        int count=0;
        for(int t[]:triangles){
            if(isInTriangle(t,0,0))
                count++;
        }
        return Integer.toString(count);
    }
    private static boolean isInTriangle(int t[],int x,int y){
        int a=Integer.signum((t[0]-t[2])*(y-t[1])-(t[1]-t[3])*(x-t[0]));
        int b=Integer.signum((t[2]-t[4])*(y-t[3])-(t[3]-t[5])*(x-t[2]));
        int c=Integer.signum((t[4]-t[0])*(y-t[5])-(t[5]-t[1])*(x-t[4]));
        return a==0 || b==0 || c==0 || (a==b && b==c);
    }
}
