package DSA.Arrays;

import java.util.*;

public class ArrQs {
    // Linear Search - O(n)
    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    // find Largest & Smallest Number - O(n)
    public static int getlargeNum(int nums[]) {
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            smallest = Math.min(smallest, nums[i]);
        }

        System.out.println("smallest value is : " + smallest);

        return largest;
    }

    // Binary Search - O(log n)
    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // comparisions
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) { // right
                start = mid + 1;
            } else { // left
                end = mid - 1;
            }
        }

        return -1;
    }

    // Reverse an Array
    public static void reverseArray(int arr[]) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Pairs in an Array
    public static void pairsOfArray(int nums[]) {
        int tp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                tp++;
                System.out.print("(" + nums[i] + ", " + nums[j] + ")" + " ");
            }
            System.out.println();
        }
        System.out.println("total pairs = " + tp);
    }

    // Print SubArrays
    public static void printSubArr(int arr[]) {
        int ts = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total subArrays : " + ts);
    }

    // Max SubArray Sum - O(n^3)
    public static void maxSubArrSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    // subArrays Sum
                    currSum += arr[k];
                }
                System.out.println(currSum);
                maxSum = Math.max(currSum, maxSum);
            }
        }

        System.out.println("Maxsum : " + maxSum);
    }

    // Prefix Sum - O(n ^ 2)
    public static void prefixSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        // Prefix Arr create
        int Prefix[] = new int[arr.length];
        Prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            Prefix[i] = Prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? Prefix[end] : Prefix[end] - Prefix[start - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        System.out.println("MaxSum : " + maxSum);
    }

    // Kadan's Algorithm - O(n)
    public static void kadansAlgo(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println("Maxsum : " + maxSum);
    }

    // Trapping rain Water - O(n)
    public static void trappingRainWater(int height[]) {
        int n = height.length;
        // LeftMax
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }

        // RightMax
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        // waterLevel
        int trappedRainWater = 0;
        for (int k = 0; k < height.length; k++) {
            int waterLevel = Math.min(leftmax[k], rightMax[k]);
            trappedRainWater += waterLevel - height[k];
        }

        System.out.println("Total Trapped Water : " + trappedRainWater);
    }

    // Buy & Sell Stock
    public static void buyAndSellStock(int price[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            int sellPrice = price[i];
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }

        System.out.println("Maximum profit : " + maxProfit);
    }

    // check any value appears atleast twice in the array, and return false if every
    // element is distinct
    public static boolean checkDistinct(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // 33 - Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
                // Right half is sorted
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    // Beautiful Arrays
    public static int[] beautifulArray(int n) {
        List<Integer> result = helper(n);

        int arr[] = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = result.get(i);
        }

        return arr;

    }

    private static List<Integer> helper(int n){
        // base Case
        if(n == 1){
            List<Integer> base = new ArrayList<>();
            base.add(1);
            return base;
        }


        List<Integer> result = new ArrayList<>();

        // Odd Part
        List<Integer> odds = helper((n+1)/2);
        for(int nums : odds){
            result.add(2 * nums - 1);
        }

        // Even Part
        List<Integer> evens = helper(n / 2);
        for(int nums : evens){
            result.add(2 * nums);
        }

        return result;
    }

    public static void main(String[] args) {
        /*
         * int arr[] = {2, 4, 6, 8, 10, 12, 14, 16};
         * int index = linearSearch(arr, 10);
         * if(index == -1){
         * System.out.println("Not found");
         * }else{
         * System.out.println("index key is : " + index);
         * }
         */

        // int nums[] = {2, 4, 6, 8, 10};

        // System.out.println("largest value is : " + getlargeNum(nums));
        // System.out.println("index for key is : " + binarySearch(nums, 10));
        /*
         * reverseArray(nums);
         * for(int i=0; i<nums.length; i++){
         * System.out.print(nums[i] + " ");
         * }
         */

        // pairsOfArray(nums);
        // printSubArr(nums);
        // int nums[] = {1, -2, 6, -1, 3};
        // maxSubArrSum(nums);
        // prefixSum(nums);
        // kadansAlgo(nums);

        /*
         * int height[] = { 4, 2, 0, 6, 3, 2, 5 };
         * trappingRainWater(height);
         */

        /*
         * int price[] = {7, 1, 5, 3, 6, 4};
         * buyAndSellStock(price);
         */

        /* int nums[] = { 1, 2, 3, 4 };
        System.out.println(checkDistinct(nums)); */

        /* int nums[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 3)); */

        int nums [] = beautifulArray(5);
        printArr(nums);

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
