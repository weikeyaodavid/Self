package leetcode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_19 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //90. Subsets II
    //经典回溯去重方法
    // if(used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0))continue;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            dfs(i, nums, new int[nums.length], 0);
        }
        return res;
    }
    private void dfs(int length, int[] nums, int[] used, int startIndex){
        if(path.size() == length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            if(used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0))continue;
            path.add(nums[i]);
            used[i] = 1;
            dfs(length, nums, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }



    //79. Word Search
    public boolean exist(char[][] board, String word) {

        return true;
    }

}
