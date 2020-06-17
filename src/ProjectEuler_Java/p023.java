
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

public class p023 {
    public static void main(String[] args) {
		System.out.println(new p023().run());
	}
    private static final int LIMIT=28213;
    private boolean[] isAbundant=new boolean[LIMIT+1];
    public String run(){
        for(int i=1;i<isAbundant.length;i++){
            isAbundant[i]=isAbundant(i);
        }
        int sum=0;
        for(int i=1;i<=LIMIT;i++)
        {
            if(!isSumOf2Abundants(i))sum+=i;
            
        }
        return Integer.toString(sum);
        
    }
    private boolean isSumOf2Abundants(int n){
        for(int i=0;i<=n;i++){
            if(isAbundant[i] && isAbundant[n-i])
                return true;
        }
        return false;
    }
    private static boolean isAbundant(int n){
        if(n<1)
            throw new IllegalArgumentException();
        int sum=1;
        int end=Library.sqrt(n);
        for(int i=2;i<=end;i++){
            if(n%i==0)sum+=i+n/i;
        }
        if(end*end==n)
            sum-=end;
        return sum>n;
    }
    
}
