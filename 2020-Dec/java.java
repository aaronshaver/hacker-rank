

// ---------------------------------------------------------------------------
// puzzle title: Sales by Match
// puzzle link: https://www.hackerrank.com/challenges/sock-merchant/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int sock : ar) {
            if (!counts.containsKey(sock)) {
                counts.put(sock, 1);
            }
            else {
                final int currentValue = counts.get(sock);
                counts.put(sock, currentValue + 1);
            }
        }
       
        Integer totalPairs = 0;
        for (Integer key : counts.keySet()) {
            final int value = counts.get(key);
            if (value >= 2) {
                totalPairs += Math.floorDiv(value, 2);
            }
        }
        
        return totalPairs; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle title: Bill Division
// puzzle link: https://www.hackerrank.com/challenges/bon-appetit/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int annaItems = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                annaItems += bill.get(i);
            }
        }
        
        final int fairCharge = annaItems / 2;
        if (b == fairCharge) {
            System.out.println("Bon Appetit");
        }
        else if (b > fairCharge) {
            System.out.println(b - fairCharge);
        }
        else {
            System.out.println("Undefined behavior");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle title: Day of the Programmer
// puzzle link: https://www.hackerrank.com/challenges/day-of-the-programmer/problem 

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    
    static int getFebTotal(int year) {
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                return 29;
            }
            else {
                return 28;
            }
        }
        else if (year >= 1919) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return 29;
            }
            else {
                return 28;
            }
        }
        else {
            // 1918 
            return 15;
        }  
    }
    
    static String dayOfProgrammer(int year) {
        final Integer febTotal = getFebTotal(year);
        final List<Integer> monthTotals = new ArrayList<>(Arrays.asList(31, febTotal, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

        int runningTotal = 0;
        int lastMonthSeen = -1;
        for (int i = 0; i < 12; i++) {
            if (runningTotal + monthTotals.get(i) <= 256) {
                runningTotal += monthTotals.get(i);
            }
            else {
                lastMonthSeen = i;
                break;
            }
        }
        
        final int dayOfMonth = 256 - runningTotal;
        final int monthOfYear = lastMonthSeen + 1; // convert to calendar-style / 1-indexing
        
        return String.format("%02d.%02d.%d", dayOfMonth, monthOfYear, year);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
// ---------------------------------------------------------------------------

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

