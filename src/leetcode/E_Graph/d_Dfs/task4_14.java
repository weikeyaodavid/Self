package leetcode.E_Graph.d_Dfs;

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
        int result = 0;
        unionClass un = new unionClass(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (un.compare(edges[i][0], edges[i][1])) {
                result = i;
                continue;
            }
            un.union(edges[i][0], edges[i][1]);
        }
        return edges[result];
    }

    class unionClass {
        int[] root;
        int[] depth;

        unionClass(int n) {
            root = new int[n];
            depth = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                depth[i] = 1;
            }
        }

        int findRoot(int index) {
            if (root[index] == index) {
                return index;
            }
            return root[index] = findRoot(root[index]);
        }

        void union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (depth[rootA] > depth[rootB]) {
                root[rootB] = rootA;
            } else if (depth[rootB] > depth[rootA]) {
                root[rootA] = rootB;
            } else {
                root[rootA] = rootB;
                depth[rootB]++;
            }
        }

        boolean compare(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            return rootA == rootB;
        }
    }


    //133. Clone Graph
    // 1. 要识别图是有向图还是无向图，无向图需要visited来标识是否已经访问过
    // 2. ArrayList中可以包含 null 节点！！！
    // 3. HashMap.containsKey  查找是否包含这个key
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
