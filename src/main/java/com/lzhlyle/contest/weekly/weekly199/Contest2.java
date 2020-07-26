package com.lzhlyle.contest.weekly.weekly199;

public class Contest2 {
    public int minFlips(String t) {
        char[] arr = t.toCharArray();
        int res = 0;
        char last = '0';
        for (char c : arr) {
            if (c != last) {
                res++;
                last = c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            
        }
    }
}
