package com.lzhlyle.contest.weekly187;

import java.util.ArrayList;
import java.util.List;

public class Contest4 {
    // wa
    // 未必基于 choose 向后选，可以向前选
    public int kthSmallest(int[][] mat, int k) {
        // 先选所有行第0个
        int sum = 0, m = mat.length, n = mat[0].length, times = 1;
        for (int[] row : mat) sum += row[0];
        if (k == 1) return sum;

        // 记录每行选了谁
        List<int[]> list = new ArrayList<>(); // int[m]
        list.add(new int[m]); // 全0
        // 选到第k个结束
        while (times < k) {
            // 哪行下一个最小就选它为下一个
            List<int[]> nextList = new ArrayList<>();
            int minDelMin = Integer.MAX_VALUE, currCnt = 1;
            for (int[] choose : list) {
                List<int[]> next = new ArrayList<>();
                int delMin = Integer.MAX_VALUE, cnt = 1;
                for (int i = 0; i < m; i++) {
                    if (choose[i] + 1 >= n) continue;
                    if (mat[i][choose[i] + 1] - mat[i][choose[i]] < delMin) {
                        delMin = mat[i][choose[i] + 1] - mat[i][choose[i]];
                        cnt = 1;

                        // 新的最小差
                        int[] copy = choose.clone();
                        copy[i]++;
                        next.clear();
                        next.add(copy);
                    } else if (mat[i][choose[i] + 1] - mat[i][choose[i]] == delMin) {
                        cnt++;
                        // 同差的另一种情况
                        int[] copy = choose.clone();
                        copy[i]++;
                        next.add(copy);
                    }
                }
                if (delMin < minDelMin) {
                    minDelMin = delMin;
                    currCnt = cnt;
                    nextList = next;
                }
            }
            sum += minDelMin;
            times += currCnt;
            list = nextList;
        }
        return sum;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {
            int[][] mat = {{1, 3, 11}, {2, 4, 6}};
            int res = contest.kthSmallest(mat, 5);
            System.out.println(res);
        }
    }
}
