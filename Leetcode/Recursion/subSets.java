import java.util.*;

public class subSets{
    // 78. Subsets
    public static void SubSets(int nums[], int i, List<Integer> curr, List<List<Integer>> ans){
        // base case
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // include
        curr.add(nums[i]);
        SubSets(nums, i+1, curr, ans);

        // exclude
        curr.remove(curr.size()-1);
        SubSets(nums, i+1, curr, ans);
    }

    // 90. Subsets II
    public static void SubSetsII(int nums[], int i, List<Integer> curr, List<List<Integer>> ans){
        int n = nums.length;
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Include
        curr.add(nums[i]);
        SubSetsII(nums, i+1, curr, ans);

        curr.remove(curr.size()-1);
        int idx = i+1;
        while (idx < n && nums[idx] == nums[idx-1]) {
            idx++;
        }
        
        // Exclude
        SubSetsII(nums, idx, curr, ans);
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        SubSetsII(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);  
    }
}