package com.lzhlyle.contest.biweekly.biweekly26;

public class Contest1 {
    public int maxPower(String s) {
        char last = 0;
        int len = 1, max = 0;
        for (char c : s.toCharArray()) {
            if (last == c) len++;
            else {
                last = c;
                len = 1;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
