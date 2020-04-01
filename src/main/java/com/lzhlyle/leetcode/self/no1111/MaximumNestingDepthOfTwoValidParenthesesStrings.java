package com.lzhlyle.leetcode.self.no1111;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        char[] arr = seq.toCharArray();
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0, l = 0, r = 0; i < len; i++) {
            if (arr[i] == '(') res[i] = (++l) & 1;
            else res[i] = (++r) & 1;
        }
        return res;
    }
}
