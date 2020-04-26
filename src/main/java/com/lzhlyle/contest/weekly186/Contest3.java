package com.lzhlyle.contest.weekly186;

import java.util.*;

public class Contest3 {
    private int[] dx = {1, 0}, dy = {0, 1};

    // wa
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 预处理，补0
        int m = nums.size(), n = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> data = new HashMap<>();
        for (int r = 0; r < m; r++) {
            List<Integer> row = nums.get(r);
            int c = row.size();
            sizeMap.put(r, c);
            n = Math.max(n, c);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < c; i++) {
                map.put(i, row.get(i));
            }
            data.put(r, map);
        }

        // bfs
        List<Integer> list = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        visited.put(0, new HashSet<>(0));
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            if (sizeMap.get(p[0]) <= p[1]) continue;
            int v = data.get(p[0]).get(p[1]);

            // 下、右
            list.add(v);
            for (int di = 0; di < 2; di++) {
                int x = p[0] + dx[di], y = p[1] + dy[di];
                if (x < m && y < n &&
                        (!visited.containsKey(x) || !visited.get(x).contains(y)) &&
                        sizeMap.get(x) > y) {
                    queue.add(new int[]{x, y});
                    if (!visited.containsKey(x)) visited.put(x, new HashSet<>());
                    visited.get(x).add(y);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
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
