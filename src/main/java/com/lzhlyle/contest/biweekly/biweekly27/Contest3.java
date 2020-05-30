package com.lzhlyle.contest.biweekly.biweekly27;

import java.util.ArrayList;
import java.util.List;

public class Contest3 {
    // dfs: lte
    public List<Boolean> checkIfPrerequisite(int n, int[][] pres, int[][] queries) {
        boolean[][] adj = new boolean[n][n];
        for (int[] p : pres) {
            int from = p[0], to = p[1];
            adj[from][to] = true;
        }

        int qlen = queries.length;
        List<Boolean> res = new ArrayList<>(qlen);
        for (int[] q : queries) {
            int from = q[0], to = q[1];
            res.add(valid(adj, from, to));
        }
        return res;
    }

    private boolean valid(boolean[][] adj, int from, int to) {
        if (adj[from][to]) return true;
        for (int i = 0; i < adj.length; i++) {
            if (!adj[from][i]) continue;
            if (valid(adj, i, to)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
