package com.lzhlyle.contest.weekly.weekly205;

import java.util.Arrays;

public class Contest4 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (edges.length == 1) return 0;

        int[][] ins = new int[n + 1][3 + 1]; // 各点的入度情况
        for (int[] e : edges) {
            int type = e[0], a = e[1], b = e[2];
            ins[a][type]++;
            ins[b][type]++;
        }

        // 检查无法完全遍历
        for (int i = 1; i <= n; i++) {
            int[] in = ins[i];
            if (in[3] == 0 && (in[1] == 0 || in[2] == 0))
                return -1;
        }

        // 可完全遍历
        int res = 0;
        // 并查集
        UnionFind ufa = new UnionFind(n), ufb = new UnionFind(n);
        // 先选共用 e[0] desc
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);
        for (int[] e : edges) {
            int type = e[0], a = e[1], b = e[2];
            if (type == 1) {
                if (!ufa.union(a, b)) res++;
            } else if (type == 2) {
                if (!ufb.union(a, b)) res++;
            } else {
                boolean ua = ufa.union(a, b), ub = ufb.union(a, b);
                if (!ua && !ub) res++; // Alice, Bob 都不再需要这条边
            }
        }
        return res;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
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
            while (root != parent[root])
                root = parent[root];
            while (p != parent[p]) {
                int x = p;
                p = parent[p];
                parent[x] = root;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
