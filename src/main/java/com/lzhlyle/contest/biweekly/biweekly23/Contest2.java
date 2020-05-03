package com.lzhlyle.contest.biweekly.biweekly23;

public class Contest2 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char c : arr) freq[c - 'a']++;
        int odd = 0;
        for (int f : freq) {
            if ((f & 1) == 1) odd++;
        }
        return odd < k + 1;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
