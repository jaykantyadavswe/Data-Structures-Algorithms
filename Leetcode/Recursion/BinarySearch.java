package DSA.Leetcode.Recursion;

class BinarySearch {
    // Binary Search Using Recursion
    public static int binarySearch(int nums[], int target, int st, int end){
        if(st > end){
            return -1;
        }

        int mid = st + (end - st) / 2;

        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] < target){
            return binarySearch(nums, target, mid + 1, end);
        }else{
            return binarySearch(nums, target, st, mid - 1);
        } 
    }
    public static void main(String[] args) {
        int nums[] = {10, 20, 30, 40, 50, 60, 70};
        System.out.println(binarySearch(nums, 30, 0, nums.length-1));
    }
}