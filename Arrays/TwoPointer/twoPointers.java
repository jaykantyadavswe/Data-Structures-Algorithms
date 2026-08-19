package Arrays.TwoPointer;

import java.util.*;

public class twoPointers {
    //  Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int nums[], int target){
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if(sum == target){
                return new int[]{left+1, right+1};
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    // 3 Sum
    public static List<List<Integer>> threeSum(int nums[]){
        // Sorting
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j=i+1; 
            int k = nums.length-1;

            while (j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }

                    j++; k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        /* int nums[] = {2,7,11,15};
        int target = 9;
        int ans[] = twoSum(nums, target);
        printArr(ans); */

        int nums[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
