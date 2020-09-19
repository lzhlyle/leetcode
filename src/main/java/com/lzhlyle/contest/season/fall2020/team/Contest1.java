package com.lzhlyle.contest.season.fall2020.team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest1 {
    private int cnt;
    private Map<Integer, Set<Integer>> map;

    public int paintingPlan(int n, int k) {
        if (k == 0) return 1;
        if (n > k) return 0;
        cnt = 0;

        // bitwise: long: 64 bits
        int[][] arr = new int[n][n];
        map = new HashMap<>();
        dfs(0b0, 0b0, 0, 0, n, k, 0);
        return cnt;
    }

    private void dfs(int i, int j, int ii, int jj, int n, int k, int currCnt) {
        if (currCnt > k) return;
        if (currCnt == k) {
            if (!map.containsKey(i) || !map.get(i).contains(j)) {
                System.out.printf("i: %s, j: %s, ii: %s, jj: %s, currCnt: %s%n",
                        Integer.toBinaryString(i),
                        Integer.toBinaryString(i),
                        ii, jj, currCnt);
                if (!map.containsKey(i)) map.put(i, new HashSet<>());
                map.get(i).add(j);
                cnt++;
            }
            return;
        }

        if (ii < n) {
            // 涂
            int nextI = i | (1 << ii);
            dfs(nextI, j, ii + 1, jj, n, k, count(nextI, j, n));

            // 不涂
            dfs(i, j, ii + 1, jj, n, k, currCnt);
        }

        if (jj < n) {
            // 涂
            int nextJ = j | (1 << jj);
            dfs(i, nextJ, ii, jj + 1, n, k, count(i, nextJ, n));

            // 不涂
            dfs(i, j, ii, jj + 1, n, k, currCnt);
        }
    }

    private int count(int a, int b, int n) {
        // System.out.printf("a: %s, b: %s, ", a, b);
        int i = 0, j = 0;
        while (a != 0) {
            a &= a - 1;
            i++;
        }
        while (b != 0) {
            b &= b - 1;
            j++;
        }

        // 有共 i 行、共 j 列 被涂色
        int res = (i * n) + (j * n) - (i * j);
        // System.out.printf("i: %s, j: %s, res: %s%n", i, j, res);
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            int res = contest.paintingPlan(2, 2);
            System.out.println(res);
        }
    }
}
