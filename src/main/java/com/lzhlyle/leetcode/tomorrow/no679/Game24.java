package com.lzhlyle.leetcode.tomorrow.no679;

import java.util.ArrayList;
import java.util.List;

public class Game24 {
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
                for (int op = 0; op < 6; op++) {
                    double v = oper(list.get(i), list.get(j), op);
                    if (v < 0) continue;
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

    private double oper(double a, double b, int op) {
        if (op == 0) return a + b;
        if (op == 1) return a - b;
        if (op == 2) return b - a;
        if (op == 3) return a * b;
        if (op == 4 && b != 0) return a / b;
        if (op == 5 && a != 0) return b / a;
        return -1;
    }
}
