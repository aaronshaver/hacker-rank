// merely backup/reference of my solutions
// not intended to be compiled/interpreted/executed from this file!


// ---------------------------------------------------------------------------
// puzzle title: Java Loops II
// puzzle link: https://www.hackerrank.com/challenges/java-loops/problem

import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int total = a + b;
            int k = 1;
            String output = "" + total;
            
            for (int j=n; j > 1; j--) {
                total += Math.round(Math.pow(2, k) * b);
                output += " " + total;
                k++;
            }
            System.out.println(output);

            // in retrospect, could do this more elegantly with print or printf and not do so much string-building
            
        }
        in.close();
    }
}
// ---------------------------------------------------------------------------

