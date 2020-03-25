package com.lzhlyle.leetcode.recite.no32;

import java.util.HashMap;
import java.util.Map;

public class LongestValidParentheses_Recursion_Memorize {
    // two points
    // 枚举中心点并扩散，累计扩散宽度，看能否连起来
    Map<Integer, Integer> map = new HashMap<>(); // (right, left)

    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        for (int c = 0, len = arr.length; c < len - 1; c++) {
            if (arr[c] == '(' && arr[c + 1] == ')') {
                int[] lr = expend(arr, c, c + 1);
                int l = lr[0], r = lr[1];
                max = Math.max(max, r - l + 1);
                c = r;
            }
        }
        return max;
    }

    private int[] expend(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == '(' && arr[r] == ')') {
            l--;
            r++;
        }
        if (map.containsKey(l)) return expend(arr, map.get(l), r - 1);
        map.put(r - 1, l + 1); // (right, left)
        return new int[]{l + 1, r - 1};
    }

    public static void main(String[] args) {
        int res = new LongestValidParentheses_Recursion_Memorize().longestValidParentheses(")()())");
        System.out.println(res);

    }
}
