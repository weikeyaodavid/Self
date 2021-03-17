package leetcode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_16 {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    //回溯法就相当于是暴力搜索 + 剪枝操作
    //暴力搜索采用 DFS 的方式
    //剪枝在 for 循环中裁去


    //77    回溯算法都能转化为树形结构
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }
    private void dfs(int start, int all, int num){
        if(num == 0){
            res.add(new ArrayList<>(path));     //加入copy  不能直接加入对象  加入对象改变时res内的值也会变
            return;
        }
        for(int i = start; i <= all; i++){      //剪枝操作  i <=  n - (num - path.size)  num = 4， 已经放入 2 元素，还剩下 2 个元素， 最后一个元素就不需要遍历了
            path.add(i);
            dfs(i + 1, all, num - 1);
            path.remove(path.size() - 1);
        }
    }


    //39
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);                                //剪枝操作
        dfs(candidates, target, 0, 0);
        return res;
    }
    private static void dfs(int[] candidates, int target, int sum, int startIndex){
        if(sum > target)return;
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(sum + candidates[i] > target)return;             //剪枝操作
            path.add(candidates[i]);
            sum = sum + candidates[i];
            dfs(candidates, target, sum, i);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }

}
