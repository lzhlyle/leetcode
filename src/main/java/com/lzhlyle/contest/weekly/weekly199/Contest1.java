package com.lzhlyle.contest.weekly.weekly199;

import java.util.HashMap;
import java.util.Map;

public class Contest1 {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()], arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
            res[indices[i]] = arr[i];
        return new String(res);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            Map<Integer, Integer> res = new HashMap<>(), a = new HashMap<>(), b = new HashMap<>();
            res.putAll(a);
        }
    }
}
