package com.lzhlyle.leetcode.self.no186;

public class ReverseWordsInAStringIi {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int r = 0, l = r, len = s.length; r < len; r++) {
            if (s[r] == ' ') {
                reverse(s, l, r - 1);
                l = r + 1;
            } else if (r == len - 1) reverse(s, l, r);
        }
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l++] ^= arr[r--];
        }
    }
}
