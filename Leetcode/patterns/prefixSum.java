import java.util.HashMap;

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

    public static void main(String[] args) {
        /*
         * int nums[] = {1,2,3};
         * int k = 3;
         * System.out.println(subArraySum(nums, k));
         */

        int nums[] = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK2(nums, k));
    }
}
