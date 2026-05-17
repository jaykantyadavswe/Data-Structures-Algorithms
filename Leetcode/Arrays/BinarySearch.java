package DSA.Leetcode.Arrays;

public class BinarySearch {
    // peekElement
    public static int peekElement(int nums[]){
        int st = 1, end = nums.length-2;
        // 0 & n-1 both are not peek element
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid-1] < nums[mid]){
                st = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int peekElement2(int nums[]){
        int st = 0, end = nums.length-1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] < nums[mid+1]){
                st = mid + 1;
            }else{
                end = mid;
            }
        }

        return st;
    }

    // Rotated Arrays
    public static int rotatedArr(int nums[], int target){
        int st = 0;
        int end = nums.length-1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[st] <= nums[mid]){
                if(nums[st] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    st = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    st = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    //540.Single Element in a Sorted Array
    public static int singleElement(int nums[]){
        int st = 0;
        int end = nums.length-1;
        int n = nums.length;

        if(n == 1) return nums[0];
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if(mid == 0 && nums[mid-1] != nums[mid]){
                return nums[mid];
            }

            if(mid == n-1 && nums[n-1] != nums[n-2]){
                return nums[mid];
            }

            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            if(mid % 2 == 0){ //even
                if(nums[mid-1] == nums[mid]){ //left
                    end = mid - 1;
                }else{ //right
                    st = mid + 1;
                }
            }else{//odd
                if(nums[mid-1] == nums[mid]){//right
                    st = mid + 1;
                }else{ //left
                    end = mid -1;
                }
            }

        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleElement(arr));
        /* int arr[] = {4,5,6,7,0,1,2};
        System.out.println(rotatedArr(arr, 0)); */
    }
}
