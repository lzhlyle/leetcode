package com.lzhlyle.contest.weekly.weekly176;

import java.util.Arrays;

public class Contest4 {
    public boolean isPossible(int[] target) {
        Arrays.sort(target);
        int len = target.length;
        if (target[len - 1] == 1) return true;
        if (target[len - 1] < len) return false;

        int otherSum = 0;
        for (int i = 0; i < len - 1; i++) {
            otherSum += target[i];
            if (target[len - 1] < otherSum) return false;
        }
        if ((target[len - 1] -= otherSum) == 0) return false;
        return isPossible(target);
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
