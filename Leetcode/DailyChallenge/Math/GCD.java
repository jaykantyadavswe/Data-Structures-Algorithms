package DSA.Leetcode.DailyChallenge.Math;

import java.util.*;

public class GCD {
    // 3867. Sum of GCD of Formed Pairs
    public static long gcdSum(int[] nums) {
        int n = nums.length;
        int max = -1;
        // Construct an array prefixGcd where for each index i:
        // Let mxi = max(nums[0], nums[1], ..., nums[i])
        int prefixGcd[] = new int[n];

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd); //Sort prefixGcd in non-decreasing order.
        long ans = 0;

        for(int i=0, j=n-1; i<j; i++, j--){
            ans += gcd(prefixGcd[i], prefixGcd[j]);
            // Form pairs by taking the smallest unpaired element and the largest unpaired element.
        }

        // Return an integer denoting the sum of the GCD values of all formed pairs.
        return ans;
    }

    // The term gcd(a, b) denotes the greatest common divisor of a and b.
    private static int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        int nums[] = {3,6,2,8};
        System.out.println(gcdSum(nums));
    }
}
