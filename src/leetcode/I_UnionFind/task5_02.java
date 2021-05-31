package leetcode.I_UnionFind;

import java.util.*;

public class task5_02 {

    //323. Number of Connected Components in an Undirected Graph
    public int countComponents(int n, int[][] edges) {
        DFU dfu = new DFU(n);
        for(int i = 0; i < edges.length; i++){
            dfu.union(edges[i][0], edges[i][1]);
        }
        int res = 0;
        for(int i = 0; i < dfu.parent.length; i++){
            if(dfu.parent[i] == i)res++;
        }
        return res;
    }



    //547. Number of Provinces
    public int findCircleNum(int[][] isConnected) {
        DFU dfu = new DFU(isConnected.length);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = i + 1; j < isConnected.length; j++){
                if(isConnected[i][j] == 1)dfu.union(i, j);
            }
        }
        int res = 0;
        for(int i = 0; i < dfu.parent.length; i++){
            if(dfu.parent[i] == i)res++;
        }
        return res;
    }



    //305. Number of Islands II
    //有问题，超时，自己重做
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