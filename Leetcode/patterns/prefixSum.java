import java.util.*;

public class prefixSum {
    // 560. Subarray Sum Equals K
    public static int subArraySum(int nums[], int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            if (freq.containsKey(prefixSum - k)) {
                count += freq.get(prefixSum - k);
            }

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // 974. Subarray Sums Divisible by K
    // Brute Force
    public static int subarraysDivByK(int nums[], int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    // Optimal Approach - O(n)
    public static int subarraysDivByK2(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;

            if(rem < k) rem += k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    //1314. Matrix Block Sum
    public static int[][] matrixBlockSum(int mat[][], int k){
        int m = mat.length;
        int n = mat[0].length;

        int ans[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = 0;

                for(int r = i - k; r <= i + k; r++){
                    for(int c = j - k; c <= j + k; c++){

                        if(r >= 0 && r < m && c >= 0 && c < n){
                            sum += mat[r][c];
                        }
                    }
                }

                ans[i][j] = sum;
            }
        }

        return ans;
    }

    // Optimal Approach
    public static int[][] matrixBlockSum2(int [][] mat, int k){
        int m = mat.length;
        int n = mat[0].length;

        int [][] prefix = new int[m + 1][n + 1];

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        int [][] ans = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                r1++;
                c1++;
                r2++;
                c2++;

                ans[i][j] = prefix[r2][c2]
                          - prefix[r1 - 1][c2]
                          - prefix[r2][c1-1]
                          + prefix[r1 - 1][c1 - 1];
            }
        }

        return ans;
    }

    // 238. Product of Array Except Self - O(n^2)
    public static int[] productExceptSelf(int nums[]){
        int res[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int prod = 1;
            for(int j=0; j<nums.length; j++){
                if(i == j){
                    continue;
                }else{
                    prod *= nums[j];
                }
            }

            res[i] = prod;
        }

        return res;
    }

    // Optimal Approach
    public static int[] productExceptSelf2(int nums[]){
        int n = nums.length;

        int res[] = new int[n];
        res[0] = 1;
        // Left
        for(int i=1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        // Right
        int rightProd = 1;
        for(int r=n-1; r>=0; r--){
            res[r] = res[r] * rightProd;
            rightProd *= nums[r];
        }

        return res;
    }
    

    // 523. Continuous Subarray Sum
    // Brute force
    public static boolean checkSubarraySum(int nums[], int k){
        for(int i=0; i<nums.length; i++){
            int sum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                sum += nums[i];

                if(sum % k == 0){
                    return true;
                }
            }
        }

        return false;
    }
    // Optimal
    public static boolean checkSubarraySum2(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];

            int rem = prefixSum % k;
            System.out.println(rem);

            if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2){
                    return true;
                }
            }else{
                map.put(rem, i);
            }
        }

        return false;
    }

    // 724. Find Pivot Index
    // Brute Force
    public static int pivotIndex(int nums[]){
        int n = nums.length;
        for(int i=0; i<n; i++){

            int leftSum = 0;
            for(int j=0; j<i; j++){
                leftSum += nums[j];
            }

            System.out.println("LeftSum : " + leftSum);

            int rightSum = 0;
            for(int j=i+1; j<n; j++){
                rightSum += nums[j];
            }

            System.out.println("RightSum: " + rightSum);

            if(leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }

    // Optimal Approach
    public static int pivotIndex2(int nums[]){
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        System.out.println("Total Sum : " + totalSum);
        int leftSum = 0;
        for(int i=0; i<n; i++){
            int rightSum = totalSum - leftSum - nums[i];

            System.out.println("RightSum : " + rightSum);
            System.out.println("Leftsum : " + leftSum);

            if(leftSum == rightSum){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        /*
         * int nums[] = {1,2,3};
         * int k = 3;
         * System.out.println(subArraySum(nums, k));
         */

        /* int nums[] = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK2(nums, k)); */

        /* int nums[] = {1,2,3,4};
        int ans[] = productExceptSelf2(nums);
        printArr(ans); */

        /* int nums[] = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum2(nums, k)); */

        int nums[] = {1,7,3,6,5,6};
        System.out.println(pivotIndex2(nums));
    }

    public static void printArr(int nums[]){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
