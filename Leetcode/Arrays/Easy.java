package DSA.Leetcode.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.lang.model.util.Elements;

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

    // 1752. Check if Array Is Sorted and Rotated
    // brute force
    public static boolean isSorted(int nums[]){
        int sortedNums[] = nums.clone();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            boolean isMath = true;
            for(int idx=0; idx<nums.length; idx++){
                if(nums[(i+idx)% nums.length] != sortedNums[idx]){
                    isMath = false;
                    break;
                }
            }

            if(isMath){
                return true;
            }
        }

        return false;
    }

    // Optimal Approach
    public static boolean isSorted2(int arr[]) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }

    // Remove duplicates
    public static void removeDuplicate(int nums[]){
        int expextedNum[] = new int[nums.length];
        int k = 1, p = 0;
        
        int i=0, j=i+1;

        while (i < nums.length && j < nums.length) {
            if(nums[i] == nums[j]){
                j++;
            }else{
                k++;
                expextedNum[p++] = nums[i];
                i = j;
                j++;
            }
        }

        System.out.println(k);
    }

    // Left Rotate Array by One
    public static void rotateByOne(int nums[]){
        int n = nums.length;
        int first = nums[0];
        for(int i=0; i<n-1; i++){
            nums[i] = nums[i+1];
        }

        nums[n-1] = first;
    }

    // 283. Move Zeroes
    // Using Space - Brute Force
    public static void moveZeroe(int nums[]){
        int n = nums.length;
        int temp[] = new int[n];
        int lp = 0;
        for(int rp=0; rp<n; rp++){
            if(nums[rp] != 0){
                temp[lp++] = nums[rp];
            }
        }

        while (lp < n) {
            nums[lp++] = 0;
        }

        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }

    // Better Approach
    public static void moveZeroes(int nums[]){
        int n = nums.length;
        if(n == 1) return;
        
        int lp = 0;
        for(int rp=0; rp<n; rp++){
            if(nums[rp] != 0){
                int temp = nums[rp];
                nums[rp] = nums[lp];
                nums[lp] = temp;
                lp++;
            }
        } 
    }
    
    // Optimal Approach
    public static void moveZeroes2(int nums[]){
        int n = nums.length;
        int lp = 0;
        for(int rp=0; rp<n; rp++){
            if(nums[rp] != 0){
                nums[lp++] = nums[rp];
            }
        }

        while (lp < n) {
            nums[lp++] = 0;
        }
    }

    // Union of two sorted arrays
    // Brute force
    public static void findUnion(int nums1[], int n, int nums2[], int m) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // sorted order

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            list.add(key);
        }

        System.out.println(list);
    }

    // Better Approach
    public static List<Integer> findUnion2(int nums1[], int n, int nums2[], int m) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            set.add(num);
        }

        for (Integer key : set) {
            System.out.println(key);
        }

        return new ArrayList<>(set);
    }

    // Two Pointer
    public static void findUnion3(int nums1[], int n, int nums2[], int m) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= n - 1 && j <= m - 1) {
            if (nums1[i] < nums2[j]) {
                if (!list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (!list.contains(nums2[j])) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while (i <= n - 1) {
            if (!list.contains(nums1[i])) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j <= m - 1) {
            if (!list.contains(nums2[j])) {
                list.add(nums2[j]);
            }
            j++;
        }

        System.out.println(list);
    }

    // -   2956.Find Common Elements Between Two Arrays
    public static void findIntersectionValues(int nums1[], int nums2[]) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums1) {
            list1.add(num);
        }

        for (int num : nums2) {
            list2.add(num);
        }

        int countNum1 = 0;
        int countNum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (list2.contains(nums1[i])) {
                countNum1++;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (list1.contains(nums2[i])) {
                countNum2++;
            }
        }

        System.out.println(countNum1 + ", " + countNum2);

    }

    // Using freq
    public static void findIntersectionValues2(int nums1[], int nums2[]) {
        int n = 0; // in nums1 largest number

        for (int num : nums1) {
            if (num > n) {
                n = num;
            }
        }

        // freq store
        int freq1[] = new int[n + 1];
        int freq2[] = new int[n + 1];

        for (int num : nums1) {
            freq1[num]++;
        }

        for (int num : nums2) {
            if (num <= n) {
                freq2[num]++;
            }
        }

        int p = 0, q = 0;
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                p += freq1[i];
                q += freq2[i];
            }
        }

        System.out.println(p + ", " + q);
    }


    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        moveZeroe(nums);
        printArr(nums);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
