package com.lzhlyle.contest.biweekly.biweekly29;

public class Contest1 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int v : salary) {
            min = Math.min(min, v);
            max = Math.max(max, v);
            sum += v;
        }
        return (sum - min - max) * 1.0 / (salary.length - 2);
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
