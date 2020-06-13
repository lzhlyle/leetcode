package com.lzhlyle.leetcode.week.no210;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleIi_Adj {
    public int[] findOrder(int n, int[][] pres) {
        // construct adj
        Set<Integer>[] adj = new Set[n];
        for (int i = 0; i < n; i++)
            adj[i] = new HashSet<>();
        int[] ins = new int[n];
        for (int[] p : pres) {
            int from = p[1], to = p[0];
            adj[from].add(to);
            ins[to]++;
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (ins[i] == 0) queue.add(i);
        if (queue.isEmpty()) return new int[0];

        int[] res = new int[n];
        int ri = 0;
        while (!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int i = queue.remove();
                res[ri++] = i;
                for (int j : adj[i])
                    if (ins[j]-- == 1) next.add(j);
            }
            queue = next;
        }

        // check
        if (ri != n) return new int[0];
        return res;
    }
}
