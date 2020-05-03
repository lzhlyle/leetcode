package com.lzhlyle.contest.weekly187;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest4_BruteForce {
    // brute force
    // 40^40
    public int kthSmallest(int[][] mat, int k) {
        int sum = 0, m = mat.length, n = mat[0].length, times = 1;
        for (int[] row : mat) sum += row[0];
        if (k == 1) return sum;

        Queue<Node> min = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        while (k-- > 0) {
            min.remove();
        }
        return min.element().val;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Contest4_BruteForce contest = new Contest4_BruteForce();
        {
            int[][] mat = {{1, 3, 11}, {2, 4, 6}};
            int res = contest.kthSmallest(mat, 5);
            System.out.println(res);
        }
    }
}
