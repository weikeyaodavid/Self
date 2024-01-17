package leetcode.E_Graph.b_Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class task4_11 {

    //200. Number of Islands
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    queue.add(new int[]{i, j});
                    res++;
                }
                while (!queue.isEmpty()) {
                    int[] a = queue.poll();
                    if (a[0] >= 0 && a[1] >= 0 && a[0] < grid.length && a[1] < grid[0].length && !visited[a[0]][a[1]] && grid[a[0]][a[1]] == '1') {
                        visited[a[0]][a[1]] = true;
                        queue.add(new int[]{a[0] + 1, a[1]});
                        queue.add(new int[]{a[0] - 1, a[1]});
                        queue.add(new int[]{a[0], a[1] + 1});
                        queue.add(new int[]{a[0], a[1] - 1});
                    }
                }
            }
        }
        return res;
    }


    //130. Surrounded Regions
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                List<int[]> res = new ArrayList<>();
                if (board[i][j] == 'O' && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                }
                boolean useful = true;
                while (!queue.isEmpty()) {
                    int[] a = queue.poll();
                    if (a[0] >= 0 && a[1] >= 0 && a[0] < board.length && a[1] < board[0].length && board[a[0]][a[1]] == 'O' && !visited[a[0]][a[1]]) {
                        if (a[0] - 1 < 0 || a[1] - 1 < 0 || a[0] + 1 >= board.length || a[1] + 1 >= board[0].length) useful = false;
                        visited[a[0]][a[1]] = true;
                        res.add(new int[]{a[0], a[1]});
                        queue.add(new int[]{a[0] + 1, a[1]});
                        queue.add(new int[]{a[0] - 1, a[1]});
                        queue.add(new int[]{a[0], a[1] + 1});
                        queue.add(new int[]{a[0], a[1] - 1});
                    }
                }
                if (useful && res.size() > 0) {
                    for (int k = 0; k < res.size(); k++) {
                        board[res.get(k)[0]][res.get(k)[1]] = 'X';
                    }
                }
            }
        }
    }


    //剑指 Offer 13. 机器人的运动范围
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.add(new int[]{0, 0});
                while (!queue.isEmpty()) {
                    int[] a = queue.poll();
                    if (a[0] >= 0 && a[1] >= 0 && a[0] < m && a[1] < n && !visited[a[0]][a[1]] && check(a[0], a[1], k)) {
                        visited[a[0]][a[1]] = true;
                        res++;
                        queue.add(new int[]{a[0] + 1, a[1]});
                        queue.add(new int[]{a[0] - 1, a[1]});
                        queue.add(new int[]{a[0], a[1] + 1});
                        queue.add(new int[]{a[0], a[1] - 1});
                    }
                }
            }
        }
        return res;
    }

    public boolean check(int a, int b, int k) {
        int res1 = 0;
        while (a != 0) {
            res1 = res1 + a % 10;
            a = a / 10;
        }
        int res2 = 0;
        while (b != 0) {
            res2 = res2 + b % 10;
            b = b / 10;
        }
        return (res1 + res2) <= k;
    }
}
