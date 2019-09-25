// Strong Password
// https://www.hackerrank.com/challenges/strong-password/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    final static String numbers = "0123456789";
    final static String lower_case = "abcdefghijklmnopqrstuvwxyz";
    final static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String special_characters = "!@#$%^&*()-+";

    private static boolean hasTypeOfChar(String password, String charsToCheck) {
        boolean result = false;
        char[] charsSplit = charsToCheck.toCharArray();
        for (char character : charsSplit) {
            if(password.indexOf(character) >= 0) {
                System.out.println("Found " + character + " in " + charsToCheck);
                return true;
            }
        }
        System.out.println("could not find chars " + charsToCheck);
        return result;
    }

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        int conditionsMissing = 0;
        if (!hasTypeOfChar(password, numbers)) conditionsMissing++;
        if (!hasTypeOfChar(password, lower_case)) conditionsMissing++;
        if (!hasTypeOfChar(password, upper_case)) conditionsMissing++;
        if (!hasTypeOfChar(password, special_characters)) conditionsMissing++;

        int howShortOfMinimumLength = 6 - password.length();
        if (howShortOfMinimumLength > conditionsMissing) {
            return howShortOfMinimumLength;
        }
        else {
            return conditionsMissing;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}