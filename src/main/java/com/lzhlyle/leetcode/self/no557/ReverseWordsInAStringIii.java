package com.lzhlyle.leetcode.self.no557;

public class ReverseWordsInAStringIii {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for (int r = 0, len = arr.length, l = 0; r < len; r++) {
            if (arr[r] == ' ') {
                reverse(arr, l, r - 1);
                l = r + 1;
            } else if (r == len - 1) reverse(arr, l, r);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l++] ^= arr[r--];
        }
    }
}
