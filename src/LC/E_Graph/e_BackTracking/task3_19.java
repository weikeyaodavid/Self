package LC.E_Graph.e_BackTracking;

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
    //超过时间了  不过应该是对的
    //可以看看精简的写法

    static boolean suc = false;
    public static boolean exist(char[][] board, String word) {
        int m = board[0].length;
        int n = board.length;
        int[][] arr = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};

        ArrayList<ArrayList<Integer>> point = new ArrayList<>();
        for(int a = 0; a < n; a++){
            for(int b = 0; b < m; b++){
                if(board[a][b] == word.charAt(0)){
                    ArrayList<Integer> find = new ArrayList<>();
                    find.add(a);
                    find.add(b);
                    point.add(find);
                }
            }
        }

        for (ArrayList<Integer> integers : point) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(integers);
            int[][] qq = new int[n][m];
            qq[integers.get(0)][integers.get(1)] = 1;
            findWord(ans, board, word, 1, qq, arr);
            if (suc) break;
        }
        return suc;
    }
    private static void findWord(ArrayList<ArrayList<Integer>> point, char[][] board, String word, int startIndex, int[][] used, int[][] arr){
        if(startIndex == word.length()){
            suc = true;
            return;
        }
        for (int[] ints : arr) {
            int n = ints[0] + point.get(point.size() - 1).get(0);
            int m = ints[1] + point.get(point.size() - 1).get(1);
            if (n >= board.length || n < 0 || m < 0 || m >= board[0].length || board[n][m] != word.charAt(startIndex) || used[n][m] == 1) continue;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(n);
            temp.add(m);
            point.add(temp);
            used[n][m] = 1;
            findWord(point, board, word, startIndex + 1, used, arr);
            point.remove(point.size() - 1);
            used[n][m] = 0;
        }
    }


//    public boolean exist(char[][] board, String word) {
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, visited, board)) return true;
//            }
//        }
//        return false;
//
//    }
//
//    private boolean backtrack(int i, int j, int idx, String word, boolean[][] visited, char[][] board) {
//        if (idx == word.length()) return true;
//        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j])
//            return false;
//        visited[i][j] = true;
//        if (backtrack(i + 1, j, idx + 1, word, visited, board) || backtrack(i - 1, j, idx + 1, word, visited, board) || backtrack(i, j + 1, idx + 1, word, visited, board) || backtrack(i, j - 1, idx + 1, word, visited, board))
//            return true;
//        visited[i][j] = false; // 回溯
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
