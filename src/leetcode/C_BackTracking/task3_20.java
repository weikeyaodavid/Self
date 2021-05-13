package leetcode.C_BackTracking;

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
    StringBuffer sub = new StringBuffer();
    public List<String> restoreIpAddresses(String s) {
        DFS(s, 0, 0);
        return ans;
    }
    private void DFS(String s, int startIndex, int index){
        if(startIndex == 4 && index == s.length()){
            ans.add(sub.substring(0, sub.length() - 1));
            return;
        }
        if(startIndex == 4 && index < s.length()){
            return;
        }
        for(int i = index; i < s.length() && i - index < 3; i++){
            if((i - index) > 0 && s.charAt(index) == '0')return;
            if((s.length() - i) > (4 - startIndex) * 3)return;
            if(Integer.parseInt(s.substring(index, i + 1)) > 255)return;
            sub.append(s, index, i + 1);
            sub.append(".");
            DFS(s, startIndex + 1, i + 1);
            sub.delete(sub.length() - i + index - 2, sub.length());
        }
    }
}