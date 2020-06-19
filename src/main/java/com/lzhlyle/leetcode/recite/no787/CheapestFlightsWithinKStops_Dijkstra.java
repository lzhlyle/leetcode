package com.lzhlyle.leetcode.recite.no787;

import java.util.*;

public class CheapestFlightsWithinKStops_Dijkstra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // prepare for O(1) search
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>(); // (from, (to, price))
        for (int[] f : flights) {
            int from = f[0], to = f[1], cost = f[2];
            if (!prices.containsKey(from)) prices.put(from, new HashMap<>());
            prices.get(from).put(to, cost);
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // price min first
        queue.add(new int[]{src, 0, k + 1}); // {from, current-price, stopTimes}
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int from = top[0], price = top[1], stops = top[2];
            if (from == dst) return price;

            if (stops > 0) {
                Map<Integer, Integer> toPriceMap = prices.getOrDefault(from, new HashMap<>());
                for (int to : toPriceMap.keySet()) {
                    queue.add(new int[]{to, price + toPriceMap.get(to), stops - 1});
                }
            }
        }
        return -1;
    }
}
