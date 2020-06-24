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


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prakhar Gandhi
 */
public class p098_file_handling {
    //https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p098.java
    //https://projecteuler.net/problem=98
    //https://www.mathblog.dk/project-euler-98-anagrams-square-numbers/
    public static void main(String[] args) {
        System.out.println(new p098_file_handling().run());
   }
        /* 
         * Computers are fast, so we can implement this solution directly without any clever math.
         * A conservative upper bound for the sum is 1000 * 1000, which fits in a Java int type.
         */
    public String run() {
        String filePath="C:\\Users\\HP\\Downloads\\Text Files\\p098_words.txt";
	String content=null;
        content=readFile(filePath,StandardCharsets.UTF_8);
        
        String[] WORDSARRAY = content.split(",");
        String[] WORDS=new String[WORDSARRAY.length];
        for(int i=0;i<WORDSARRAY.length;i++){
            WORDS[i]=WORDSARRAY[i].substring(1,WORDSARRAY[i].length()-1);
        }
//        for(int i=0;i<WORDS.length;i++)
//        {
//            System.out.println(WORDS[i]);
//        }
//        return "1";
           Map<String,List<String>> anagrams=new HashMap<>();
        for (String WORDS1 : WORDS) {
            //System.out.println(WORDS1);
            String key = canonicalize(WORDS1);
            //System.out.println(WORDS1+":"+key);
            if(!anagrams.containsKey(key))
                anagrams.put(key, new ArrayList<>());
            anagrams.get(key).add(WORDS1);
        }
//           for(int i=0;i<WORDS.length;i++)
//            {
//                System.out.println(anagrams.get(WORDS[i]));
//            }
//      
           
           int max=0;
           for(String key:anagrams.keySet()){
               List<String> words=anagrams.get(key);
               for(int i=0;i<words.size();i++)
               {
                   for(int j=i+1;j<words.size();j++){
                       int assignments[]=new int['Z'+1];
                       Arrays.fill(assignments,-1);
                       max=Math.max(maxSquarePair(words.get(i),words.get(j),0,assignments,new boolean[10]), max);
                   }
               }
           }
           return Integer.toString(max);
    }
    private static String canonicalize(String s){
        char[] c=s.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
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

    private int maxSquarePair(String a,
            String b, int index,
            int[] assignments,
            boolean[]isDigitUsed ) {
        if(index==a.length()){
            //leading zeroes are not permitted
            if(assignments[a.charAt(0)]==0 || assignments[b.charAt(0)]==0)
                return 0;
            int aNum=0;
            int bNum=0;
            for(int i=0;i<a.length();i++){
                aNum=aNum*10+assignments[a.charAt(i)];
                bNum=bNum*10+assignments[b.charAt(i)];
            }
            if(Library.isSquare(aNum) && Library.isSquare(bNum))
                return Math.max(aNum, bNum);
            else    
                return 0;
      
        }
        else if(assignments[a.charAt(index)]!=-1)
            return maxSquarePair(a,b,index+1,assignments,isDigitUsed);
        else{
            int max=0;
            for(int i=0;i<10;i++)
            {
                if(!isDigitUsed[i]){
                    isDigitUsed[i]=true;
                    assignments[a.charAt(index)]=i;
                    max=Math.max(maxSquarePair(
                            a,b,index+1,
                            assignments,
                            isDigitUsed
                    ), max);
                    isDigitUsed[i]=false;
                    assignments[a.charAt(index)]=-1;
                    
                }
            }
            return max;
        }
    }
}
