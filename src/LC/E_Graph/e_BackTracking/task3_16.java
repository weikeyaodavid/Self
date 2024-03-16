package LC.E_Graph.e_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task3_16 {


    //52. N-Queens II
    // 左对角线规律 y - x 相同    右对角线规律 y + x 相同
    List<List<String>> resA = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    List<Integer> lineLimit = new ArrayList<>();
    List<Integer> leftLimit = new ArrayList<>();
    List<Integer> rightLimit = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(n, 0);
        return resA;
    }

    private void dfs(int n, int y){
        if(y == n){
            resA.add(new ArrayList<>(ans));
            return;
        }
        for(int x = 0; x < n; x++){
            if(!lineLimit.contains(x) && !leftLimit.contains(y - x) && !rightLimit.contains(y + x)){
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < n; i++){
                    if(i == x){
                        temp.append("Q");
                        continue;
                    }
                    temp.append(".");
                }

                lineLimit.add(x);
                leftLimit.add(y - x);
                rightLimit.add(y + x);
                ans.add(temp.toString());
                dfs(n, y + 1);
                ans.remove(ans.size() - 1);
                lineLimit.remove(lineLimit.size() - 1);
                leftLimit.remove(leftLimit.size() - 1);
                rightLimit.remove(rightLimit.size() - 1);
            }
        }
    }

//    ArrayList<ArrayList<Integer>> resA = new ArrayList<>();
//    ArrayList<Integer> list = new ArrayList<>();
//    public int totalNQueens(int n) {
//        boolean[][] array = new boolean[n][n];
//        dfs(n, 0);
//        return resA.size();
//    }
//    public void dfs(int n, int row) {
//        if (row == n) resA.add(new ArrayList<>(list));
//        for (int col = 0; col < n; col++) {
//            if (check(n, list, col, row)) {
//                list.add(row);
//                list.add(col);
//                dfs(n, row + 1);
//                list.remove(list.size() - 1);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//    public boolean check(int n, ArrayList<Integer> list, int col, int row) {
//        if (list.size() != 0) {
//            for (int i = 0; i < list.size(); i = i + 2) {
//                if (list.get(i) == row || list.get(i + 1) == col) return false;
//            }
//        }
//        for (int i = 0; i < list.size(); i = i + 2) {
//            int j = i + 1;
//            int c = list.get(i);
//            int d = list.get(j);
//            for (int a = c, b = d; a < n && b < n; a++, b++) {
//                if (a == row && col == b) return false;
//            }
//            for (int a = c, b = d; a > 0 && b > 0; a--, b--) {
//                if (a == row && col == b) return false;
//            }
//            for (int a = c, b = d; a < n && b >= 0; a++, b--) {
//                if (a == row && b == col) return false;
//            }
//            for (int a = c, b = d; b < n && a >= 0; b++, a--) {
//                if (a == row && b == col) return false;
//            }
//
//        }
//        return true;
//    }

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
