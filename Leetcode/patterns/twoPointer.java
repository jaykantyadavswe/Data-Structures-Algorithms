package DSA.Leetcode.patterns;

import java.util.*;

import DSA.Leetcode.Strings.easy;

public class twoPointer {
    // 167. Two Sum II - Input Array Is Sorted
    // Brute Force - use two loops -> O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    // Better Approach - O(n), O(n);
    public static int[] twoSum2(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];

            if (map.containsKey(newTarget)) {
                return new int[] { map.get(newTarget) + 1, i + 1 };
            }

            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    // Optimal Approach - Two Pointer -> O(n), O(1);
    public static int[] twoSum3(int nums[], int target) {
        int lp = 0, rp = nums.length - 1;

        while (lp < rp) {
            int sum = nums[lp] + nums[rp];
            if (sum == target) {
                return new int[] { lp + 1, rp + 1 };
            } else if (target < sum) {
                rp--;
            } else {
                lp++;
            }
        }

        return new int[] { -1, -1 };
    }

    // 75. Sort Colors
    // Brute force -> O(n)
    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        int k = 0;
        for (int num : nums) {
            if (num == 0)
                zero++;
            else if (num == 1)
                one++;
            else
                two++;
        }

        while (zero-- > 0) {
            nums[k++] = 0;
        }
        while (one-- > 0) {
            nums[k++] = 1;
        }
        while (two-- > 0) {
            nums[k++] = 2;
        }
    }

    // Optimal Approach - Two Pointer
    public static void sortColors2(int nums[]) {
        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    // 977. Squares of a Sorted Array
    // Brute force -> O(N logn)
    public static int[] sortedSquares(int[] nums) {
        // Step1 - Traverse array and squre element
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        // Step2 - Sort Array
        Arrays.sort(nums);

        return nums;
    }

    // Optimal Approach - Two Pointer -> O(n)
    public static int[] sortedSquares2(int nums[]) {
        // Step1 - Squre element
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        // space -> O(n)
        int ans[] = new int[nums.length];
        // Step2 - Sort element
        int lp = 0, rp = nums.length - 1;
        int k = nums.length - 1;
        while (lp <= rp) {
            if (nums[lp] <= nums[rp]) {
                ans[k--] = nums[rp--];
            } else {
                ans[k--] = nums[lp++];
            }
        }

        return ans;
    }

    // 3Sum Closest - O(n^2)
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;   

            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }

                if(sum < target){
                    j++;
                }else if(sum > target){
                    k--;
                }else{
                    return sum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        /*
         * int nums[] = {2,7,11,15};
         * int target = 9;
         * int ans[] = twoSum3(nums, target);
         */

        /*
         * int nums[] = {2,0,2,1,1,0};
         * sortColors2(nums);
         */

        /* int nums[] = { -7, -3, 2, 3, 11 };
        int ans[] = sortedSquares2(nums);
        printArr(ans); */

        int nums[] = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
