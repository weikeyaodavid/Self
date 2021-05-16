package leetcode.I_UnionFind;

import java.util.Arrays;

public class DFU2 {

    int[] parent;
    int[] rank;

    public DFU2(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int n){
        if(parent[n] != n)parent[n] = find(parent[n]);
        return parent[n];
    }

    public void union(int x, int y){
        if(find(x) == find(y))return;
        if(rank[x] > rank[y]){
            parent[find(y)] = find(x);
        } else if(rank[x] < rank[y]){
            parent[find(x)] = find(y);
        } else {
            parent[find(y)] = find(x);
            rank[x]++;
        }
    }

    public int getSize(){
        int res = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i)res++;
        }
        return res;
    }

}
