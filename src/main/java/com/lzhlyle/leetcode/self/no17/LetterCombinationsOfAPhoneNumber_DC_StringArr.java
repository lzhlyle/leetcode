package com.lzhlyle.leetcode.self.no17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_DC_StringArr {
    private static final String[] _MAP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return Collections.emptyList();
        List<String> res = new LinkedList<>();
        _combine(digits.toCharArray(), 0, "", res);
        return res;
    }

    private void _combine(char[] chars, int i, String curr, List<String> res) {
        if (i >= chars.length) {
            res.add(curr);
            return;
        }
        for (char c : _MAP[chars[i] - '0'].toCharArray()) _combine(chars, i + 1, curr + c, res);
    }
}
