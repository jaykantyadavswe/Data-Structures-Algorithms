package DSA.Leetcode.Arrays;

import java.util.*;

import DSA.Arrays.Arr;

public class Medium {
    // 75. Sort Colors
    public static void sortColors(int[] nums) {
        int zeroNum = 0, oneNum = 0, twoNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else if (nums[i] == 1) {
                oneNum++;
            } else {
                twoNum++;
            }

        }
        int i = 0;
        while (zeroNum-- > 0) {
            nums[i++] = 0;
        }

        while (oneNum-- > 0) {
            nums[i++] = 1;
        }

        while (twoNum-- > 0) {
            nums[i++] = 2;
        }
    }

    // Optimal Approach With Datch National Flag Algo
    public static void sortColors2(int nums[]) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 15. 3Sum
    // Brute Force - O(n^3)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    List<Integer> list = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!lists.contains(list)) {
                            lists.add(list);
                        }
                    }
                }
            }
        }

        return lists;
    }

    // Better Approach - Using HashSet
    public static List<List<Integer>> threeSum2(int nums[]) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);

                    Collections.sort(triplet);

                    if (!lists.contains(triplet)) {
                        lists.add(triplet);
                    }
                }

                set.add(nums[j]);
            }
        }

        return lists;
    }

    // Optimal Solution - O(nLogn + n^2)
    public static List<List<Integer>> threeSum3(int nums[]) {
        // Sorting
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(triplet);

                    // Skip Duplicates
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }

    // 18. 4Sum
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            lists.add(res);
                        }
                    }
                }
            }
        }

        return lists;
    }

    // Optimal Approach
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        lists.add(res);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return lists;
    }

    // Optimal Approach - Three loops → O(n³), Hash lookup → O(1)
    public static List<List<Integer>> fourSum3(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long newTarget = (long) target;
                    newTarget -= nums[i];
                    newTarget -= nums[j];
                    newTarget -= nums[k];

                    if (set.contains(newTarget)) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) newTarget);
                        Collections.sort(list);
                        res.add(list);
                    }

                    set.add((long) nums[k]);

                }
            }
        }

        ans.addAll(res);
        return ans;
    }

    // Using Binary Search - > Sorting + Two Pointers -> O(n^3), sc-> O(1)
    public static List<List<Integer>> fourSum4(int nums[], int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    int newTarget = target;
                    newTarget -= nums[i];
                    newTarget -= nums[j];
                    newTarget -= nums[k];
                    // Find newTarget in nums using binary search from k+1 to n
                    int low = k + 1;
                    int high = n - 1;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        if (nums[mid] == newTarget) {
                            List<Integer> res = new ArrayList<>();
                            res.add(nums[i]);
                            res.add(nums[j]);
                            res.add(nums[k]);
                            res.add(newTarget);
                            set.add(res);
                            break;
                        } else if (nums[mid] < newTarget) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    // 31. Next Permutation -> TC : O(n) & SC: O(1)
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverseArr(nums, 0, n - 1); // in place changes
            return;
        }

        // 2nd step: next larger element
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // 3rd step : reverse (piv+1 to n-1)
        reverseArr(nums, pivot + 1, n - 1);
    }

    public static void reverseArr(int nums[], int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    // 53. Maximum Subarray -> using Kadan's Algorithm
    public static int maxSubArray(int nums[]) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            max = Math.max(max, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return max;
    }

    // 56. Merge Intervals
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    // 912. Sort an Array (Merge Sort)
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int nums[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(nums, si, mid);
        mergeSort(nums, mid + 1, ei);
        merge(nums, si, mid, ei);
    }

    private static void merge(int nums[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }

    }

    // 287. Find the Duplicate Number
    public static int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        // According to LeetCode constraints, one duplicate exists.
        return -1;
    }

    public static int findDuplicate2(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }

        return -1;
    }

    public static int findDuplicate3(int nums[]) {
        boolean dup[] = new boolean[nums.length];
        for (int x : nums) {
            if (dup[x]) {
                return x;
            } else {
                dup[x] = true;
            }
        }

        return -1;
    }

    // Find Duplicate Number using Floyd’s Cycle Detection (Tortoise & Hare).
    public static int findDuplicate4(int nums[]) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 1: Find meeting point
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // find duplicate
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // 229. Majority Element II
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 3) {
                ans.add(key);
            }
        }

        return ans;
    }

    // moore's Voting Algorithms
    public static List<Integer> majorityElement2(int nums[]) {
        int n = nums.length;

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                count1++;
            } else if (count2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i])
                count1++;
            if (ele2 == nums[i])
                count2++;
        }

        int mini = (int)(n/3) + 1;

        if (count1 >= mini)
            ans.add(ele1);
        if (count2 >= mini)
            ans.add(ele2);

        Collections.sort(ans);
        return ans;
    }

    // 128. Longest Consecutive Sequence
    // Optimal Approch - O(1)
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currNum = num;
                int streak = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    streak++;
                }
                longest = Math.max(streak, longest);
            }
        }

        return longest;
    }

    // Better Approach
    public static int longestConsecutives(int nums[]){
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]-1 == lastSmaller){
                count += 1;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement2(nums));
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public static void print2DArr(int nums[][]) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                System.out.print(nums[i][j]);
            }
        }

        System.out.println();
    }
}
