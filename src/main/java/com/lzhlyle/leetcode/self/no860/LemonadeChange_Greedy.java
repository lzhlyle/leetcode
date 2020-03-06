package com.lzhlyle.leetcode.self.no860;

public class LemonadeChange_Greedy {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) ++five;
            else if (b == 10) {
                if (five-- < 1) return false;
                ++ten;
            } else {
                if (ten > 0 && five > 0) {
                    --ten;
                    --five;
                } else if (five > 2) five -= 3;
                else return false;
            }
        }
        return true;
    }
}
