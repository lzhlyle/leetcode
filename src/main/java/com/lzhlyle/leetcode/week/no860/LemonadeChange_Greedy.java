package com.lzhlyle.leetcode.week.no860;

public class LemonadeChange_Greedy {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five-- == 0) return false;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten == 0 && five > 2) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
