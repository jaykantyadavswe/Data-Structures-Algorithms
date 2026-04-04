import java.util.ArrayList;
import java.util.List;

public class Recursions {
    // print numbers from n to 1 (Decreasing Order)
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.print(n + " ");
        printDec(n - 1);
    }

    // print numbers from 1 to n (Increasing Order)
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");

    }

    // Print factorial of a Number N -> O(n)
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        int fnm1 = fact(n - 1);
        int fn = n * fnm1;
        return fn;
    }

    // Print sum of first n natural number
    public static int printSumOfNuturalNum(int n) {
        if (n == 1) {
            return 1;
        }

        int Snm1 = printSumOfNuturalNum(n - 1);
        int Sn = n + Snm1;
        return Sn;
    }

    // Print Nth Fibonacci Number
    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fibo(n - 1);
        int fnm2 = fibo(n - 2);
        int fn = fnm1 + fnm2;

        return fn;
    }

    // Check if array is sorted or not
    public static boolean isSorted(int nums[], int i) {
        if (i == nums.length - 1) {
            return true;
        }

        if (nums[i] > nums[i + 1]) {
            return false;
        }

        return isSorted(nums, i + 1);
    }

    // Print First Occurence of idx
    public static int print1stOcc(int nums[], int i, int key) {
        if (i == nums.length - 1)
            return -1;
        if (nums[i] == key) {
            return i;
        }

        return print1stOcc(nums, i + 1, key);
    }

    // print Last Occurence of idx
    public static int lastOccu(int nums[], int i, int key) {
        if (i == nums.length - 1) {
            return -1;
        }

        int isFound = lastOccu(nums, i + 1, key);
        if (isFound == -1 && nums[i] == key) {
            return i;
        }

        return isFound;
    }

    // Print x To the power n
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }

    // Optimized Power function - O(logn)
    public static double power2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double halfpower = fastPow(x, n / 2);
        double halfpowerSq = halfpower * halfpower;

        // n is odd
        if (n % 2 != 0) {
            halfpowerSq = x * halfpowerSq;
        }

        return halfpowerSq;
    }

    // Tilling Problem
    public static int tillingProblem(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Kaam
        // Vertical choice
        int fnm1 = tillingProblem(n - 1);

        // horizontal choice
        int fnm2 = tillingProblem(n - 2);

        int totalWays = fnm1 + fnm2;

        return totalWays;
    }

    // Remove Duplicates
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        // Base Case
        if (str.length() == idx) {
            System.out.println(newStr);
            return;
        }

        // Kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    // Friends Pairing Problem
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        // choice
        // single
        int fnm1 = friendsPairing(n - 1);

        // pair
        int fnm2 = friendsPairing(n - 2);
        int pairWays = fnm1 * fnm2;

        // totways
        int totalWays = fnm1 + pairWays;
        return totalWays;
    }

    // Binary Strings Problem
    public static void printBinStrings(int n, int lastPlace, String str) {
        // Base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        /*
         * if(lastPlace == 0){
         * // sit 0 on chair n
         * printBinStrings(n-1, 0, str.append("0"));
         * printBinStrings(n-1, 1, str.append("1"));
         * }else {
         * printBinStrings(n-1, 0, str.append("0"));
         * }
         */

        printBinStrings(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinStrings(n - 1, 0, str + "1");
        }
    }

    public static List<String> validStrings(int n) {
        ArrayList<String> res = new ArrayList<>();
        helperFn(n, 1, "", res);
        return res;
    }

    private static void helperFn(int n, int lastPlace, String str, List<String> res) {
        // Base case
        if (n == 0) {
            res.add(str);
            return;
        }

        helperFn(n - 1, 1, str + "1", res);
        if (lastPlace != 0) {
            helperFn(n - 1, 0, str + "0", res);
        }
    }

    // Find key of all occurrences and print indices
    public static void printIndices(int arr[], int i, int key) {
        if (arr.length == i) {
            return;
        }

        if (arr[i] == key) {
            System.out.print(i + " ");
        }

        printIndices(arr, i + 1, key);
    }

    // you are given a number (eg - 2019), convert it into a String of String like
    // "two zero one nine". Use a recursion function to solve this problem.
    static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void convertIntoString(int n) {
        if (n == 0) {
            return;
        }

        int lastDigit = n % 10;
        convertIntoString(n / 10);

        System.out.println(digits[lastDigit] + " ");
    }

    // Write a Program to find Length of a String
    public static int findLength(String str) {
        if (str.length() == 0) {
            return 0;
        }

        return findLength(str.substring(1)) + 1;
    }

    //
    public static int countSubstrs(String str, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        int res = countSubstrs(str, i + 1, j)
                + countSubstrs(str, i, j - 1)
                - countSubstrs(str, i + 1, j - 1);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        // int n = 6;
        // printDec(n);
        // printInc(n);
        // System.out.println(power2(2, -2));

        // System.out.println(fact(n));
        // System.out.println(printSumOfNuturalNum(n));

        // System.out.println(fibo(n));

        int nums[] = { 1, 2, 5, 6, 5, 7 };
        // System.out.println(lastOccu(nums, 0, 5));

        // System.out.println(tillingProblem(4));

        String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(3));

        // printBinStrings(3, 0, "");

        // System.out.println(validStrings(3));

        int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int key = 2;

        // printIndices(arr, 0, key);

        // convertIntoString(2019);

        // System.out.println(findLength("abdjdk"));

        String str2 = "abcab";
        int n = str2.length();
        System.out.println(countSubstrs(str2, 0, n - 1));
    }
}