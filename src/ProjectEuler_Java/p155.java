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

import java.util.HashSet;
import java.util.Set;
import custom_utils_pack.Rational;



/**
 *
 * @author Prakhar Gandhi
 */
public class p155 {
    //https://github.com/thrap/project-euler/blob/master/src/Java/Problem155.java
    public static void main(String[] args) {
        System.out.println(new p155().run());
   }
    private static final int n=18;
    public String run() {
        Set<Rational> subunits[]=new HashSet[n+1];
        for(int i=0;i<subunits.length;i++){
            subunits[i]=new HashSet<Rational>();
        }
        subunits[1].add(new Rational(60,1));
        for(int i=2;i<subunits.length;i++){
            System.out.println(i);
            for(int a=1;a<i && i-a>=a;a++){
                int b=i-a;
                for(Rational sub1:subunits[a]){
                    for(Rational sub2:subunits[b]){
                        subunits[i].add(sub1.multiply(sub2).divide(sub2.add(sub1)));
                        subunits[i].add(sub1.add(sub2));
                    }
                }
            }
        }
        Set<Rational> values=new HashSet<>();
        for(int i=0;i<subunits.length;i++)
            values.addAll(subunits[i]);
        
        return Integer.toString(values.size());
    }
    
}
