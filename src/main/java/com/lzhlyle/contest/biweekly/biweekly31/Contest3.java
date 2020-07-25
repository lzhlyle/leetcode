package com.lzhlyle.contest.biweekly.biweekly31;

import java.util.HashMap;
import java.util.Map;

public class Contest3 {
    public int numSplits(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        Map<Character, Integer> l = new HashMap<>(), r = new HashMap<>();
        l.put(arr[0], 1);

        // i 为 右侧的开始
        for (int i = 1; i < n; i++)
            r.put(arr[i], r.getOrDefault(arr[i], 0) + 1);

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            // 将 arr[i] 已到 l 之前判断
            if (l.size() == r.size()) cnt++;

            // move
            l.put(arr[i], l.getOrDefault(arr[i], 0) + 1);
            int f = r.get(arr[i]);
            if (f-- == 1) r.remove(arr[i]);
            else r.put(arr[i], f);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
