package leetcode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_20 {

    //40. Combination Sum II
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new int[candidates.length]);
        return res;
    }
    private void dfs(int[] candidates, int target, int startIndex, int[] used){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(candidates[i] > target)return;
            if(used[i] == 1 || (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0))continue;
            path.add(candidates[i]);
            used[i] = 1;
            dfs(candidates, target - candidates[i], i + 1, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }



    //93. Restore IP Addresses
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        DFS(s, new StringBuffer(), 0);
        return ans;
    }
    private void DFS(String s, StringBuffer sb, int startIndex){
        if(startIndex == s.length()){
            ans.add(sb.toString());
            return;
        }
        if(Integer.parseInt(sb.toString()) > 255)return;

    }

}
//        s = "25525511135"
//        Output: ["255.255.11.135","255.255.111.35"]
//        0 - 255