package Arrays.TwoPointer;

import java.util.*;

public class twoPointers {
    // Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { -1, -1 };
    }

    // 3 Sum
    public static List<List<Integer>> threeSum(int nums[]) {
        // Sorting
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

    // Sort colors - O(n)
    public static void sortColors(int nums[]) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }

    // 283. Move Zeroes - O(n)
    public static void moveZeroes(int nums[]){
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                swap(nums, right, left);
                left++;
            }
        }
    }

    // 11. Container With Most Water
    public static int maxArea(int height[]){
        int left = 0, right = height.length-1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    private static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        /*
         * int nums[] = {2,7,11,15};
         * int target = 9;
         * int ans[] = twoSum(nums, target);
         * printArr(ans);
         */

        /*
         * int nums[] = {-1, 0, 1, 2, -1, -4};
         * System.out.println(threeSum(nums));
         */

        /* int nums[] = { 2, 0, 1 };
        sortColors(nums);
        printArr(nums); */

        /* int nums[] = {0,1,0,3,12, 0};
        moveZeroes(nums);
        printArr(nums); */

        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
