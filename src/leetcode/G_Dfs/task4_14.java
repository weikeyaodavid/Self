package leetcode.G_Dfs;

import worktest.Node;

import java.util.*;

public class task4_14 {

    //684. Redundant Connection
    //并查集
    //有一点很重要：边[a,b]意味着a所在集合可以和b所在集合合并。
    //合并方法很多，这里我们简单地将a集合的代表节点戳到b集合的代表节点上
    //这意味着，将b集合代表节点作为合并后大集合的代表节点
    //对于一个集合的代表节点s，一定有s->s，意思是s如果是代表节点，那么它本身不存在代表节点

    //[a, b] 本身a， b会连接   若a的根节点 和 b的根节点指向同一个点， 则表示必然有环 （针对于无环图）
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> root = new HashMap<>();
        for (int i = 0; i < edges.length + 1; i++) {
            root.put(i, i);
        }
        for (int[] temp : edges) {
            int a = find(temp[0], root);
            int b = find(temp[1], root);
            if (a == b) return temp;
            root.put(root.get(a), b);
        }
        return null;
    }

    public int find(int point, Map<Integer, Integer> map) {
        while (point != map.get(point)) {
            point = map.get(point);
        }
        return point;
    }


    //210. Course Schedule II
    //[a, b] b -> a
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> num = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] r = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            num.put(i, 0);
        }
        for (int[] temp : prerequisites) {
            map.get(temp[1]).add(temp[0]);
            num.put(temp[0], num.get(temp[0]) + 1);
        }
        for (int i : num.keySet()) {
            if (num.get(i) == 0) {
                queue.add(i);
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            List<Integer> list = map.get(temp);
            for (int i : list) {
                num.put(i, num.get(i) - 1);
                if (num.get(i) == 0) {
                    queue.add(i);
                    res.add(i);
                }
            }
        }
        if (res.size() != numCourses) return new int[0];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }



    //52. N-Queens II
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public int totalNQueens(int n) {
        boolean[][] array = new boolean[n][n];
        dfs(n, 0);
        return res.size();
    }
    public void dfs(int n, int row) {
        if (row == n) res.add(new ArrayList<>(list));
        for (int col = 0; col < n; col++) {
            if (check(n, list, col, row)) {
                list.add(row);
                list.add(col);
                dfs(n, row + 1);
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean check(int n, ArrayList<Integer> list, int col, int row) {
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i = i + 2) {
                if (list.get(i) == row || list.get(i + 1) == col) return false;
            }
        }
        for (int i = 0; i < list.size(); i = i + 2) {
            int j = i + 1;
            int c = list.get(i);
            int d = list.get(j);
            for (int a = c, b = d; a < n && b < n; a++, b++) {
                if (a == row && col == b) return false;
            }
            for (int a = c, b = d; a > 0 && b > 0; a--, b--) {
                if (a == row && col == b) return false;
            }
            for (int a = c, b = d; a < n && b >= 0; a++, b--) {
                if (a == row && b == col) return false;
            }
            for (int a = c, b = d; b < n && a >= 0; b++, a--) {
                if (a == row && b == col) return false;
            }

        }
        return true;
    }



    //133. Clone Graph
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()){
            Node ori = queue.poll();
            for(Node a : ori.neighbors){
                if(!map.containsKey(a)){
                    map.put(a, new Node(a.val, new ArrayList<>()));
                    queue.add(a);
                }
                map.get(ori).neighbors.add(map.get(a));
            }
        }
        return map.get(node);
    }
}
