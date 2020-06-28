package com.lzhlyle.contest.weekly.weekly195;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Contest2 {
    // hash table
    public boolean canArrange(int[] arr, int k) {
        // 全取余
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] =  (arr[i] % k + k) % k;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            if (map.containsKey(k - v)) {
                map.put(k - v, map.get(k - v) - 1);
                if (map.get(k - v) == 0) map.remove(k - v);
            } else if (map.containsKey(-v)) {
                map.put(-v, map.get(-v) - 1);
                if (map.get(-v) == 0) map.remove(-v);
            } else {
                if (!map.containsKey(v)) map.put(v, 0);
                map.put(v, map.get(v) + 1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
