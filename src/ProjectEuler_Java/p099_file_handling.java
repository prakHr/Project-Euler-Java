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

import static ProjectEuler_Java.p081_file_handling.readFile;
import static ProjectEuler_Java.p081_file_handling.run;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prakhar Gandhi
 */

public class p099_file_handling {
    
    private final static int MatrixLen=1000;
    public static void main(String[] args) {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p099_base_exp.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8); //System.out.println(new p042_file_handling().readFile());
        //System.out.println(content);
        String[] namesArray = content.split("\n");
        BigInteger[] myArray=new BigInteger[namesArray.length];
        String[][] gridStr =new String[MatrixLen][2];
         int maxIndex=-1;
        BigInteger maxx=BigInteger.ZERO;
        for(int i=0;i<namesArray.length;i++){
            gridStr[i]=namesArray[i].split(",");
            //System.out.println(gridStr[i][0]);
            //System.out.println(gridStr[i][1]);
            System.out.println(i);
            int a=Integer.parseInt(gridStr[i][0]);
            int b=Integer.parseInt(gridStr[i][1]);
            //System.out.println(a+" "+b);
            
            myArray[i]=BigInteger.valueOf(a).pow(b);
            
            if(myArray[i].compareTo(maxx)==1){
                maxx=myArray[i];
                maxIndex=(i+1);
                
            }
        }
        
       
         System.out.println(maxIndex);
        //String ans=run(grid);
       // System.out.println(ans);
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
}
