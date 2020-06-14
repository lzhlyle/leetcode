package com.lzhlyle.contest.weekly.weekly193;

import java.util.*;

public class Contest3 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) return -1;

        List<Node> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // desc
        for (int i = 0; i + k - 1 < n; i++) {
            if (!deque.isEmpty() && deque.getFirst() <= i - k) deque.removeFirst();
            while (!deque.isEmpty() && bloomDay[deque.getLast()] < bloomDay[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            list.add(new Node(i, i + k - 1, bloomDay[deque.getFirst()]));
        }

        int len = list.size();
        if (len < m) return -1;

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i).max;
        }

        int[][][] dp = new int[len][m + 1][2]; // dp[当前索引][包括当前的已选][当前选不选]
        for (int i = 0; i < k; i++) {
            dp[i][1][1] = arr[i];
        }
        for (int i = k; i < len; i++) {
            for (int j = 1; j <= m; j++) {
                // dp[i][j][1]
                dp[i][j][1] = Math.max(arr[i], Math.min(dp[i - k][j - 1][0], dp[i - k][j - 1][1]));

                // dp[i][j][0]
                int min = Integer.MAX_VALUE;
                for (int r = i - k; r < i; r++) {
                    min = Math.min(min, dp[i - r][j][1]);
                }
                dp[i][j][0] = min;
            }
        }
        return Math.min(dp[len - 1][m][0], dp[len - 1][m][1]);
    }

    class Node {
        int from, to, max;

        Node(int from, int to, int max) {
            this.from = from;
            this.to = to;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
