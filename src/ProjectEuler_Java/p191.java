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
public class p191 {
    public static void main(String[] args) {
        System.out.println(new p191().run());
   }
    private static final int NUM_DAYS = 30;
    private static final int MAX_ABSENT = 2;
    private static final int MAX_LATE = 1;
    public String run() {
        // numPrizeStrings[i][j][k] is the number of prize strings of length i with
	// exactly j absences at the tail and exactly k lates in the whole string
        long numPrizeStrings[][][]=new long[NUM_DAYS+1][MAX_ABSENT+1][MAX_LATE+1];
        numPrizeStrings[0][0][0]=1;
        for(int i=1;i<=NUM_DAYS;i++){
            for(int j=0;j<=MAX_ABSENT;j++){
                for(int k=0;k<=MAX_LATE;k++){
                    // Count which states can be appended to the tail
                    long sum;
                    if(j==0)//if not absent on any days
                    {
                        sum=0;
                        for(int l=0;l<=MAX_ABSENT;l++)
                            sum+=numPrizeStrings[i-1][l][k];// On time
                        if(k>0){
                            for(int l=0;l<=MAX_ABSENT;l++)
                                sum+=numPrizeStrings[i-1][l][k-1];// Late
                        }
                    }
                    else{
                        sum=numPrizeStrings[i-1][j-1][k];// Absent
                        
                    }
                    numPrizeStrings[i][j][k]=sum;
                    
                }
            }
        }
        long sum=0;
        for(int j=0;j<=MAX_ABSENT;j++){
            for(int k=0;k<=MAX_LATE;k++)
                sum+=numPrizeStrings[NUM_DAYS][j][k];
        }
        return Long.toString(sum);
    } 
    
}
