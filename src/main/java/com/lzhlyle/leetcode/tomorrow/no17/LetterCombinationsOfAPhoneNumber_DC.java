package com.lzhlyle.leetcode.tomorrow.no17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_DC {
    private static final String[] _MAP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return Collections.emptyList();
        List<String> res = new LinkedList<>();
        _combine(res, "", digits.toCharArray(), 0);
        return res;
    }

    private void _combine(List<String> res, String curr, char[] chars, int i) {
        if (i >= chars.length) {
            res.add(curr);
            return;
        }
        for (char c : _MAP[chars[i] - '0'].toCharArray()) _combine(res, curr + c, chars, i + 1);
    }
}
