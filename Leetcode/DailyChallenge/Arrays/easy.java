

import java.util.*;

public class Easy {
    // 1464. Maximum Product of Two Elements in an Array
    public static void maxProduct(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }

        System.out.println(max);
    }

    // Using Sorting
    public static void maxProduct2(int nums[]) {
        Arrays.sort(nums);
        System.out.println((nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1));
    }

    // Approach - find two max nums
    public static void maxProduct3(int nums[]) {
        int max1 = 0, max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        System.out.println((max1 - 1) * (max2 - 1));
    }

    // 50. Pow(x, n)
    // Approach - 1
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    // Using Recursion
    public static double myPow2(double x, int n) {
        // test case
        if (n == 0)
            return 1;

        double halfPowSq = myPow2(x, n / 2) * myPow2(x, n / 2);

        if (n % 2 != 0) {
            return x * halfPowSq;
        }

        return halfPowSq;
    }

    public static double myPow3(double x, int n) {
        if (n == 0)
            return 1;

        double halfPow = myPow3(x, n / 2);
        double halfPowSq = halfPow * halfPow;

        if (n % 2 != 0) {
            return x * halfPowSq;
        }

        return halfPowSq;
    }

    public static double myPow4(double x, int n) {
        long exp = n;

        // if n is negative number
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double ans = 1;

        while (exp > 0) {
            if (exp % 2 != 0) {
                ans *= x;
            }

            x *= x;

            exp /= 2;
        }

        return ans;
    }

    // Optimal Approach
    public static double myPow5(double x, int n) {
        if (n == 0)
            return 1.0;
        if (x == 0)
            return 0.0;
        if (x == 1)
            return 1.0;
        if (x == -1 && n % 2 == 0)
            return 1.0;
        if (x == -1 && n % 2 != 0)
            return -1.0;

        long binForm = n;
        if (n < 0) {
            x = 1 / x;
            binForm = -binForm;
        }

        double ans = 1;

        while (binForm > 0) {
            if (binForm % 2 == 1) {
                ans *= x;
            }

            binForm /= 2;

            if (binForm > 0) {
                x *= x;
            }
        }

        return ans;
    }

    // 15. 3Sum
    public static List<List<Integer>> threeSum(int nums[]){
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int low = i+1;
            int high = n-1;

            while (low < high) {
                long sum = nums[i] + nums[low] + nums[high];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high])); 

                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }else if(sum < 0){
                    low++;
                }else{
                    high--;
                }
            }
        }

        return res;
    }

    // 18. 4Sum
    public static List<List<Integer>> fourSum(int nums[], int target) {
        int n = nums.length;
        Arrays.sort(nums);

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

    // 11. Container With Most Water - O(N LogN)
    public static int maxWater(int height[]){
        int maxWaters = Integer.MIN_VALUE;
        int lp = 0;
        int rp = height.length-1;

        while (lp < rp) {
            int width = rp - lp; //width

            int minHeight = Math.min(height[lp], height[rp]); // min - Height

            int totalWater = width * minHeight; // Area = Height * width;

            maxWaters = Math.max(maxWaters, totalWater);

            // Two Pointer
            if(height[lp] < height[rp]){ // if left pointer < right pointer then increase left pointer
                lp++;
            }else{ // otherwise right pointer
                rp--;
            }
        }

        return maxWaters;
    }

    // 238. Product of Array Except Self
    // Brute Force
    public static int[] productExceptSelf(int nums[]){
        int res[] = new int[nums.length];
        
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j<nums.length; j++){
                if(i == j){
                    continue;
                }
                product *= nums[j];
            }
            res[i] = product;
        }

        return res;
    }

    // Better Approach
    public static int[] productExceptSelf2(int nums[]){
        int n = nums.length;

        // Prefix
        int prefix[] = new int[nums.length];
        prefix[0] = 1;
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }


        // Suffix
        int suffix[] = new int[nums.length];
        suffix[n-1] = 1;
        for(int j=n-2; j>=0; j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for(int k = 0; k<n; k++){
            nums[k] = suffix[k] * prefix[k];
        }

        return nums;
    }

    // Space Optimization
    public static int[] productExceptSelf3(int nums[]){
        int n = nums.length;

        int ans[] = new int[n];
        ans[0] = 1;

        // Prefix
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        printArr(ans);
        int suffix = 1;
        // Suffix
        for(int i=n-2; i>=0; i--){
            suffix *= nums[i+1]; //ith suffix
            ans[i] *= suffix;
        }

        return ans;
    }

    public static void main(String[] args) {
        /*
         * int nums[] = {3,4,5,2};
         * maxProduct3(nums);
         */

        /*
         * System.out.println(myPow(2.0000, 10));
         * System.out.println(myPow2(2.0000, 10));
         * System.out.println(myPow3(2.0000, 5));
         * System.out.println(myPow4(2.0000, 10));
         */

        /* int nums[] = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        System.out.println(fourSum(nums, target)); */

        /* int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums)); */

        /* int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWater(height)); */

        int nums[] = {1, 2, 3, 4};
        int res[] = productExceptSelf3(nums);
        printArr(res);
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
