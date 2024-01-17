package leetcode.E_Graph.a_UnionFind;

public class DFU {

    // 时间复杂度  O(H) H为树的高度
    int[] root;

    public DFU(int n){
        root = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
    }

    public int find(int n){
        while(n != root[n]){
            n = root[n];
        }
        return n;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            root[rootY] = rootX;
        }
    }

}
