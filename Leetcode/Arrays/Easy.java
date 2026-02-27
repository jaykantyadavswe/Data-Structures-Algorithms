package DSA.Leetcode.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class Easy {
    // 2965. Find Missing and Repeated Values
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int freq[] = new int[n * n + 1];
        int ans[] = new int[2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                freq[grid[i][j]]++;
            }
        }

        for(int i=1; i<=n*n; i++){
            if(freq[i] > 1 ){
                ans[0] = i;
            }

            if(freq[i] == 0){
                ans[1] = i;
            }

        }
        return ans;
    }

    // Using HashSet & Math - O(n^2)
    public static int[] findMissingAndRepeatedValues2(int [][]grid){
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        int actualSum = 0, expectedSum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }
                
                set.add(grid[i][j]);
            }
        }

        expectedSum = (n*n) * (n*n + 1) / 2;
        // missing = expectedSum - actualSum + duplicate
        ans[1] = expectedSum - actualSum + ans[0];
        printArr(ans);
        return ans;
    }

    // 88. Merge Sorted Array - O(m + n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[m+n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if(nums1[i] < nums2[j]){
                ans[k++] = nums1[i++];
            }else{
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }


        for(int c = 0; c < ans.length; c++){
            nums1[c] = ans[c];
        }
    }

    // Without using Extra Space - O(N+M)
    public static void merge2(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = n+m-1;

        while (i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
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
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer v : map.keySet()){
            if(map.get(v) == 1){
                return v;
            }
        }

        return -1;
    }

    // Using XOR Operator - O(n)
    public static int singleNumber2(int nums[]){
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }

    // 121. Best Time to Buy and Sell Stock
    public static int buyAndSellStock(int prices[]){
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            int sellPrice = prices[i];
            if(buyPrice < sellPrice){
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int grid[][] = {{9,1,7},{8,9,2},{3,4,6}};
        // findMissingAndRepeatedValues2(grid);.

        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int n = 3, m = 3;
        // merge2(nums1, m, nums2, n);
        // printArr(nums1);

        int nums[] = {2, 2, 1};
        // System.out.println(singleNumber2(nums));

        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStock(prices));
    }


    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
