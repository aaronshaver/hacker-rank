

// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/equality-in-a-array/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            int count;
            count = counts.get(num) != null ? counts.get(num) + 1 : 1;
            counts.put(num, count);
        }
        int largestCount = 0;
        int largestEntry = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > largestCount) {
                largestCount = entry.getValue();
                largestEntry = entry.getKey();
            }
        }
        
        return arr.length - largestCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/cut-the-sticks/problem
// This was a really fun puzzle!!

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> totals = new ArrayList<>();
        
        // convert to ArrayList because it's easier to work with
        List<Integer> sticks = new ArrayList<>();
        for (int stick : arr) {
            sticks.add(stick);
        }
        
        totals.add(sticks.size()); // add initial count of sticks to list of counts
        do {
            Set<Integer> set = new HashSet<Integer>(sticks);
            if (set.size() == 1) break; // all sticks are the same size
            
            Integer min = Collections.min(sticks); // get smallest stick value
            
            sticks.removeAll(Collections.singleton(min)); // remove all smallest sticks
            
            totals.add(sticks.size()); // add count of sticks to list of counts
            
        } while (sticks.size() > 1);
        
        // convert back to int array
        int[] output = new int[totals.size()];
        for (int i = 0; i < totals.size(); i++) {
            output[i] = totals.get(i);
        }
        
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/library-fine/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;
        
        if (y1 == y2) {
            if (m1 == m2) {
                if (d1 > d2) {
                    fine = 15 * (d1 - d2);
                }
            }
            else if (m1 > m2) {
                fine = (m1 - m2) * 500;
            }
        }
        else if (y1 > y2) fine = 10000;

        return fine;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/sherlock-and-squares/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        // I went through a few iterations on this puzzle
        // First I did a brute force looking at whether past the
        // decimal of a square root operation on each number was 0.0,
        // which is very slow
        //
        // Next I tried pre-computing ~31,600 squares once and doing a
        // .contains() check; I thought it was clever but it was too slow
        // 
        // Then I broke down and looked at the Discussions and found an
        // explanation in English and implemented that explanation in code
        
        final int lowFloor = (int) Math.sqrt(a);
        final int highFloor = (int) Math.sqrt(b);
        int total = highFloor - lowFloor;
        if (lowFloor * lowFloor == a) total++; // feels inelegant 
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/find-digits/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        final String numString = String.valueOf(n);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < String.valueOf(n).length(); i++) {
            nums.add(Integer.parseInt(String.valueOf(numString.charAt(i))));
        }
        
        int total = 0;
        for (Integer num : nums) {
            if (num == 0) continue;
            if (n % num == 0) total++; 
        }
        
        return total; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int position = 0;
        
        do {
            energy -= 1;
            position = (position + k) % c.length;
            int cloud = c[position];
            if (cloud == 1) energy -= 2;
        } while (position != 0);

        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/strange-advertising/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int likes = 0;
        int shared = 5;
        for (int i = 0; i < n; i++) {
            int currentLikes = (int) Math.floor(shared / 2);
            likes += currentLikes;
            shared = 3 * currentLikes;
        }

        return likes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // so the reason there are two "get reversed number" methods is because I thought
    // that that was the slow part (so I wrote a different implementation). But in fact,     
    // it was my original integers list
    // code that was slow (not totally true; see below). This still surprises me. This is the original:
    //  List<Integer> range = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    //
    // That's frustrating! My assumption was that the stream library is pretty fast,    
    // lazy evaluation, etc. whereas a brute force for loop would be slower. But clearly 
    // that is not the case! It could also have something to do with HackerRank's 
    // environment. Maybe on a real machine the Java 8 stream stuff would be fine? I don't know.
    //
    // After more research, I found someone else who used Java 8 streams and was able to get it to work, but he use a fluent API syntax
    // to do ALL the operations in one go. It's really not that different from what I was doing. So I still don't quite understand it.

    static int getReversedNum(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder = builder.reverse();
        return Integer.parseInt(builder.toString());
    }
    
    static int getReversedNum2(int n) {
        int powersCounter = 0;
        int total = 0;
        List<Integer> nums = new ArrayList<>();
        
        double currentNum = n;
        while (currentNum != 0) {
            nums.add((int) currentNum % 10);
            currentNum = Math.floor(currentNum / 10);
        }
        
        // build up the reversed number in powers of ten
        int currentPower = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i) * Math.pow(10, currentPower - 1);
            currentPower--;
        }
        
        return total;
    }
    
    static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        
        for (int m = i; m <= j; m++) {
            if ((m - getReversedNum2(m)) % k == 0) {
                beautifulDays++;
            }
        }
        
        return beautifulDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/angry-professor/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        Arrays.sort(a); // FYI, this is broken on Java 8 on HackerRank for some reason? so using their Java 7 option
        int onTime = 0;
        for (int i = 0; i < a.length; i++) {
            if (onTime < k && a[i] > 0) {
                return "YES";
            }
            else if (a[i] <= 0) {
                onTime += 1;
                if (onTime >= k) {
                    return "NO";
                }
            }
        }
        
        return "UNKNOWN";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/utopian-tree/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int height = 1;
        boolean isSpring = true;
        
        for (int i = 0; i < n; i++) {
            if (isSpring) {
                height *= 2;
            }
            else {
                height += 1;
            }
            
            isSpring = isSpring == true ? false : true;
        }
    
        return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// 8
// puzzle link: https://www.hackerrank.com/challenges/electronics-shop/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int tallest = 0;
        final int offset = 97;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            final int index = ((int) letter) - offset;
            int height = h[index];
            if (height > tallest) {
                tallest = height;
            }
        }
        
        return tallest * word.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// 7
// puzzle link: https://www.hackerrank.com/challenges/electronics-shop/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hurdleRace function below.
    static int hurdleRace(int jumpAbility, int[] heights) {
        Arrays.sort(heights);
        final int tallestHurdle = heights[heights.length - 1];
        final int difference = tallestHurdle - jumpAbility;
        if (difference <= 0) {
            return 0;
        }
        else {
            return difference;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// 6
// puzzle link: https://www.hackerrank.com/challenges/electronics-shop/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the catAndMouse function below.
    static String catAndMouse(int A, int B, int C) {
        final int aDistance = Math.abs(C - A);
        final int bDistance = Math.abs(C - B);;
       
        if (aDistance == bDistance) {
            return "Mouse C";
        }
        else if (aDistance < bDistance) {
            return "Cat A";
        }
        else {
            return "Cat B";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/electronics-shop/problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int[] reverseArray(int[] toReverse) {
        // couldn't get Collections.reverse(Arrays.asList(myArray)) to work
        // I think because these are primitives not Integers
        int len = toReverse.length;
        int[] newArray = new int[len];
        
        for (int i = 0; i < toReverse.length; i++) {
            newArray[len - 1] = toReverse[i];
            len -= 1;
        }
        
        return newArray;
    }
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int ops = 0;
        int maxSpend = -1;
        Arrays.sort(keyboards);
        Arrays.sort(drives);
       
        final int[] revKeyboards = reverseArray(keyboards);
        final int[] revDrives = reverseArray(drives);
        
        for (int i = 0; i < revKeyboards.length; i++) {
            for (int j = 0; j < revDrives.length; j++) {
                ops++;        
                int newTotal = revKeyboards[i] + revDrives[j];
                if ((newTotal <= b) && (newTotal > maxSpend)) {
                    maxSpend = newTotal;
                    break; // reduces operations considerably
                }
            }
        }
        
        System.out.printf("ops: %d", ops);
        return maxSpend;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------
// puzzle link: https://www.hackerrank.com/challenges/drawing-book/problem

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int numPages, int pageTarget) {
        // my initial instinct was to use a "cursor" of width 2 and brute force it
        // but then my experience with Project Euler led me to come up with a
        // math solution
        final int fromLeft = Math.floorDiv(pageTarget, 2);
        
        // for books w/even # pages: create a "virtual last page" to subtract from
        final int lastPage = numPages % 2 == 0 ? numPages + 1 : numPages;
        final int fromRight = Math.floorDiv(lastPage - pageTarget, 2);
        
        return fromLeft < fromRight ? fromLeft : fromRight;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
// ---------------------------------------------------------------------------


// ---------------------------------------------------------------------------// puzzle link: https://www.hackerrank.com/challenges/sock-merchant/problem

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
// puzzle title: Java Loops II// puzzle link: https://www.hackerrank.com/challenges/java-loops/problem

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

