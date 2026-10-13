package Leetcode.DailyChallenge.Arrays;

import java.util.*;

public class easy {
    // 1464. Maximum Product of Two Elements in an Array
    public static void maxProduct(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                max = Math.max(max, (nums[i]-1) * (nums[j]-1));
            }
        }

        System.out.println(max);
    }

    // Using Sorting
    public static void maxProduct2(int nums[]){
        Arrays.sort(nums);
        System.out.println((nums[nums.length-1]-1) * (nums[nums.length-2]-1));
    }

    // Approach - find two max nums
    public static void maxProduct3(int nums[]){
        int max1 = 0, max2 = 0;

        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max2 = num;
            }
        }

        System.out.println((max1 - 1) * (max2 - 1));
    }

    // 50. Pow(x, n)
    // Approach - 1
    public static double myPow(double x, int n){
        return Math.pow(x, n);
    }

    // Using Recursion
    public static double myPow2(double x, int n){
        // test case
        if(n == 0) return 1;

        double halfPowSq = myPow2(x, n/2) * myPow2(x, n/2);

        if(n % 2 != 0){
            return x * halfPowSq;
        }

        return halfPowSq;
    }

    public static double myPow3(double x, int n){
        if(n == 0) return 1;

        double halfPow = myPow3(x, n/2);
        double halfPowSq = halfPow * halfPow;

        if(n % 2 != 0){
            return x * halfPowSq;
        }

        return halfPowSq;
    }

    public static double myPow4(double x, int n){
        long exp = n;

        // if n is negative number
        if(exp < 0){
            x = 1 / x;
            exp = -exp;
        }

        double ans = 1;

        while (exp > 0) {
            if(exp%2 != 0){
                ans *= x;
            }

            x *= x;

            exp /= 2;
        }

        return ans;
    }

    // Optimal Approach
    public static double myPow5(double x, int n){
        if(n == 0) return 1.0;
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        if(x == -1 && n % 2 == 0) return 1.0; 
        if(x == -1 && n % 2 != 0) return -1.0;

        long binForm = n;
        if(n < 0){
            x = 1/x;
            binForm = -binForm;
        }

        double ans = 1;

        while (binForm > 0) {
            if(binForm % 2 == 1){
                ans *= x;
            }

            binForm /= 2;

            if(binForm > 0){
                x *= x;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        /* int nums[] = {3,4,5,2};
        maxProduct3(nums); */

        System.out.println(myPow(2.0000, 10));
        System.out.println(myPow2(2.0000, 10));
        System.out.println(myPow3(2.0000, 5));
        System.out.println(myPow4(2.0000, 10));
    }
}
