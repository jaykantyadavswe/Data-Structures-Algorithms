package Leetcode.Arrays;

import java.util.*;

public class easy {
    // 2965. Find Missing and Repeated Values 
    public static int[] findMissingAndRepeatedValues(int grid[][]){
        int n = grid.length; //length of grid

        HashSet<Integer> set = new HashSet<>(); //
        int a = 0, b = 0; //store missing & Duplicate Value
        int actualSum = 0;

        // Iteration
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j]; // calculate sum of whole grid values
                if(set.contains(grid[i][j])){ // if contains then duplicates
                    a = grid[i][j];
                }

                set.add(grid[i][j]); // Add in Set values
            }
        }

        int expSum = (int) (n * n) * (n * n + 1) / 2; // calculate n size of sum
        b = expSum + a - actualSum; // find missing values

        return new int[]{a, b};
    }

    // 88. Merge Sorted Array
    public static void Merge(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (i >= 0 && 0 <= j) { 
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums2[j--];
            }else{
                nums1[k] = nums1[i--];
            }
            k--;
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // 136. Single Number - O(n)
    public static int singleNumber(int nums[]){
        int xor = nums[0];
        for(int i=1; i<nums.length; i++){
            xor ^= nums[i];
        }

        return xor;
    }

    // 121. Best Time to Buy and Sell Stock -O(n)
    public static int maxProfit(int prices[]){
        int maxProfits = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            int sellPrice = prices[i];
            if(buyPrice < sellPrice){
                int profit = sellPrice - buyPrice;
                maxProfits = Math.max(maxProfits, profit);
            }else{
                buyPrice = sellPrice;
            }
        }

        return maxProfits;
    }

    // 169. Majority Element - Moor's Voting Algorithms
    public static int majorityElement(int nums[]){
        int ans = 0;
        int freq = 0;

        for(int i=0; i<nums.length; i++){
            if(freq == 0){
                ans = nums[i];
            }

            if(ans == nums[i]){
                freq++;
            }else{
                freq--;
            }
        }

        return ans;
    }

    // 50. Pow(x, n)
    public static double myPow(double x, int n){
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

            x *= x;
            binForm /= 2;
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = 3, n = 3;
        Merge(nums1, m, nums2, n);
        printArr(nums1);

        int nums[] = {2, 2, 1};
        System.out.println(singleNumber(nums));

        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int numss[] = {3, 2, 3};
        System.out.println(majorityElement(numss));

        double x = 2.0000;
        int n1 = 10;
        System.out.println(myPow(x, n1));
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
