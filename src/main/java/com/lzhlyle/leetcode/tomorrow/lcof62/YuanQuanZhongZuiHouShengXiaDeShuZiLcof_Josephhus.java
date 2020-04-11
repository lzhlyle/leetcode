package com.lzhlyle.leetcode.tomorrow.lcof62;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof_Josephhus {
    public int lastRemaining(int n, int m) {
        int i = 0;
        for (int cnt = 2; cnt <= n; cnt++) {
            i = (i + m) % cnt;
        }
        return i;
    }
}
