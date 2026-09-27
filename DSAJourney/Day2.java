package DSA.DSAJourney;

import java.util.*;

public class Day2 {
    // 136. Single Number
    public static int singleNum(int nums[]){ //O(n^2)
        int n = nums.length;

        for(int i=0; i<n; i++){
            int count = 0;

            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }

            if(count == 1){
                return nums[i];
            }
        }

        return -1;
    }


    public static int singleNum2(int nums[]){ //O(n)
        int xor = 0;
        for(int num : nums){
            xor = xor ^ num;
        }

        return xor;
    }

    public static int singleNum3(int nums[]){ //O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }

        return -1;
    }


    // Stock Buy & Sell - O(n)
    public static int maxProfit(int prices[]){
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            int sellPrice = prices[i];
            if(buyPrice < sellPrice){
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = sellPrice;
            }
        }

        return maxProfit;
    }

    // 50. Pow(x, n)
    public static double myPow(double x, int n){
        if(n == 0) return 1.0; // Pow 0
        if(x == 0) return 0.0; 
        if(x == 1) return 1.0;
        if(x == -1 && n%2 == 0) return 1.0;
        if(x == -1 && n%2 != 0) return -1.0;

        // Nigative Pow
        long binForm = n;
        if(n < 0){
            x = 1/x;
            binForm = -binForm;
        }

        double ans = 1;

        while (binForm > 0) {
            if(binForm % 2 == 1){
                ans *= x;
            }

            x *= x;
            binForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        /* int nums[] = {2, 2, 1};
        System.out.println(singleNum3(nums)); */

        /* int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); */

        System.out.println(myPow(2.000, 10));
    }
}
