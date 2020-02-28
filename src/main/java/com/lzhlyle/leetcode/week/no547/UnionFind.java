package com.lzhlyle.leetcode.week.no547;

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

    public void union(int a, int b) {
        if (a == b) return;
        int rootA = find(a), rootB = find(b);
        if (rootA == rootB) return;
        parents[rootA] = rootB;
        count--;
    }

    private int find(int t) {
        int root = t;
        while (root != parents[root]) root = parents[root];
        while (t != parents[t]) {
            int x = t;
            t = parents[t];
            parents[x] = root;
        }
        return root;
    }
}
