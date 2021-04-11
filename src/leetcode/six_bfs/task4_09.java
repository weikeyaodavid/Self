package leetcode.six_bfs;

import leetcode.two_tree.TreeNode;

import java.util.*;

public class task4_09 {

    //103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode temp = root;
        queue.add(temp);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                subRes.add(temp.getVal());
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
            if (reverse) {
                Collections.reverse(subRes);
            }
            reverse = !reverse;
            res.add(subRes);
        }
        return res;
    }



    //695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int maxArea = 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] temp = queue.poll();
                    if (temp[0] >= 0 && temp[0] < grid.length && temp[1] >= 0 && temp[1] < grid[0].length && !visited[temp[0]][temp[1]] && grid[temp[0]][temp[1]] == 1) {
                        maxArea++;
                        visited[temp[0]][temp[1]] = true;
                        queue.add(new int[]{temp[0] - 1, temp[1]});
                        queue.add(new int[]{temp[0] + 1, temp[1]});
                        queue.add(new int[]{temp[0], temp[1] - 1});
                        queue.add(new int[]{temp[0], temp[1] + 1});
                    }
                }
                res = Math.max(res, maxArea);
                maxArea = 0;
            }
        }
        return res;
    }
}
