package DSA.ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrListQs {
    // Reverse ArrayList
    public static void reverseArrList(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    // Find Maximum in an ArrayList
    public static void findMaxNum(ArrayList<Integer> list) {
        int MaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            MaxNum = Math.max(MaxNum, list.get(i));
        }

        System.out.println("Maximum Number : " + MaxNum);
    }

    // Swap 2 Numbers
    public static void swapTwoNum(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    // Container with Most Water
    // Brute Force - O(n^2)
    public static void mostWater(int height[]) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int width = j - i;
                int currWater = minHeight * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        System.out.println("Most Water : " + maxWater);
    }

    // Two Pointer Approach - O(n)
    public static void mostWater2(int height[]) {
        int lp = 0, rp = height.length - 1;
        int maxWater = 0;
        while (lp < rp) {
            // Calculate water area
            int minHeight = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int currWater = minHeight * width;
            maxWater = Math.max(maxWater, currWater);
            // Update Ptr
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        System.out.println("Most Water : " + maxWater);
    }

    // Find if any pair in a Sorted ArrayList has a target sum
    // Brute Force - O(n^2)
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    System.out.print("(" + i + ", " + j + ")" + " ");
                    return true;
                }
            }
        }

        return false;
    }

    // Two Pointer Approach
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp != rp) {
            // case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    // Pair Sum - 2 - O(n)
    public static boolean rotatedPairSum2(ArrayList<Integer> list, int target) {
        int n = list.size();
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) { // Breaking Point
                bp = i;
                break;
            }
        }

        int lp = bp + 1; // smallest
        int rp = bp; // largest

        while (lp != rp) {
            // Case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else { // case 3
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    // Two sum - II - Input Array Is Sorted
    public static int[] twoSum2(int nums[], int target) {
        int lp = 0, rp = nums.length - 1;
        while (lp != rp) {
            if (nums[lp] + nums[rp] == target) {
                return new int[] { lp + 1, rp + 1 };
            }

            if (nums[lp] + nums[rp] < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return new int[] { 0, 0 };
    }

    // contain duplicate triplets
    // Brute Force - O(n^3)
    public static ArrayList<ArrayList<Integer>> triplets(int nums[]) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!mainList.contains(list)) {
                            mainList.add(list);
                        }
                    }
                }
            }
        }

        return mainList;
    }

    // Two Pointer - O(n^2)
    public static ArrayList<ArrayList<Integer>> triplets2(int nums[]) {
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate i values
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    mainList.add(list);

                    // skip duplicates for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // skip duplicates for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++; // need bigger sum
                } else {
                    k--; // need smaller sum
                }
            }
        }
        return mainList;
    }

    // Monotonic Array - O(n)
    public static boolean monotonic(int nums[]) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }

            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    // Find All Lonely Numbers in the Array
    public static List<Integer> findLonely(int nums[]) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            boolean isLonely = true;

            // Check previous
            if (i > 0) {
                if (nums[i] == nums[i - 1] || nums[i] == nums[i - 1] + 1) {
                    isLonely = false;
                }
            }

            // Check next
            if (i < n - 1) {
                if (nums[i] == nums[i + 1] || nums[i] == nums[i + 1] - 1) {
                    isLonely = false;
                }
            }

            if (isLonely) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    // Most Frequent Number Following Key In an Array
    public static int mostFrequent(int[] nums, int key) {
        int result[] = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                result[nums[i + 1] - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;
    }

    // Using ArrayList
    public static int mostFrequent2(int nums[], int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                ans = e.getKey();
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        // reverseArrList(list);
        // findMaxNum(list);
        /*
         * int idx1 = 1, idx2 = 3;
         * System.out.println(list);
         * swapTwoNum(list, idx1, idx2);
         * System.out.println(list);
         */

        // System.out.println(list);
        // Collections.sort(list); // ascending
        // System.out.println(list);

        // Descending
        // Collections.sort(list, Collections.reverseOrder()); // Comprator
        // System.out.println(list);

        // Multi-Dimentional ArrayList
        /*
         * ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
         * ArrayList<Integer> lists = new ArrayList<>();
         * lists.add(1);
         * lists.add(2);
         * mainList.add(lists);
         * 
         * ArrayList<Integer> lists2 = new ArrayList<>();
         * lists2.add(3);
         * lists2.add(4);
         * mainList.add(lists2);
         * 
         * for(int i=0; i<mainList.size(); i++){
         * ArrayList<Integer> currList = mainList.get(i);
         * for(int j=0; j<currList.size(); j++){
         * System.out.print(currList.get(j) + " ");
         * }
         * System.out.println();
         * }
         * 
         * System.out.println(mainList);
         */

        // int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // mostWater(height);
        // mostWater2(height);

        /*
         * int target = 6;
         * int Numbers[] = { 2, 3, 4 };
         */

        // System.out.println(pairSum(list, target));
        // System.out.println(pairSum2(list, target));
        // System.out.println(rotatedPairSum2(list, target));
        /*
         * int ans[] = twoSum2(Numbers, target);
         * printArr(ans);
         */

        /*
         * int nums[] = { -1, 0, 1, 2, -1, -4 };
         * System.out.println(triplets2(nums));
         */

        // int nums[] = { 1, 2, 2, 3 };
        // int nums[] = {1, 3, 2};
        // System.out.println(monotonic(nums));

        /*
         * int nums[] = { 10, 6, 5, 8 };
         * System.out.println(findLonely(nums));
         */

        int nums[] = { 1, 100, 200, 1, 100 };
        System.out.println(mostFrequent2(nums, 1));

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
