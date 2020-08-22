package com.lzhlyle.leetcode.self.no679;

import java.util.ArrayList;
import java.util.List;

public class Game24_LC {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int v : nums) list.add((double) v);
        return judge(list);
    }

    private boolean judge(List<Double> list) {
        if (list.size() == 1) return Math.abs(list.get(0) - 24) < 0.001;
        List<Double> next = new ArrayList<>(list);
        for (int i = 0; i < list.size() - 1; i++) {
            next.remove(list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                next.remove(list.get(j));
                for (Double v : getCalcValues(list.get(i), list.get(j))) {
                    next.add(v);
                    if (judge(next)) return true;
                    next.remove(v);
                }
                next.add(list.get(j));
            }
            next.add(list.get(i));
        }
        return false;
    }

    private List<Double> getCalcValues(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(Math.abs(a - b));
        res.add(a * b);
        if (b != 0) res.add(a / b);
        if (a != 0) res.add(b / a);
        return res;
    }
}
