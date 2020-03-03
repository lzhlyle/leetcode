package com.lzhlyle.leetcode.recite.no186;

public class ReverseWordsInAStringIi {
    public void reverseWords(char[] s) {
        int len = s.length;
        for (int r = 0, l = r; r < len; r++) {
            if (s[r] == ' ') {
                reverse(s, l, r - 1);
                l = r + 1;
            } else if (r == len - 1) reverse(s, l, r);
        }
        reverse(s, 0, len - 1);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l++] ^= arr[r--];
        }
    }

    public static void main(String[] args) {
        char[] arr = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new ReverseWordsInAStringIi().reverseWords(arr);
        System.out.println(arr);
    }
}
