package com.lzhlyle.contest.weekly.weekly186;

import java.util.*;

public class Contest3_II {
    // tle: O(nlog(n))
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int suma = a[0] + a[1], sumb = b[0] + b[1];
            if (suma == sumb) return b[0] - a[0];
            return suma - sumb;
        });
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                queue.add(new int[]{i, j});
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            list.add(nums.get(p[0]).get(p[1]));
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3_II contest = new Contest3_II();
        {
            // [[1,2,3],[4,5,6],[7,8,9]]
            List<List<Integer>> list = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(4, 5),
                    Arrays.asList(7, 8, 9)
            );
            int[] res = contest.findDiagonalOrder(list);
            System.out.println(Arrays.toString(res));
        }
    }
}
