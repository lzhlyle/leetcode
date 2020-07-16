package com.lzhlyle.leetcode.tomorrow.no785;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // def: 0, 1 : -1

        for (int i = 0; i < n; i++)
            if (colors[i] == 0 && !color(i, 1, colors, graph))
                return false;
        return true;
    }

    private boolean color(int i, int c, int[] colors, int[][] g) {
        if (colors[i] != 0) return colors[i] == c;
        colors[i] = c;
        for (int j : g[i])
            if (!color(j, -c, colors, g))
                return false;
        return true;
    }
}
