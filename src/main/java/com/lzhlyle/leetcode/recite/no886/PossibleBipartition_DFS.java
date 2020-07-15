package com.lzhlyle.leetcode.recite.no886;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition_DFS {
    public boolean possibleBipartition(int n, int[][] dis) {
        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int[] d : dis) {
            int a = d[0], b = d[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        for (int i = 1; i <= n; i++)
            if (colors[i] == -1 && !color(i, 0, colors, adj))
                return false;
        return true;
    }

    private boolean color(int i, int c, int[] colors, List<Integer>[] adj) {
        if (colors[i] != -1) return colors[i] == c;
        colors[i] = c;
        for (int j : adj[i])
            if (!color(j, c ^ 1, colors, adj))
                return false;
        return true;
    }
}
