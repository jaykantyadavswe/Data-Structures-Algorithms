package Leetcode.Arrays;
import java.util.*;;
public class medium {
    // 53. Maximum Subarray
    public static int maxSubArray(int nums[]){
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            currSum += nums[i];

            max = Math.max(max, currSum);

            if(currSum < 0){
                currSum = 0;
            }
        }

        return max;
    }

    // 75. Sort Colors
    // Brute force
    public static void sortColors(int nums[]){
        int count0 = 0, count1 = 0, count2 = 0;
        int k = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) count0++;
            if(nums[i] == 1) count1++;
            if(nums[i] == 2) count2++;
        }

        while (count0-- > 0) nums[k++] = 0;
        while(count1-- > 0) nums[k++] = 1;
        while(count2-- > 0) nums[k++] = 2;
    }

    // Optimal Approach
    public static void sortColors2(int nums[]){
        int low = 0, mid = 0, high = nums.length-1;

        while (mid <= high) {
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    // 18. 4Sum
    public static List<List<Integer>> fourSum(int nums[], int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1;
                int high = n-1;

                while (low < high) {
                    long sum = (long) nums[i] + nums[j] + nums[low] + nums[high];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(sum < target){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        // int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubArray(nums));

        /* int nums[] = {2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        printArr(nums); */

        int nums[] = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));

    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }

}