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

/**
 *
 * @author Prakhar Gandhi
 */
public class p216 {
    public static void main(String[] args) {
        System.out.println(new p216().run());
   }
    private static int LIMIT=Library.pow(10, 6);
    public String run() {
        Set<Long> set = new HashSet<Long>();
        for(long i=2;i<=LIMIT;i++)
            set.add(i);
        
        int count=0;
        int i=0;
        for(Integer prime:Library.listPrimes(2*LIMIT)){
            if(++i%10==0)
                System.out.println(prime+" "+set.size());
            if(prime!=2){
                Set<Long> remove=new HashSet<Long>();
                for(Long s:set){
                    if(prime>2*s)
                    {
                        remove.add(s);
                        ++count;
                    }
                    else if((2*s*s-1)%prime==0)
                    {
                        remove.add(s);
                    }
                }
                set.removeAll(remove);
            }
            
        }
        return Integer.toString(count);
    }
}
