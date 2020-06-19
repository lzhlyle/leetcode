package com.lzhlyle.leetcode.self.no787;

import java.util.Arrays;

// BellmanFord(dp)
public class CheapestFlightsWithinKStops_BellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] next = Arrays.copyOf(cost, n);
            for (int[] f : flights) {
                int from = f[0], to = f[1], c = f[2];
                if (cost[from] == Integer.MAX_VALUE) continue; // cannot arrive `from` currently
                next[to] = Math.min(next[to], cost[from] + c); // min cost in `to` base `from`
            }
            cost = next;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
