package DSA.Leetcode.Recursion;

import java.util.*;

public class Medium {
    // 39. Combination Sum
    public static List<List<Integer>> combinationSum(int arr[], int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        getAllCombination(arr, 0, tar, ans, combin, s);

        return ans;
    }

    private static void getAllCombination(int arr[], int idx, int tar, List<List<Integer>> ans, List<Integer> combin,
            Set<List<Integer>> s) {
        if (idx == arr.length || tar < 0) {
            return;
        }

        if (tar == 0) {
            List<Integer> temp = new ArrayList<>(combin); // deep copy
            if (!s.contains(temp)) {
                ans.add(temp);
                s.add(temp);
            }
            return;
        }

        // include current element
        combin.add(arr[idx]);

        // take once -> move to next idx
        getAllCombination(arr, idx + 1, tar - arr[idx], ans, combin, s);

        // take multiple -> stay at same idx
        getAllCombination(arr, idx, tar - arr[idx], ans, combin, s);

        // backtrack
        combin.remove(combin.size() - 1);

        // Exclude current element
        getAllCombination(arr, idx + 1, tar, ans, combin, s);
    }

    // Using Sorting
    public static List<List<Integer>> combinationSum2(int arr[], int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        // Sorting

        getAllCombination2(arr, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private static void getAllCombination2(int arr[], int idx, int tar, List<Integer> combin, List<List<Integer>> ans){
        
        if(tar == 0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        for(int i=idx; i<arr.length; i++){

            // skip duplicate
            if(i > idx && arr[i] == arr[i-1]) continue;

            if(arr[i] > tar) break;

            combin.add(arr[i]);

            getAllCombination2(arr, i, tar - arr[i], combin, ans);

            combin.remove(combin.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr); // 🔥 important

        backtrack(arr, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] arr, int idx, int target,
                                  List<Integer> combin,
                                  List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(combin));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            // 🔥 skip duplicates at same level
            if (i > idx && arr[i] == arr[i - 1]) continue;

            // optimization
            if (arr[i] > target) break;

            combin.add(arr[i]);

            // stay at i → reuse allowed
            backtrack(arr, i, target - arr[i], combin, ans);

            // backtrack
            combin.remove(combin.size() - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2,3,6,7 };
        int tar = 7;
        System.out.println(combinationSum2(arr, tar));
    }
}
