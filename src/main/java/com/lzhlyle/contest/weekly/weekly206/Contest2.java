package com.lzhlyle.contest.weekly.weekly206;

import java.util.HashMap;
import java.util.Map;

public class Contest2 {
    // 存在对 x-u 才是更好的选择
    // O(n^2)
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Map<Integer, Integer>> pre = new HashMap<>(); // (x, (each, index))
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> pp = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                pp.put(preferences[i][j], j);
            }
            pre.put(i, pp);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : pairs) {
            map.put(p[0], p[1]);
            map.put(p[1], p[0]);
        }

        int cnt = 0;
        for (int x = 0; x < n; x++) {
            int y = map.get(x);
            for (int u = 0; u < n; u++) {
                if (u == x || u == y) continue;
                int v = map.get(u);

                // 对 x
                // 在 x 中：u 在 y 前
                // 在 u 中：x 在 v 前
                Map<Integer, Integer> xMap = pre.get(x);
                Map<Integer, Integer> uMap = pre.get(u);
                if (xMap.get(u) < xMap.get(y) && uMap.get(x) < uMap.get(v)) {
                    // System.out.printf("x: %s, y: %s, u: %s, v: %s%n", x, y, u, v);
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
