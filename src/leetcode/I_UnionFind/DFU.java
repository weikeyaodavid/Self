package leetcode.I_UnionFind;

public class DFU {
    int[] parent;
    public DFU(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int n){
        if(parent[n] != n)parent[n] = find(parent[n]);
        return parent[n];
    }

    public void union(int x, int y){
        parent[find(x)] = find(y);
    }
}
