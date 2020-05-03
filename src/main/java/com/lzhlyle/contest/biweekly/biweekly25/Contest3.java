package com.lzhlyle.contest.biweekly.biweekly25;

public class Contest3 {
    // 田忌赛马
    // O(n) 不可排序
    // 假设 s1[i] >= s2[i]
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int[] freq1 = new int[26], freq2 = new int[26];
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        boolean s1Win = false, s2Win = false;
        for (int i = 25; i >= 0; i--) {
            if (freq1[i] == freq2[i]) continue;
            if (!s1Win && !s2Win) {
                // 从未有过期望
                if (freq1[i] > freq2[i]) {
                    // 1 > 2
                    s1Win = true;
                    if (i - 1 >= 0) freq1[i - 1] += freq1[i] - freq2[i];
                } else {
                    // 2 > 1
                    s2Win = true;
                    if (i - 1 >= 0) freq2[i - 1] += freq2[i] - freq1[i];
                }
            } else {
                // 应该符合期望
                if (freq1[i] > freq2[i]) {
                    if (s2Win) return false;
                    // 1 > 2
                    if (i - 1 >= 0) freq1[i - 1] += freq1[i] - freq2[i];
                } else {
                    // 2 > 1
                    if (s1Win) return false;
                    if (i - 1 >= 0) freq2[i - 1] += freq2[i] - freq1[i];
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
