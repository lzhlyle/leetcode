package com.lzhlyle.contest.season.spring2020.solo;

import java.util.*;

public class Contest2 {
    // bfs
    private int cnt = 0;

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] rel : relation) {
            if (!map.containsKey(rel[0])) map.put(rel[0], new HashSet<>());
            map.get(rel[0]).add(rel[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        bfs(0, queue, map, k, n);
        return cnt;
    }

    private void bfs(int level, Queue<Integer> queue, Map<Integer, Set<Integer>> map, int k, int n) {
        if (queue.isEmpty() || level >= k) return;
        level++;
        Queue<Integer> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            Integer from = queue.remove();
            if (map.containsKey(from)) {
                for (Integer to : map.get(from)) {
                    if (to == n - 1 && level == k) cnt++;
                    next.add(to);
                }
            }
        }

        bfs(level, next, map, k, n);
    }


    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
