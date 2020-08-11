package com.lzhlyle.leetcode.recite.no93;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        bt(0, s.toCharArray(), 0, new Stack<>(), res);
        return res;
    }

    // T(n) = T(n-1) + T(n-2) + T(n-3) + O(1)
    private void bt(int level, char[] arr, int i, Stack<String> curr, List<String> res) {
        if (level == 4 && i == arr.length) {
            res.add(String.join(".", curr));
            return;
        }
        for (int j = i; j < i + 3 && j < arr.length; j++) {
            if (arr.length - 1 - j > (4 - level) * 3) continue; // rest too much
            if (valid(arr, i, j)) {
                curr.push(new String(arr, i, j - i + 1));
                bt(level + 1, arr, j + 1, curr, res);
                curr.pop();
            }
        }
    }

    private boolean valid(char[] arr, int l, int r) {
        if (arr[l] == '0') return l == r;
        int total = 0;
        for (int i = l; i <= r; i++) {
            total = total * 10 + (arr[i] - '0');
            if (total > 255) return false;
        }
        return true;
    }
}
