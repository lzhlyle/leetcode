package com.lzhlyle.leetcode.recite.lcof62;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof_Josephhus {
    public int lastRemaining(int n, int m) {
        int index = 0;
        for (int cnt = 1; cnt <= n; cnt++) {
            index = (index + m) % cnt;
        }
        return index;
    }
}
