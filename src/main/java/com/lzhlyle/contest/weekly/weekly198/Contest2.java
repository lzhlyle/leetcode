package com.lzhlyle.contest.weekly.weekly198;

import java.util.ArrayList;
import java.util.List;

public class Contest2 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] larr = labels.toCharArray();
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] res = new int[n];
        dfs(0, -1, adj, larr, res);
        return res;
    }

    private int[] dfs(int curr, int parent, List<Integer>[] adj, char[] larr, int[] res) {
        int[] freq = new int[26];
        freq[larr[curr] - 'a']++;
        for (int child : adj[curr]) {
            if (child == parent) continue;
            int[] childFreq = dfs(child, curr, adj, larr, res);
            for (int c = 0; c < 26; c++)
                freq[c] += childFreq[c];
        }
        res[curr] = freq[larr[curr] - 'a'];
        return freq;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
