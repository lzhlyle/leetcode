package com.lzhlyle.templates.structure;

/**
 * 并查集
 */
public class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // initial
        }
    }

    public boolean union(int p, int q) {
        if (p == q) return false;
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;

        parent[rootP] = rootQ;
        count--;
        return true;
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }

        while (p != parent[p]) {
            int x = p;
            p = parent[p];
            parent[x] = root;
        }
        return root;
    }
}
