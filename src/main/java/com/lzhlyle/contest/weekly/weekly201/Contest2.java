package com.lzhlyle.contest.weekly.weekly201;

public class Contest2 {
    public char findKthBit(int n, int k) {
        char[] curr = {'0'};
        for (int i = 1; i <= n && k >= curr.length; i++) {
            curr = str(curr);
        }
        return curr[k - 1];
    }

    private char[] str(char[] last) {
        int n = last.length, len = 2 * n + 1;
        char[] res = new char[len];
        for (int i = 0; i < n; i++) {
            res[i] = last[i];
            res[len - i - 1] = last[i] == '1' ? '0' : '1';
        }
        res[n] = '1';
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            
        }
    }
}
