package DSA.DSAJourney;

public class Day3 {
    // 53. Maximum Subarray (Kadan's Algo)
    public static int maxSubArray(int nums[]) {
        if (nums.length == 1)
            return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    // Brute Force
    public static int maxSubArray2(int nums[]) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int currSum = 0;
                for (int k = i; k < j; k++) {
                    currSum += nums[k];
                }

                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }

    // Better Approach
    public static int maxSubArray3(int nums[]) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                maxSum = Math.max(maxSum, currSum);
                currSum += nums[j];
            }

        }

        return maxSum;
    }

    // 11. Container With Most Water
    // Brute Force
    public static int maxArea(int height[]) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, width * minHeight);
            }
        }

        return maxArea;
    }

    // Optimal Approach - Two Pointer
    public static int maxArea2(int height[]){
        int lp = 0, rp = height.length-1;
        int maxArea = 0;

        while (lp < rp) {
            int width = rp - lp;
            int minHeight = Math.min(height[lp], height[rp]);
            maxArea = Math.max(maxArea, width * minHeight);

            if(height[lp] < height[rp]){
                lp++;
            }else{
                rp--;
            }
        }

        return maxArea;
    }

    // 75. Sort Colors
    // Brute Force - O(n)
    public static void sortColor(int nums[]){
        int count0 = 0, count1 = 0, count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == count0) count0++;
            if(nums[i] == count1) count1++;
            if(nums[i] == count2) count2++;
        }

        int k = 0;
        while (count0-- > 0) {
            nums[k++] = 0;
        }

        while (count1-- > 0) {
            nums[k++] = 1;
        }

        while (count2-- > 0) {
            nums[k++] = 2;
        }
    }

    // Oprimal Approch - moore's Voting Algorithm - O(n)
    public static void sortColor2(int nums[]){
        int low = 0, mid = 0, high = nums.length-1;

        while (mid <= high) {
            if(nums[mid] == 0){
                nums[mid] = nums[low];
                nums[low] = 0;
                mid++;
                low++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        /* int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray3(nums)); */

        /* int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height)); */

        int nums[] = {2,0,2,1,1,0};
        sortColor2(nums);
        printArr(nums);
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
