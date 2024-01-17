package leetcode.E_Graph.a_UnionFind;

import java.util.*;

public class task5_02 {

    //547. Number of Provinces
    public int findCircleNum(int[][] isConnected) {
        DFU graph = new DFU(isConnected.length);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    graph.union(i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < graph.root.length; i++){
            if(graph.root[i] == i)res++;
        }
        return res;
    }

    //323. Number of Connected Components in an Undirected Graph
//    你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条边。
//    返回 图中已连接分量的数目
    public int countComponents(int n, int[][] edges) {
        DFU dfu = new DFU(n);
        for(int i = 0; i < edges.length; i++){
            dfu.union(edges[i][0], edges[i][1]);
        }
        int res = 0;
        for(int i = 0; i < dfu.root.length; i++){
            if(dfu.root[i] == i)res++;
        }
        return res;
    }

    //305. Number of Islands II
    //有问题，超时，自己重做
//    给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有单元格都是 0）。
//    可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是要执行第 i 次操作的位置 (ri, ci) 。
//    返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。
//    岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> unique = new ArrayList<>();
        DFU_Rank dfu = new DFU_Rank(positions.length);
        for(int i = 0; i < positions.length; i++){
            if(unique.contains(positions[i][0] * n + positions[i][1])){
                res.add(res.get(res.size() - 1));
                continue;
            }
            for(int k : map.keySet()){
                if(map.get(k).contains(positions[i][0] * n + positions[i][1])){
                    dfu.union(k,i);
                }
            }
            ArrayList<Integer> subRes = new ArrayList<>();
            if(positions[i][0] - 1 >= 0)subRes.add((positions[i][0] - 1) * n + positions[i][1]);
            if(positions[i][0] + 1 < m)subRes.add((positions[i][0] + 1) * n + positions[i][1]);
            if(positions[i][1] - 1 >= 0)subRes.add((positions[i][0]) * n + positions[i][1] - 1);
            if(positions[i][1] + 1 < n)subRes.add((positions[i][0]) * n + positions[i][1] + 1);
            map.put(i, subRes);
            unique.add(positions[i][0] * n + positions[i][1]);
            res.add(/* dfu.getSize() */ - (positions.length - (i + 1)) - (i + 1 - unique.size()));
        }
        return res;
    }
}