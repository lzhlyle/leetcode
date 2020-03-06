package com.lzhlyle.leetcode.recite.no860;

public class LemonadeChange_Greedy {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) {
                ten++;
                if (five == 0) return false;
                five--;
            } else {
                twenty++;
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five > 2) five -= 3;
                else return false;
            }
        }
        return true;
    }
}
