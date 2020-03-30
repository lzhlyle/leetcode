package com.lzhlyle.leetcode.recite.lcof62;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof_List {
    public int lastRemaining(int n, int m) {
        List<Integer> list = Stream.iterate(0, i -> i + 1).limit(n).collect(Collectors.toList());
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
