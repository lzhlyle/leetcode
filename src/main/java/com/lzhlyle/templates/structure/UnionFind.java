package com.lzhlyle.templates.structure;

/**
 * 并查集
 */
public class UnionFind {
    // independent union count
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n; // all independent
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // initial
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        parent[rootP] = rootQ;
        count--;
    }

    public int find(int p) {
        int root = p;

        // looking for root
        while (root != parent[root]) { // terminator
            root = parent[root]; // drill down
        }

        // compressing path
        while (p != parent[p]) { // terminator
            int x = p;
            p = parent[p]; // drill down
            parent[x] = root; // compress path
        }
        return root;
    }
}
