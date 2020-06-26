package com.lzhlyle.leetcode.self.no973;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin_PriorityQueue {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Node> queue = new PriorityQueue<>((a, b) -> Long.compare(b.dis, a.dis)); // max-heap
        for (int[] p : points) {
            queue.add(new Node(p));
            while (queue.size() > K)
                queue.remove();
        }
        return queue.stream().map(n -> n.p).toArray(int[][]::new);
    }

    class Node {
        int[] p;
        long dis;

        Node(int[] p) {
            this.p = p;
            this.dis = dis(p);
        }

        private long dis(int[] p) {
            long x = (long) p[0], y = (long) p[1];
            return x * x + y * y;
        }
    }
}
