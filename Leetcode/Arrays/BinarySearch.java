package DSA.Leetcode.Arrays;

import java.util.*;

import DSA.Leetcode.Math.medium;
import DSA.Leetcode.Strings.easy;

public class BinarySearch {
    // peekElement
    public static int peekElement(int nums[]) {
        int st = 1, end = nums.length - 2;
        // 0 & n-1 both are not peek element
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int peekElement2(int nums[]) {
        int st = 0, end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] < nums[mid + 1]) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        return st;
    }

    // Rotated Arrays
    public static int rotatedArr(int nums[], int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    // 540.Single Element in a Sorted Array
    public static int singleElement(int nums[]) {
        int st = 0;
        int end = nums.length - 1;
        int n = nums.length;

        if (n == 1)
            return nums[0];
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (mid == 0 && nums[mid - 1] != nums[mid]) {
                return nums[mid];
            }

            if (mid == n - 1 && nums[n - 1] != nums[n - 2]) {
                return nums[mid];
            }

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) { // even
                if (nums[mid - 1] == nums[mid]) { // left
                    end = mid - 1;
                } else { // right
                    st = mid + 1;
                }
            } else {// odd
                if (nums[mid - 1] == nums[mid]) {// right
                    st = mid + 1;
                } else { // left
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    // Allocate Minimum Pages
    public static int minPagesAllocated(int arr[], int n, int m) {// O(logN * n)
        if (m > n) {
            return -1;
        }
        int sum = 0;
        for (int num : arr) { // O(n)
            sum += num;
        }

        int ans = -1;
        int st = 0, end = sum; // range of possible ans
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isValid(arr, n, m, mid)) { // left
                ans = mid;
                end = mid - 1;
            } else { // right
                st = mid + 1;
            }
        }

        return ans;
    }

    // O(n)
    private static boolean isValid(int arr[], int n, int m, int maxAllowedPages) { // mid -> max Allowed Pages
        int stu = 1, pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllowedPages) {
                return false;
            }

            if (pages + arr[i] <= maxAllowedPages) {
                pages += arr[i];
            } else {
                stu++;
                pages = arr[i];
            }
        }

        return stu > m ? false : true;
    }

    // Aggressive Cows
    public static int getDistance(int arr[], int N, int C) {
        Arrays.sort(arr);

        int st = 1, end = arr[N - 1] - arr[0];
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isPossible(arr, N, C, mid)) { // right
                ans = mid;
                st = mid + 1;
            } else { // left
                end = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int arr[], int N, int C, int minAllowedDist) {
        int cows = 1, lastStallPos = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - lastStallPos >= minAllowedDist) {
                cows++;
                lastStallPos = arr[i];
            }

            if (cows == C) {
                return true;
            }
        }

        return false;
    }

    // Painter’s Partition
    public static int minTimeToPaint(int arr[], int n, int m) {
        int sum = 0, maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxVal = Math.max(maxVal, arr[i]);
        }

        int st = maxVal, end = sum;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isPossible2(arr, n, m, mid)) { // left
                ans = mid;
                st = mid - 1;
            } else { // right
                end = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible2(int arr[], int n, int m, int maxAllowedTime) {
        int painters = 1, time = 0;

        for (int i = 0; i < n; i++) {
            if (time + arr[i] <= maxAllowedTime) {
                time += arr[i];
            } else {
                painters++;
                time = arr[i];
            }
        }

        return painters <= m;
    }

    // 4. Median of Two Sorted Arrays
    // Brute force Approach
    public static double findMedianSortedArrays(int nums1[], int nums2[]) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            list.add(num);
        }

        for (int num : nums2) {
            list.add(num);
        }

        Collections.sort(list);

        int totalSize = list.size();

        double median = 0;

        if (totalSize % 2 == 0) {
            median = (list.get(totalSize / 2) + list.get(totalSize / 2 - 1)) / 2.0;
        } else {
            median = list.get(totalSize / 2);
        }

        return median;
    }

    // Brute force without sorting use
    public static double findMedianSortedArrays2(int nums1[], int nums2[]) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergeList.add(nums1[i++]);
            } else {
                mergeList.add(nums2[j++]);
            }
        }

        while (i < nums1.length) {
            mergeList.add(nums1[i++]);
        }

        while (j < nums2.length) {
            mergeList.add(nums2[j++]);
        }

        int totalSize = mergeList.size();

        double median = 0;
        if (totalSize % 2 != 0) {
            median = mergeList.get(totalSize / 2);
        } else {
            median = (mergeList.get(totalSize / 2) + mergeList.get(totalSize / 2 - 1)) / 2.0;
        }

        return median;
    }

    // Better Approach
    public static double findMedianSortedArrays3(int nums1[], int nums2[]) {
        int totalSize = nums1.length + nums2.length;

        int i = 0, j = 0, k = 0;
        double median = 0;
        int idx1 = (totalSize / 2) - 1;
        int element = 0;
        int idx2 = (totalSize / 2);
        int element2 = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (idx1 == k) {
                    element = nums1[i];
                }

                if (idx2 == k) {
                    element2 = nums1[i];
                }
                i++;
            } else {
                if (idx1 == k) {
                    element = nums2[j];
                }

                if (idx2 == k) {
                    element2 = nums2[j];
                }
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            if (idx1 == k) {
                element = nums1[i];
            }

            if (idx2 == k) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }

        while (j < nums2.length) {
            if (idx1 == k) {
                element = nums2[j];
            }

            if (idx2 == k) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }

        System.out.println(element);
        System.out.println(element2);

        if (totalSize % 2 == 0) {
            median = (element + element2) / 2.0;
        } else {
            median = element2;
        }

        return median;
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 1, 3, 4 };
        // System.out.println(singleElement(arr));
        /*
         * int arr[] = {4,5,6,7,0,1,2};
         * System.out.println(rotatedArr(arr, 0));
         */
        /*
         * int n = 4, m = 2;
         * System.out.println(minPagesAllocated(arr, n, m));
         */

        /*
         * int arr[] = { 1, 2, 8, 4, 9 };
         * int N = 5, C = 3;
         * System.out.println(getDistance(arr, N, C));
         */

        int nums1[] = { 1, 2 };
        int nums2[] = { 3, 4 };
        System.out.println(findMedianSortedArrays3(nums1, nums2));
    }
}
