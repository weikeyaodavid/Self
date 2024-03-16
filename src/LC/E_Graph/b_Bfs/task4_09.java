package LC.E_Graph.b_Bfs;

import LC.D_Tree.TreeNode;

import java.util.*;

public class task4_09 {

    //797. All Paths From Source to Target
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<List<Integer>> queue = new LinkedList<>();
        if(graph.length < 1)return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        queue.offer(res);
        while(!queue.isEmpty()){
            List<Integer> start = queue.poll();
            if(start.contains(graph.length - 1)){
                ans.add(start);
                continue;
            }
            int search = start.get(start.size() - 1);
            int end = 0;
            while(end < graph[search].length){
                ArrayList<Integer> temp = new ArrayList<>(start);
                temp.add(graph[search][end]);
                queue.offer(temp);
                end++;
            }
        }
        return ans;
    }

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

    //不好的解法
//    public int maxAreaOfIsland(int[][] grid) {
//        int res = 0;
//        boolean[][] arrived = new boolean[grid.length][grid[0].length];       不能用 x * 10 + y   如果y超过10就不对了
//        LinkedList<int[]> searching = new LinkedList<>();
//        for(int y = 0; y < grid.length; y++){
//            for(int x = 0; x < grid[y].length; x++){
//                if(grid[y][x] == 0 || arrived[y][x])continue;
//                searching.offer(new int[]{y, x});
//                int temp = 0;
//                while(!searching.isEmpty()){
//                    int[] land = searching.poll();
//                    if(!arrived[land[0]][land[1]]){                   需要判断取出来的元素是否已经有了，如果有 11 的情况，右下角的1会被重复计算，上面的解法就不需要考虑这种情况了，无脑入，出来再判断是否已存在
//                        arrived[land[0]][land[1]] = true;                                               11
//                        temp++;
//                        if(land[0] + 1 < grid.length && !arrived[land[0] + 1][land[1]] && grid[land[0] + 1][land[1]] == 1) searching.offer(new int[]{land[0] + 1, land[1]});
//                        if(land[0] - 1 >= 0 && !arrived[land[0] - 1][land[1]] && grid[land[0] - 1][land[1]] == 1) searching.offer(new int[]{land[0] - 1, land[1]});
//                        if(land[1] + 1 < grid[y].length && !arrived[land[0]][land[1] + 1] && grid[land[0]][land[1] + 1] == 1) searching.offer(new int[]{land[0] , land[1] + 1});
//                        if(land[1] - 1>= 0 && !arrived[land[0]][land[1] - 1] && grid[land[0]][land[1] - 1] == 1) searching.offer(new int[]{land[0], land[1] - 1});
//                    }
//                }
//                res = Math.max(temp, res);
//            }
//        }
//        return res;
//    }
}
