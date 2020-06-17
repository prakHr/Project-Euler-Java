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
import java.util.HashMap;

public class p029 {
    public static void main(String[] args) {
		System.out.println(new p029().run());
	}
	
         
	public String run() {
            HashMap m=new HashMap<>();
            for(int a=2;a<=100;a++){
                for(int b=2;b<=100;b++)
                {
                    m.put(Math.pow(b, a), 1);
                    
                }
            }
            return Integer.toString(m.keySet().size());
	}
    
}