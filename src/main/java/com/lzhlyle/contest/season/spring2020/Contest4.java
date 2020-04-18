package com.lzhlyle.contest.season.spring2020;

import java.util.LinkedList;
import java.util.Queue;

public class Contest4 {
    // bfs
    public int minJump(int[] jump) {
        int n = jump.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>(); // index
        queue.add(0);
        visited[0] = true;
        return bfs(0, queue, jump, visited, n, 0);
    }

    private int bfs(int level, Queue<Integer> queue, int[] jump, boolean[] visited, int n, int last) {
        if (queue.isEmpty()) return -1;
        level++;
        Queue<Integer> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            Integer i = queue.remove();

            // forward
            int r = i + jump[i];
            if (r >= n) return level;
            if (!visited[r]) {
                next.add(r);
                visited[r] = true;
            }

            // backward
            for (int l = last; l < i; l++) {
                if (visited[l]) continue;
                next.add(l);
                visited[l] = true;
            }
            if (last < i) last = i;
        }
        return bfs(level, next, jump, visited, n, last);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            int[] jump = {5, 20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int min = contest.minJump(jump);
            System.out.println(min);
        }
    }
}
