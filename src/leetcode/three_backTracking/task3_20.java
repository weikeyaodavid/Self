package leetcode.three_backTracking;

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
    static List<String> ans = new ArrayList<>();
    static StringBuffer sub = new StringBuffer();
    public static List<String> restoreIpAddresses(String s) {
        DFS(s, 0, 0, 0);
        return ans;
    }
    private static void DFS(String s, int startIndex, int index, int num){
        if(startIndex == 4 && index == s.length()){
            sub.deleteCharAt(sub.length() - 1);
            ans.add(sub.toString());
            return;
        }
        if(index == s.length())return;
        if(Integer.parseInt(s.substring(index, index + 1 + num)) > 255)return;
        for(int i = index; i < s.length() && num < 3; i++){
            sub.append(s, index, i + 1);
            sub.append(".");
            DFS(s, startIndex + 1, index, num + 1);
            sub.delete(index, i + 2);
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
}
//        s = "25525511135"
//        Output: ["255.255.11.135","255.255.111.35"]
//        0 - 255