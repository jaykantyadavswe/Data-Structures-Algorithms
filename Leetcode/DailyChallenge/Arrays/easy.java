package Leetcode.DailyChallenge.Arrays;

import java.util.*;

public class easy {
    // 1464. Maximum Product of Two Elements in an Array
    public static void maxProduct(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                max = Math.max(max, (nums[i]-1) * (nums[j]-1));
            }
        }

        System.out.println(max);
    }

    // Using Sorting
    public static void maxProduct2(int nums[]){
        Arrays.sort(nums);
        System.out.println((nums[nums.length-1]-1) * (nums[nums.length-2]-1));
    }

    // Approach - find two max nums
    public static void maxProduct3(int nums[]){
        int max1 = 0, max2 = 0;

        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max2 = num;
            }
        }

        System.out.println((max1 - 1) * (max2 - 1));
    }

    public static void main(String[] args) {
        int nums[] = {3,4,5,2};
        maxProduct3(nums);
    }
}
