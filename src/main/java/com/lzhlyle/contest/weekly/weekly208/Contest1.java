package com.lzhlyle.contest.weekly.weekly208;

public class Contest1 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("../")) res = Math.max(res - 1, 0);
            else if (log.equals("./")) res = res;
            else res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
