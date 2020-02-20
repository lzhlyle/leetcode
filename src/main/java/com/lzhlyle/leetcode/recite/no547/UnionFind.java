package com.lzhlyle.leetcode.recite.no547;

public class UnionFind {
    int count;
    private int[] parents;

    public UnionFind(int n) {
        count = n;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        parents[rootP] = rootQ;
        count--;
    }

    public int find(int target) {
        int root = target;
        // look for root
        while (root != parents[root]) {
            root = parents[root];
        }
        // compress path
        while (target != parents[target]) {
            int temp = target;
            target = parents[target];
            parents[temp] = root;
        }
        return root;
    }
}
