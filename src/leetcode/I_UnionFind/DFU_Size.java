package leetcode.I_UnionFind;

import java.util.Arrays;

public class DFU_Size {

    int[] parent;
    int[] size;

    public DFU_Size(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

    public void union(int x, int y) {
        if (find(x) == find(y)) return;
        if (size[x] >= size[y]) {
            parent[find(y)] = find(x);
            size[x] = size[x] + size[y];
        } else {
            parent[find(x)] = find(y);
            size[y] = size[x] + size[y];
        }
    }
}
