package DSA.DSAJourney;
import java.util.*;;

class Day4 {
    // 15. 3Sum
    // Brute Force
    public static List<List<Integer>> threeSum(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if(i > 0 && nums[i] == nums[i-1]) continue; //Duplicate Skip

            for (int j = i + 1; j < nums.length - 1; j++) {

                if(j > i+1 && nums[j] == nums[j-1]) continue;//Duplicate Skip

                for (int k = j + 1; k < nums.length; k++) {

                    if(k > j+1 && nums[k] == nums[k-1]) continue;//Duplicate Skip

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }

                }
            }
        }

        return lists;
    }

    // Better Approach - O(n^2 * log(unique triplate))
    public static List<List<Integer>> threeSum2(int nums[]){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<n-2; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<n-1; j++){
                int tar = -(nums[i] + nums[j]);

                if(set.contains(tar)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], tar);

                    Collections.sort(triplet);

                    if(!res.contains(triplet)){
                        res.add(triplet);
                    }
                }

                set.add(nums[j]);
            }
        }

        return res;
    }

    // Oprimal Approach - O(nLogn + n^2)
    public static List<List<Integer>> threeSum3(int nums[]){
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);

                    Collections.sort(triplets);

                    if(!lists.contains(triplets)){
                        lists.add(triplets);
                    }

                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }

        return lists;
    }

    // 18. 4Sum
    // Brute Force
    public static List<List<Integer>> fourSum(int nums[], int target){
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k=j+1; k<n-1; k++){
                    for(int p=k+1; p<n; p++){
                        int sum = nums[i] + nums[j] + nums[k] + nums[p];
                        if(sum == target){
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[p]);
                            
                            Collections.sort(list);
                            if(!lists.contains(list)){
                                lists.add(list);
                            }
                        }
                    }
                }
            }
        }

        return lists;
    }

    // Optimal Approach
    public static List<List<Integer>> fourSum2(int nums[], int target){
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<n-3; i++) {
            // Skip duplicate
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-2; j++){
                // Skip duplicate
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1;
                int high = n-1;

                while (low < high) {
                    long sum = (long) nums[i] + nums[j] + nums[low] + nums[high];

                    if(sum == target){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);

                        lists.add(list);

                        while(low < high && nums[low] == nums[low+1]) low++; // Skip duplicate
                        while(low < high && nums[high] == nums[high-1]) high--; // Skip duplicate
                        low++;
                        high--;
                    }else if(sum < target){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }

        return lists;
    }

    // 74. Search a 2D Matrix
    // Brute Force - O(m * n)
    public static boolean searchMatrix(int matrix[][], int target){
        int low = 0;
        int high = matrix.length-1;

        while (low <= high) {
            if(matrix[low][high] == target){
                return true;
            }

            if(matrix[low][high] < target){
                low++;
            }else{
                high--;
            }
        }

        return false;
    }

    // Optimal Approach
    public static boolean searchMatrix2(int matrix[][], int target){
        int n = matrix.length; int m = matrix[0].length;
        int startRow = 0, endRow = m-1;

        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            if(target >= matrix[midRow][0] && target <= matrix[midRow][n-1]){
                return searchInRow(matrix, target, midRow);
            }else if(target >= matrix[midRow][n-1]){
                startRow = midRow + 1;
            }else{
                endRow = midRow - 1;
            }
        }

        return false;
    }

    private static boolean searchInRow(int matrix[][], int target, int row){
        int n = matrix[0].length;
        int st = 0, end = n-1;

        while (st <= end) {
            int midRow = st + (end - st) / 2;

            if(target == matrix[row][midRow]){
                return true;
            }else if(target > matrix[row][midRow]){
                st = midRow + 1;
            }else{
                end = midRow - 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        /* int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum3(nums)); */

        /* int nums[] = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum2(nums, target)); */

        int matrix[][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
}