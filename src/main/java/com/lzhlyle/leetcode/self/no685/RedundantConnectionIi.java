package com.lzhlyle.leetcode.self.no685;

public class RedundantConnectionIi {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] ins = new int[n + 1];
        int[] outs = new int[n + 1];
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] res = new int[2];
        int tt = -1;
        for (int[] e : edges) {
            int from = e[0], to = e[1];
            ins[to]++;
            outs[from]++;
            adj[from][to] = true;
            if (ins[to] == 2) tt = to;
            if (ins[to] == 1 && outs[to] > 0) res = e;
        }

        if (tt != -1) {
            res = null;
            for (int i = n - 1; i >= 0; i--) {
                int f = edges[i][0], t = edges[i][1];
                if (t == tt && outs[f] + ins[f] > 1) {
                    if (res == null) res = edges[i];
                    if (adj[t][f]) return edges[i];
                }
            }
        }

        return res;
    }
}
