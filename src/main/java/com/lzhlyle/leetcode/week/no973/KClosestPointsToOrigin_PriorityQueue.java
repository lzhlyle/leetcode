package com.lzhlyle.leetcode.week.no973;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin_PriorityQueue {
    public int[][] kClosest(int[][] points, int K) {
        // {x, y, dis}
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] p : points) {
            queue.add(new int[]{p[0], p[1], dis(p)});
            while (queue.size() > K)
                queue.remove();
        }
        return queue.stream()
                .map(p -> new int[]{p[0], p[1]})
                .toArray(int[][]::new);
    }

    private int dis(int[] p) {
        int x = p[0], y = p[1];
        return x * x + y * y;
    }
}
