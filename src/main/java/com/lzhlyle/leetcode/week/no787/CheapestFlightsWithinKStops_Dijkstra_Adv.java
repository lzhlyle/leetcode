package com.lzhlyle.leetcode.week.no787;

import java.util.*;

// Dijkstra(greedy)
public class CheapestFlightsWithinKStops_Dijkstra_Adv {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // prepare for O(1) search
        int[][] adj = new int[n][n]; // adj[from][to] = cost
        Set<Integer>[] set = new Set[n]; // set[from] = tos
        for (int i = 0; i < n; i++)
            set[i] = new HashSet<>();
        for (int[] f : flights) {
            int from = f[0], to = f[1], c = f[2];
            adj[from][to] = c;
            set[from].add(to);
        }

        // Modeling: {from, current-price, stopTimes}
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // price min first
        queue.add(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] city = queue.remove();
            int from = city[0], cost = city[1], stops = city[2];
            if (from == dst) return cost;
            if (stops > K) continue;
            for (int to : set[from])
                queue.add(new int[]{to, cost + adj[from][to], stops + 1});
        }
        return -1;
    }
}
