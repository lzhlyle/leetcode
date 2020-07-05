package com.lzhlyle.contest.weekly.weekly196;

public class Contest2_LC {
    // 相当于未转身继续走
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxl = left.length == 0 ? 0 : left[0];
        int minr = right.length == 0 ? n : right[0];
        for (int l : left)
            maxl = Math.max(maxl, l);
        for (int r : right)
            minr = Math.min(minr, r);
        return Math.max(maxl, n - minr);
    }

    public static void main(String[] args) {
        Contest2_LC contest = new Contest2_LC();
        {

        }
    }
}
