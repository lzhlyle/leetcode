package com.lzhlyle.leetcode.recite.no17;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_DC {
    private static final char[][] _MAP = new char[10][];

    static {
        _MAP[0] = new char[0];
        _MAP[1] = new char[0];
        _MAP[2] = new char[]{'a', 'b', 'c'};
        _MAP[3] = new char[]{'d', 'e', 'f'};
        _MAP[4] = new char[]{'g', 'h', 'i'};
        _MAP[5] = new char[]{'j', 'k', 'l'};
        _MAP[6] = new char[]{'m', 'n', 'o'};
        _MAP[7] = new char[]{'p', 'q', 'r', 's'};
        _MAP[8] = new char[]{'t', 'u', 'v'};
        _MAP[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) return Collections.emptyList();
        List<String> res = new LinkedList<>();
        _combine(digits.toCharArray(), 0, res, "");
        return res;
    }

    private void _combine(char[] arr, int i, List<String> res, String curr) {
        if (i >= arr.length) {
            res.add(curr);
            return;
        }
        for (char letter : _MAP[arr[i] - '0']) _combine(arr, i + 1, res, curr + letter);
    }
}
