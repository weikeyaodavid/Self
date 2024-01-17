package leetcode.E_Graph.e_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_18 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();


    //46 Permutation 排列
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs(nums, startIndex + 1);
            path.remove(path.size() - 1);
        }
    }


    //47 Permutations II
    //重点是在此剪枝   使用回溯法  1 和 1'   在1已经完全搜索过的情况下，再去搜索1'的情况是完全一样的，所以当你搜索到1' 并且1还未被
    //使用时，得知之后的遍历是完全相同的
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs2(nums, new int[nums.length]);
        return res;
    }

    private void dfs2(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //重点是在此剪枝   使用回溯法  1 和 1'   在1已经完全搜索过的情况下，再去搜索1'的情况是完全一样的，所以当你搜索到1' 并且1还未被
            //使用时，1'之后的分支和1是完全相同的
            if (used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)) continue;
            path.add(nums[i]);
            used[i] = 1;
            dfs2(nums, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }


    //22 Generate Parentheses
    List<String> res1 = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, new StringBuffer(), 0);
        return res1;
    }

    private void backTrack(int n, int key, StringBuffer path1, int pivot) {
        if (key < 0 || key > n || pivot > 3) return;
        if (path1.length() == 2 * n) {
            res1.add(path1.toString());
            return;
        }
        for (int i = -1; i <= 1; i = i + 2) {
            if (i == 1) {
                path1.append("(");
                pivot++;
            } else path1.append(")");
            key = key + i;
            backTrack(n, key, path1, pivot);
            path1.deleteCharAt(path1.length() - 1);
            key = key - i;
        }
    }


    //78. Subsets
    //注意重点   放入 a 是全排列   放入 a + 1 是子集
    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0; i <= nums.length; i++){
            backtrack(i, nums, 0);
        }
        return res;
    }
    private void backtrack(int i, int[] nums, int startIndex) {
        if(path.size() == i){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int a = startIndex; a <= nums.length; a++){
            path.add(nums[a]);
            //此处是重点，放入 a + 1
            backtrack(i, nums, a + 1);
            path.remove(path.size() - 1);
        }
    }
}


