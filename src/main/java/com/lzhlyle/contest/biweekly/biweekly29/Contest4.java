package com.lzhlyle.contest.biweekly.biweekly29;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Contest4 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        Set<Integer>[] adj = new Set[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new HashSet<>();
        int[] outs = new int[n + 1], ins = new int[n + 1];
        for (int[] d : dependencies) {
            int from = d[0], to = d[1];
            adj[from].add(to);
            outs[from]++;
            ins[to]++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> outs[b] - outs[a]);
        for (int i = 1; i <= n; i++) {
            if (ins[i] == 0) queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            Set<Integer> set = new HashSet<>();
            int rest = k;
            while (!queue.isEmpty() && rest > 0) {
                rest--;
                int from = queue.remove();
                for (int to : adj[from]) {
                    ins[to]--;
                    if (ins[to] == 0) set.add(to);
                }
            }

            set.addAll(queue);

            queue = new PriorityQueue<>((a, b) -> outs[b] - outs[a]);
            queue.addAll(set);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
