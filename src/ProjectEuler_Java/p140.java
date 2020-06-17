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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Prakhar Gandhi
 */
public class p140 {
    public static void main(String[] args) {
        System.out.println(new p140().run());
   }
    //https://www.mathblog.dk/project-euler-140-modified-fibonacci-golden-nuggets/
    public String run() {
        long startTime = System.nanoTime();
        long result=0;
        long[][] start={ { 0, -1 }, { 0, 1 }, { -3, -2 }, { -3, 2 }, { -4, -5 }, { -4, 5 }, { 2, -7 }, { 2, 7 } };
        List<Long> nuggets = new ArrayList<>();
        for(int j=0;j<start.length;j++){
            long k=start[j][0];
            long b=start[j][1];
            for(int i=0;i<30;i++){
                long kNew=-9*k-4*b-14;
                long bNew=-20*k-9*b-28;
                
                k=kNew;
                b=bNew;
                
                if(k>0 && !nuggets.contains(k))
                    nuggets.add(k);
            }
        
        }
        Collections.sort(nuggets);
        for(int i=0;i<30;i++)
            result+=nuggets.get(i);
        
        
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
       
        System.out.println(totalTime);
        return Long.toString(result);
    }
    
}
