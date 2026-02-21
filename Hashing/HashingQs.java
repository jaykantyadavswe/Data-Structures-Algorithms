package DSA.Hashing;

import java.util.*;

public class HashingQs {
    // Majority Element
    public static void majorityEle(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /*
             * if(map.containsKey(nums[i])){
             * map.put(nums[i], map.get(nums[i])+1);
             * }else{
             * map.put(nums[i], 1);
             * }
             */

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            if (map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }

    // Valid Anagram
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty()? true : false;
    }

    // Count Distinct Elements
    public static int distinctEle(int nums[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        return set.size();
    }

    // Union & Intersetion of 2 Arrays
    public static void Union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        // Union
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        System.out.println("Union = " + set.size());

        // Intersection
        set.clear();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection = " + count);

    }

    // Find Itinerary for tickets - O(n)
    public static String getStart(HashMap<String, String> tickets){ // to -> from
        // from -> to
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }


        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }

        return null;
    }

    // Largest subarray with 0 Sum
    public static void largestSubArrZeroSum(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("Largest subArray with sum as 0 => " + len);
    }

    // SubArray Sum equal to k
    public static void subArraySumK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int ans = 0;
        int sum = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // majorityEle(nums);
        // System.out.println(isAnagram("race", "carde"));
        // System.out.println(distinctEle(nums));

        /* int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        Union(arr1, arr2); */

        /* HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println(); */

        int arr[] = {10, 2, -2, -20, 10};
        // largestSubArrZeroSum(arr);
        subArraySumK(arr, -10);
    }
}
