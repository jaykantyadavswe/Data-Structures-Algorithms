package DSA.Leetcode.Arrays;

import java.util.ArrayList;

public class Hard {
    // Count Inversion
    public static int mergeSort(int arr[], int st, int end){
        if(st < end){
            // find mid
            int mid = st + (end - st) /2;
            int lettInvCount = mergeSort(arr, st, mid); //left invCount
            int rightInvCount = mergeSort(arr, mid+1, end); //right inCount
    
            int invCount = merge(arr, st, mid, end); 
    
            return lettInvCount + rightInvCount +invCount; //total inversion Count
        }

        return 0;
    }

    private static int merge(int arr[], int st, int mid, int end){
        int i = st;
        int j = mid+1;
        int invCount = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while (i <= mid && j <= end) {
            if(arr[i] <= arr[j]){
                list.add(arr[i++]);
            }else{
                list.add(arr[j++]);
                invCount += (mid-i+1); //key logic
            }
        }

        while (i <= mid) {
            list.add(arr[i++]);
        }

        while (j <= end) {
            list.add(arr[j++]);
        }

        for(int idx=0; idx<list.size(); idx++){
            arr[idx + st] = list.get(idx);
        }

        return invCount;
    }

    // 42. Trapping Rain Water - Using Two-Pointer
    public static int trappingRainWater(int height[]){
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    water += leftMax - height[left];
                }

                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 5, 2, 7};
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater(height));
        // int ans = mergeSort(arr, 0, arr.length-1);
        // System.out.println(ans);
    }
}
