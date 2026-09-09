import java.util.*;

class slidingWindow {
    // Max sum subArray of size k
    // Brute force
    public static int maxSumSubArr(int nums[], int k){
        int maxSum = 0;
        int n = nums.length;

        for(int i=0; i<n-k; i++){ //loop traverse n-k times
            int sum = 0;
            for(int j=i; j<k+i; j++){ // traverse i to k+i times
                sum += nums[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return  maxSum;
    }

    // Optimal - O(n)
    public static int maxSumSubArr2(int nums[], int k){
        int windowSum = 0;

        for(int i=0; i<k; i++){
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for(int j=k; j<nums.length; j++){
            windowSum += nums[j];
            windowSum -= nums[j-k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // 485. Max Consecutive Ones - I
    public static int maxConsecutiveOne(int nums[]){
        int maxConsecutive = 1;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }else{
                maxConsecutive = Math.max(maxConsecutive, count);
                count = 0;
            }
        }

        return Math.max(maxConsecutive, count);
    }

    // 1004. Max Consecutive Ones III
    // Brute Force
    public static int longestOnes(int nums[], int k){
        int maxConsecutive = 0;

        for(int i=0; i<nums.length; i++){
            int zeroCount = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] == 0){
                    zeroCount++;
                }

                if(zeroCount > k){
                    break;
                }

                maxConsecutive = Math.max(maxConsecutive, j-i+1);
            }
        }

        return maxConsecutive;
    }

    // Optimal approach
    public static int longestOnesII(int nums[], int k){
        int n = nums.length;
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for(int right=0; right<n; right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while (zeroCount > k) {
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int longestOnesIII(int nums[], int k){
        int left = 0;
        int zeroCount = 0;

        for(int right = 0; right<nums.length; right++){
            if (nums[right] == 0) {
                zeroCount++;
            }

            if(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
        }

        return nums.length - left;
    }

    // 713. Subarray Product Less Than K
    public static int numSubarrayProductLessThanK(int nums[], int k){
        int countSubArrProduct = 0;

        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=i; j>=0; j--){
                product *= nums[j];
                if(product < k) {countSubArrProduct++;}
                else{
                    break;
                }
            }
        }

        return countSubArrProduct;
    }

    // Optimal Appraoch
    public static int numSubarrayProductLessThanK2(int nums[], int k){
        if(k <= 1) return 0;

        int count = 0;
        int product = 1;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    // 209. Minimum Size Subarray Sum
    public static int minSubArrayLen(int nums[], int tar){
        int length = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum >= tar){
                    length = Math.min(length, j - i + 1);
                    break;
                }
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }

    // Optimal Approach
    public static int minSubArrayLen2(int nums[], int tar){
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        
        for(int right = 0; right<nums.length; right++){
            sum += nums[right];

            while (sum >= tar) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

        }

        return minLen;
    }

    // Fruits into basket
    // Brute force - O(n^2)
    public static int totalFruit(int [] fruits){
        int ans = 0;
        for(int l = 0; l < fruits.length; l++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int r = l; r<fruits.length; r++){
                map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
                if(map.size() > 2){
                    break;
                }
                count++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    // Optimal - Sliding window
    public static int totalFruit2(int [] fruits){
        int ans = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right<fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
    public static void main(String args[]){
        /* int nums[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSumSubArr(nums, 4));
        System.out.println(maxSumSubArr2(nums, 4)); */

        // int nums[] = {1, 1, 0, 1, 1, 1};
        /* int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnesIII(nums, 2)); */

        /* int nums[] = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK2(nums, k)); */

        /* int nums[] = {1, 4, 4};
        int tar = 4;
        System.out.println(minSubArrayLen2(nums, tar)); */

        int fruits[] = {0, 1, 2, 2};
        System.out.println(totalFruit2(fruits));
    }
}