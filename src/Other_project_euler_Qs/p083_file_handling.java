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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prakhar Gandhi
 */
public class p083_file_handling {
    public static void main(String[] args) {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p083_matrix.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8); //System.out.println(new p042_file_handling().readFile());
        //System.out.println(content);
        String[] namesArray = content.split("\n");
        
        int [][]GRID=new int[80][80];
        int k=0;
        for(int i=0;i<80;i++){
            String []namesArray1=namesArray[i].split(",");
            for(int j=0;j<80;j++){
                GRID[i][j]=Integer.parseInt(namesArray1[j]);
                //System.out.println(GRID[i][j]);
                
            }
            
        }
        System.out.println(new p083_file_handling().run(GRID));
        
        
   }
    private int[][]distance;
    private static final int INFINITY = Integer.MAX_VALUE / 2;
    public String run(int [][] GRID) {
        int h=GRID.length;
        int w=GRID[0].length;
        distance =new int[h][w];
        for(int[] row:distance){
            Arrays.fill(row,INFINITY);
        }
        distance[0][0]=GRID[0][0];
        for(int i=0;i<w*h;i++){
            for(int y=0;y<h;y++){
                for(int x=0;x<w;x++)
                {
                    int temp=INFINITY;
                    temp=Math.min(getDistance(x-1,y), temp);
                    temp=Math.min(getDistance(x+1,y), temp);
                    temp=Math.min(getDistance(x,y-1), temp);
                    temp=Math.min(getDistance(x,y+1), temp);
                    distance[y][x]=Math.min(GRID[y][x]+temp,
                            distance[y][x]);
                }
            }
        }
        return Integer.toString(distance[h-1][w-1]);
        
    }
    private int getDistance(int x,int y){
        if(y<0 || y>=distance.length || x<0 ||x>=distance[y].length)
            return INFINITY;
        else
            return distance[y][x];
    }
    public static String readFile(String path,Charset encoding){
      byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException ex) {
            Logger.getLogger(p098_file_handling.class.getName()).log(Level.SEVERE, null, ex);
        }
      return new String(encoded,encoding);
    }
}
