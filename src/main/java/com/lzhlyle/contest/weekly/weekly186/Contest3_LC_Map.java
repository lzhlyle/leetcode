package com.lzhlyle.contest.weekly.weekly186;

import java.util.*;

public class Contest3_LC_Map {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            int size = row.size();
            n += size;
            for (int j = 0; j < size; j++) {
                if (!map.containsKey(i + j)) map.put(i + j, new ArrayList<>());
                map.get(i + j).add(row.get(j));
            }
        }
        int[] res = new int[n];
        int ri = 0, k = 0;
        while (map.containsKey(k)) {
            List<Integer> list = map.get(k++);
            for (int i = list.size() - 1; i >= 0; i--) {
                res[ri++] = list.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3_LC_Map contest = new Contest3_LC_Map();
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
