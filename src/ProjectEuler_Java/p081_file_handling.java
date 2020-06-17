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
import static ProjectEuler_Java.p042_file_handling.readFile;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class p081_file_handling {
    private final static int MatrixLen=80;
    public static void main(String[] args) {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p081_matrix.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8); //System.out.println(new p042_file_handling().readFile());
        //System.out.println(content);
        String[] namesArray = content.split("\n");
        
        String[][] gridStr =new String[MatrixLen][MatrixLen];
        for(int i=0;i<namesArray.length;i++){
            gridStr[i]=namesArray[i].split(",");
            
        }
        int [][] grid=new int[MatrixLen][MatrixLen];
        for(int i=0;i<gridStr.length;i++){
            
            for(int j=0;j<gridStr[i].length;j++){
               grid[i][j]=Integer.parseInt(gridStr[i][j]);
            }
        }
        String ans=run(grid);
        System.out.println(ans);
        //System.out.println(namesArray[0]);
        //List<String> namesList = Arrays.asList(content.split("\n"));
        //System.out.println(namesList);
    }
    public static String readFile(String path,Charset encoding){
      byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException ex) {
            Logger.getLogger(p042_file_handling.class.getName()).log(Level.SEVERE, null, ex);
        }
      return new String(encoded,encoding);
    }
    public static String run(int[][]grid){
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[i].length-1;j>=0;j--){
                int temp;
                if(i+1 < grid.length && j+1<grid[i].length)
                    temp=Math.min(grid[i+1][j],grid[i][j+1]);
                else if(i+1<grid.length)
                    temp=grid[i+1][j];
                else if(j+1<grid[i].length)
                    temp=grid[i][j+1];
                else
                    temp=0;
                grid[i][j]+=temp;
                
            
            }
            
        }
        return Integer.toString(grid[0][0]);
    }
    
}
