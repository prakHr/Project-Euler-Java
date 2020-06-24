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

import java.util.ArrayList;

/**
 *
 * @author Prakhar Gandhi
 */
public class p060 {
    public static void main(String[] args) {
        System.out.println(new p060().run());
   }
    private final static int LIMIT= 100000000;
    public String run() {
        boolean primtable[]=Library.listPrimality(LIMIT);
        ArrayList<Integer> primlist=new ArrayList<Integer>();
        for(int i=2;i<primtable.length;i++){
            if(i>9000)
                break;
            if(primtable[i])
                primlist.add(i);
        }
//        for(int i=0;i<primlist.size();i++)
//            System.out.println(primlist.get(i));
//        return "1";
        ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<primlist.size();i++){
            for(int j=i+1;j<primlist.size();j++)
            {
                if(primtable[Integer.parseInt(""+primlist.get(i)+""+primlist.get(j))]){
                    if(primtable[Integer.parseInt(""+primlist.get(j)+""+primlist.get(i))])
                    {
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        temp.add(primlist.get(i));
                        temp.add(primlist.get(j));
                        list.add(temp);
                    }
                    
                    
                }
            }
        }
        
        ArrayList<ArrayList<Integer>>list2=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<primlist.size();j++)
            {
                for(int j2=0;j2<list.get(i).size();j2++)
                {
                    if(primtable[Integer.parseInt(""+list.get(i).get(j2)+""+primlist.get(j))]
                            && primtable[Integer.parseInt(""+primlist.get(j)+""+list.get(i).get(j2))])
                    {
                        if(j2==list.get(i).size()-1){
                            ArrayList<Integer> temp=(ArrayList<Integer>)list.get(i).clone();
                            temp.add(primlist.get(j));
                            list2.add(temp);
                        }
                    }
                    else{
                        break;
                    }
                
                }
            }
        }
        
        ///////////
        ArrayList<ArrayList<Integer>>list3=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<list2.size();i++){
            for(int j=i+1;j<primlist.size();j++)
            {
                for(int j2=0;j2<list2.get(i).size();j2++)
                {
                    if(primtable[Integer.parseInt(""+list2.get(i).get(j2)+""+primlist.get(j))]
                            && primtable[Integer.parseInt(""+primlist.get(j)+""+list2.get(i).get(j2))])
                    {
                        if(j2==list2.get(i).size()-1){
                            ArrayList<Integer> temp=(ArrayList<Integer>)list2.get(i).clone();
                            temp.add(primlist.get(j));
                            list3.add(temp);
                        }
                    }
                    else{
                        break;
                    }
                
                }
            }
        }
        //////////
        ArrayList<ArrayList<Integer>>list4=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<list3.size();i++){
            for(int j=i+1;j<primlist.size();j++)
            {
                for(int j2=0;j2<list3.get(i).size();j2++)
                {
                    if(primtable[Integer.parseInt(""+list3.get(i).get(j2)+""+primlist.get(j))]
                            && primtable[Integer.parseInt(""+primlist.get(j)+""+list3.get(i).get(j2))])
                    {
                        if(j2==list3.get(i).size()-1){
                            ArrayList<Integer> temp=(ArrayList<Integer>)list3.get(i).clone();
                            temp.add(primlist.get(j));
                            list4.add(temp);
                        }
                    }
                    else{
                        break;
                    }
                
                }
            }
        }
        //////////
        for(int j=0;j<list4.size();j++){
            int sum=0;
            for(int i=0;i<list4.get(j).size();i++){
                sum+=list4.get(j).get(i);
            }
            return Integer.toString(sum);
        }
        return "0";
    } 
    
}
