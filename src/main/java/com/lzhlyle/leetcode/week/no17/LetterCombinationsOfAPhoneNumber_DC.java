package com.lzhlyle.leetcode.week.no17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_DC {
    private static final String[] _MAP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        List<String> res = new LinkedList<>();
        _combine(digits.toCharArray(), 0, "", res);
        return res;
    }

    private void _combine(char[] arr, int ai, String curr, List<String> res) {
        if (ai == arr.length) {
            res.add(curr);
            return;
        }

        for (char c : _MAP[arr[ai] - '0'].toCharArray()) _combine(arr, ai + 1, curr + c, res);
    }
}
