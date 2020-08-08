package com.lzhlyle.contest.biweekly.biweekly32;

import java.util.HashMap;
import java.util.Map;

public class Contest2 {
    public boolean canConvertString(String s, String t, int k) {
        char[] sarr = s.toCharArray(), tarr = t.toCharArray();
        if (sarr.length != tarr.length) return false;

        int n = sarr.length, max = 0;
        Map<Integer, Integer> map = new HashMap<>(); // (l, r)
        for (int i = 0; i < n; i++) {
            int v = tarr[i] - sarr[i];
            if (v < 0) v += 26;
            int l = v;
            while (v > 0 && map.containsKey(v) && k >= v) {
                v = (map.getOrDefault(v, v)) + 26;
            }
            map.put(l, v);
            max = Math.max(max, v);
            if (k < max) return false;
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(max);
        return k >= max;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
