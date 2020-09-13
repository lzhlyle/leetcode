package com.lzhlyle.contest.weekly.weekly206;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest3 {
    // 连最近的点
    // union set
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 0;

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dis = dis(points, i, j);
                queue.add(new int[]{i, j, dis});
            }
        }

        int sum = 0;
        UnionFind uf = new UnionFind(n);
        while (uf.count > 1) {
            int[] ele = queue.remove();
            int i = ele[0], j = ele[1], dis = ele[2];
            if (uf.union(i, j)) {
                sum += dis;
            }
        }
        return sum;
    }

    private int dis(int[][] arr, int i, int j) {
        int[] a = arr[i], b = arr[j];
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    class UnionFind {
        // independent union count
        int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            count = n; // all independent
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // initial
            }
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;

            parent[rootP] = rootQ;
            count--;
            return true;
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

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
