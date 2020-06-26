package com.lzhlyle.leetcode.recite.no207;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] pres) {
        if (pres.length < 2) return true;

        int[] ins = new int[n]; // 入度
        Set<Integer>[] adj = new Set[n];
        for (int i = 0; i < n; i++)
            adj[i] = new HashSet<>();
        for (int[] pre : pres) {
            int to = pre[0], from = pre[1];
            ins[to]++;
            adj[from].add(to);
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (ins[i] == 0) queue.add(i);
        if (queue.isEmpty()) return false;

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int from = queue.remove();
            for (int to : adj[from]) {
                if (ins[to]-- == 1) queue.add(to);
            }
        }
        return cnt == n;
    }
}
