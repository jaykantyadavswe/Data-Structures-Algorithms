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
    public static void main(String args[]){
        int nums[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSumSubArr(nums, 4));
        System.out.println(maxSumSubArr2(nums, 4));
    }
}