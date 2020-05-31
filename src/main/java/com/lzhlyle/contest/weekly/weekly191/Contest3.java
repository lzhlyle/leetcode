package com.lzhlyle.contest.weekly.weekly191;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Contest3 {
    // bfs
    public int minReorder(int n, int[][] connections) {
        int cnt = 0;

        Set<Integer>[] adj = new Set[n];
        Set<Integer>[] links = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
            links[i] = new HashSet<>();
        }
        for (int[] c : connections) {
            int from = c[0], to = c[1];
            adj[from].add(to);
            links[from].add(to);
            links[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int node = queue.remove();
                Set<Integer> list = new HashSet<>(links[node]);
                list.removeAll(visited);
                for (int neighbor : list) {
                    if (adj[node].contains(neighbor)) cnt++;
                }
                visited.addAll(list);
                next.addAll(list);
            }
            queue = next;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
