package com.lzhlyle.contest.weekly.weekly203;

import java.util.TreeMap;

public class Contest3 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // (from, to)
        map.put(1, n);
        for (int i = n - 1; i >= 0; i--) {
            int p = arr[i];

            // 找比 p 小的第一个 key
            int from = map.floorKey(p); // 一定存在
            int to = map.get(from);

            if (p > from) { // 包括 p == to
                if (p - from == m) return i;
                map.put(from, p - 1);
            }

            if (p < to) { // 包括 p == from
                if (to - p == m) return i;
                map.put(p + 1, to);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
