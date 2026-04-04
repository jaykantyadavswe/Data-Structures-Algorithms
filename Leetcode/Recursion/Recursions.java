package DSA.Leetcode.Recursion;

import java.util.*;

public class Recursions {
    // 50. Pow(x, n)
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }

    // Optimized Power function
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

    // 273. Integer to English Words
    static String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six",
                            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                            "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                            "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = {"", "", "Twenty", "Thirty", "Forty",
                     "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    static String[] thousands = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int nums) {
        if (nums == 0)
            return "zero";

        int i = 0;
        String words = "";

        while (nums > 0) {
            if (nums % 1000 != 0) {
                words = helper(nums % 1000) + thousands[i] + " " + words;
            }

            nums = nums / 1000;
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return belowTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return belowTwenty[num / 100] + " hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(5976543));
    }
}
