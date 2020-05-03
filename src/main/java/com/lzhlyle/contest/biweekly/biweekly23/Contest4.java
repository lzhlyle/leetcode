package com.lzhlyle.contest.biweekly.biweekly23;

import java.util.Arrays;

public class Contest4 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int sum = 0, t = 1;
            for (int j = i; j < satisfaction.length; j++) {
                sum += t++ * satisfaction[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
