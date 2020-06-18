package com.lzhlyle.leetcode.recite.no787;

import java.util.*;

public class CheapestFlightsWithinKStops_BFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] adj = new int[n][n];
        Set<Integer>[] set = new Set[n]; // tos
        for (int i = 0; i < n; i++)
            set[i] = new HashSet<>();
        for (int[] f : flights) {
            int from = f[0], to = f[1], w = f[2];
            adj[from][to] = w;
            set[from].add(to);
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty() && K-- >= 0) {
            Set<Integer> next = new HashSet<>();
            int[] last = costs.clone();
            while (!queue.isEmpty()) {
                int from = queue.remove(), c = last[from];
                for (int to : set[from]) {
                    costs[to] = Math.min(costs[to], c + adj[from][to]);
                    next.add(to);
                }
            }
            queue = new LinkedList<>(next);
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
