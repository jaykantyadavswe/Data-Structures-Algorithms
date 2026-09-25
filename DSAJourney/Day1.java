package DSA.DSAJourney;

import java.util.*;

/**
 * Day1
 */
public class Day1 {
    // 2965. Find Missing and Repeated Values - O(n^2)
    public static int[] findMissingAndRepeatedValues(int grid[][]) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int a = 0, b = 0;
        int expectedSum = 0, actualSum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                actualSum += grid[i][j];
                if (set.contains(grid[i][j])) {
                    a = grid[i][j];
                } 
                set.add(grid[i][j]);
            }
        }
        expectedSum = (n * n) * (n*n + 1) / 2;
        b = expectedSum + a - actualSum;

        return new int[] { a, b };
    }

    // 88. Merge Sorted Array - O(n)
    public static void merge(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = m + n -1;

        while (i >= 0 && j >= 0) {
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

    // 169. Majority Element
    // Brute Force - O(Nlog n)
    public static int majorityEle(int nums[]){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Better Approach - O(Nlogn + n)
    public static int majorityEle3(int nums[]){
        Arrays.sort(nums);
        int freq = 1; int ans = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else{
                freq = 1;
                ans = nums[i];
            }

            if(freq >= nums.length/2){
                return ans;
            }
        }
        return 0;
    }

    // Moore's voting Algorithm - O(n)
    public static int majorityEle2(int nums[]){
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

        int count = 0; 
        for(int val : nums){
            if(val == ans) count++;
        }

        if(count > nums.length/2){
            return ans;
        }

        return -1;
    }

    public static void main(String[] args) {
        /* int grid[][] = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
        int ans[] = findMissingAndRepeatedValues(grid); */

        /* int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n); */

        int nums[] = {3, 2, 3};
        System.out.println(majorityEle2(nums));
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}