package com.lzhlyle.leetcode.week.no32;

import java.util.HashMap;
import java.util.Map;

public class LongestValidParentheses_Recursion_Memorize {
    // two points
    // 枚举中心点并扩散，累计扩散宽度，看能否连起来
    private Map<Integer, Integer> map = new HashMap<>(); // (right, left)

    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        for (int c = 0; c < arr.length - 1; c++) {
            if (arr[c] == '(' && arr[c + 1] == ')') {
                int r = expand(arr, c, c + 1);
                max = Math.max(max, r - map.get(r) + 1);
                c = r;
            }
        }
        return max;
    }

    private int expand(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == '(' && arr[r] == ')') {
            l--;
            r++;
        }
        if (map.containsKey(l)) return expand(arr, map.get(l) - 1, r);
        map.put(r - 1, l + 1);
        return r - 1;
    }
}
