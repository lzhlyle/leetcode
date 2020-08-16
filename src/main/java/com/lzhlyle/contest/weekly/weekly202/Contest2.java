package com.lzhlyle.contest.weekly.weekly202;

public class Contest2 {
    public int minOperations(int n) {
        int to = (2 * (n - 1) + 1) / 2 + 1;
        int res = 0;
        for (int i = 1; i < to; i += 2)
            res += to - i;
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            
        }
    }
}
