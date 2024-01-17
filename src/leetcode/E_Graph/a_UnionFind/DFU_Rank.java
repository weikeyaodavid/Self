package leetcode.E_Graph.a_UnionFind;

import java.util.Arrays;

public class DFU_Rank {

    int[] root;
    int[] rank;

    public DFU_Rank(int n){
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    // 对 find 函数的优化
    // 时间复杂度  O(logN) N 为「图」中顶点的个数。
    public int find(int n){
        if(root[n] != n){
            root[n] = find(root[n]);
        }
        return root[n];
    }

    // 对 union 函数的优化
    // 时间复杂度  O(logN) N 为「图」中顶点的个数。
    public void union(int x, int y){
        if(find(x) == find(y))return;
        if(rank[x] > rank[y]){
            root[find(y)] = find(x);
        } else if(rank[x] < rank[y]){
            root[find(x)] = find(y);
        } else {
            root[find(y)] = find(x);
            rank[x]++;
        }
    }
}
