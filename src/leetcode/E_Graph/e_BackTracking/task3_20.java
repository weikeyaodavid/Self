package leetcode.E_Graph.e_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_20 {

    //40. Combination Sum II
//    这个避免重复当思想是在是太重要了。
//    这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
//                  1
//                          / \
//                          2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
//            /     \
//            5       5
//    例2
//                  1
//                          /
//                          2      这种情况确是允许的
//               /
//                       2
//
//    为何会有这种神奇的效果呢？
//    首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
//    可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
//    因为当第二个2出现的时候，他就和前一个2相同了。
//
//    那么如何保留例2呢？
//    那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
//    例2的两个2是处在不同层级上的。
//    在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
//    必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
//    第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.


    //这个是标准答案
//    i > index 是为了保证同一层上不会出现重复元素，但是同一条路径上可以有重复的（因为原数组包含重复元素），比如可以有[4,4,5]

//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> ans = new ArrayList<>();
//        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//            Arrays.sort(candidates);
//            dfs(candidates, target, 0);
//            return res;
//        }
//
//        private void dfs(int[] nums, int target, int index){
//            if(target == 0){
//                res.add(new ArrayList<>(ans));
//                return;
//            }
//            if(index == nums.length)return;
//            for(int i = index; i < nums.length; i++){
//                if(i > index && nums[i - 1] == nums[i])continue;
//                if(target - nums[i] < 0)return;
//                ans.add(nums[i]);
//                dfs(nums, target - nums[i], i + 1);
//                ans.remove(ans.size() - 1);
//            }
//        }
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