package com.lzhlyle.contest.weekly.weekly185;

public class Contest3 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int cnt = 0, res = 0;
        char[] arr = {'c', 'r', 'o', 'a', 'k'};
        int[] freq = new int[26];
        for (char c : croakOfFrogs.toCharArray()) {
            freq[c - 'a']++;
            // 必须保证降序
            for (int i = 0; i < 4; i++) {
                if (freq[arr[i] - 'a'] < freq[arr[i + 1] - 'a']) return -1;
            }
            if (c == 'c') res = Math.max(res, ++cnt); // 最多的同时发声
            else if (c == 'k') cnt--;
        }
        // 总数应相同
        for (int i = 0; i < 4; i++) {
            if (freq[arr[i] - 'a'] != freq[arr[i + 1] - 'a']) return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
