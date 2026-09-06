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
    public static void main(String args[]){
        /* int nums[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSumSubArr(nums, 4));
        System.out.println(maxSumSubArr2(nums, 4)); */

        // int nums[] = {1, 1, 0, 1, 1, 1};
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnesIII(nums, 2));
    }
}