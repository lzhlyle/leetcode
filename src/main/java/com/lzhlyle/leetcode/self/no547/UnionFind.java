package com.lzhlyle.leetcode.self.no547;

public class UnionFind {
    int count;
    private int[] parents;

    public UnionFind(int n) {
        count = n;
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        parents[rootA] = rootB;
        count--;
    }

    private int find(int target) {
        int root = target;
        while (root != parents[root]) root = parents[root];
        while (target != parents[target]) {
            int temp = target;
            target = parents[target];
            parents[temp] = root;
        }
        return root;
    }
}
