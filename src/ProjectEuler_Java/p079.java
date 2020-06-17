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
public class p079 {
    public static void main(String[] args) {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p079_keylog.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8); //System.out.println(new p042_file_handling().readFile());
        //System.out.println(content);
        String[] SUBSEQS = content.split("\n");
        //List<String> namesList = Arrays.asList(content.split("\n"));
       // System.out.println(namesList);
       
       System.out.println(new p079.run(SUBSEQS));
      
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
    private static char[] packedSubseqs;
    
    

    private static class run {

        private run(String[] SUBSEQS) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public String run(String [] SUBSEQS ) {
        packedSubseqs=new char[SUBSEQS.length*3];
        
        
        throw new RuntimeException("Not found");
    }
    }
    
}
