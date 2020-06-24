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

import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Prakhar Gandhi
 */
public class p019 {

    public static void main(String[] args) {
        System.out.println(new p019().run());
   }
       
    public String run() {
        int sundays=0;
        for(int year=1901;year<=2000;year++){
          for(int month=1;month<=12;month++){
              LocalDate localdate=LocalDate.of(year,month,1);
              if(localdate.getDayOfWeek().equals(SUNDAY))
                  sundays++;
                  
          }
          
      }
        return Integer.toString(sundays);
    } 
}
