package com.lzhlyle.leetcode.recite.no860;

public class LemonadeChange_Greedy_Adv {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) ++five;
            else if (b == 10) {
                ++ten;
                --five;
            } else if (ten > 0) {
                --ten;
                --five;
            } else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}
