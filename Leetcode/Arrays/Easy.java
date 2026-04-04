package DSA.Leetcode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Easy {
    // 2965. Find Missing and Repeated Values
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int freq[] = new int[n * n + 1];
        int ans[] = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                freq[grid[i][j]]++;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (freq[i] > 1) {
                ans[0] = i;
            }

            if (freq[i] == 0) {
                ans[1] = i;
            }

        }
        return ans;
    }

    // Using HashSet & Math - O(n^2)
    public static int[] findMissingAndRepeatedValues2(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        int actualSum = 0, expectedSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                if (set.contains(grid[i][j])) {
                    ans[0] = grid[i][j];
                }

                set.add(grid[i][j]);
            }
        }

        expectedSum = (n * n) * (n * n + 1) / 2;
        // missing = expectedSum - actualSum + duplicate
        ans[1] = expectedSum - actualSum + ans[0];
        printArr(ans);
        return ans;
    }

    // 88. Merge Sorted Array - O(m + n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }

        for (int c = 0; c < ans.length; c++) {
            nums1[c] = ans[c];
        }
    }

    // Without using Extra Space - O(N+M)
    public static void merge2(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // 136. Single Number
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer v : map.keySet()) {
            if (map.get(v) == 1) {
                return v;
            }
        }

        return -1;
    }

    // Using XOR Operator - O(n)
    public static int singleNumber2(int nums[]) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }

    // 121. Best Time to Buy and Sell Stock
    public static int buyAndSellStock(int prices[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int sellPrice = prices[i];
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }

    // 118. Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    list.add(1);
                } else {
                    int sum = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    list.add(sum);
                }

            }
            ans.add(list);
        }
        return ans;
    }

    // 169. Majority Element -O(n^2)
    public static int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Using HashMap -> O(N log n) + O(n) sc-> O(n)
    public static int majorityElement2(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer k : map.keySet()) {
            if (map.get(k) > nums.length / 2) {
                return k;
            }
        }

        return -1;
    }

    // Moore's Voting Algorithm - O(n)
    public static int majorityElement3(int nums[]) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
                count++;
            } else if (ans == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count > nums.length / 2) {
                return ans;
            }
        }

        return ans;
    }

    // Two Sum - O(n)
    // Brute Force
    public static int[] twoSum(int nums[], int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Optimal Approach
    public static int[] twoSum2(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int needNum = target - nums[i];

            if(map.containsKey(needNum)){
                return new int[]{map.get(needNum), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    // 

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        int ans[] = twoSum(nums, target);
        printArr(ans);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
