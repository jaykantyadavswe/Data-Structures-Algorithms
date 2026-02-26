package DSA.Leetcode.Arrays;

import java.util.HashSet;

public class Easy {
    // 2965. Find Missing and Repeated Values
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int freq[] = new int[n * n + 1];
        int ans[] = new int[2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                freq[grid[i][j]]++;
            }
        }

        for(int i=1; i<=n*n; i++){
            if(freq[i] > 1 ){
                ans[0] = i;
            }

            if(freq[i] == 0){
                ans[1] = i;
            }

        }
        return ans;
    }

    // Using HashSet & Math - O(n^2)
    public static int[] findMissingAndRepeatedValues2(int [][]grid){
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        int actualSum = 0, expectedSum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                }
                
                set.add(grid[i][j]);
            }
        }

        expectedSum = (n*n) * (n*n + 1) / 2;
        // missing = expectedSum - actualSum + duplicate
        ans[1] = expectedSum - actualSum + ans[0];
        printArr(ans);
        return ans;
    }
    public static void main(String[] args) {
        int grid[][] = {{9,1,7},{8,9,2},{3,4,6}};
        findMissingAndRepeatedValues2(grid);
    }


    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
