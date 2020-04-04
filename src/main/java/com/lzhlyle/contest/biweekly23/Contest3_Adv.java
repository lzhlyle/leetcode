package com.lzhlyle.contest.biweekly23;

public class Contest3_Adv {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if (x1 <= x_center && x_center <= x2 && y1 <= y_center && y_center <= y2) return true;
        if (x_center > x2 && y1 <= y_center && y_center <= y2) return radius >= x_center - x2; // 上
        if (y_center < y1 && x1 <= x_center && x_center <= x2) return radius >= y1 - y_center; // 下
        if (x_center < x1 && y1 <= y_center && y_center <= y2) return radius >= x1 - x_center; // 左
        if (y_center > y2 && x1 <= x_center && x_center <= x2) return radius >= y_center - y2; // 右
        return inRadius(radius, x_center, y_center, x1, y1) ||
                inRadius(radius, x_center, y_center, x1, y2) ||
                inRadius(radius, x_center, y_center, x2, y1) ||
                inRadius(radius, x_center, y_center, x2, y2);
    }

    private boolean inRadius(int radius, int x_center, int y_center, int x, int y) {
        return pow(radius) >= pow(x_center - x) + pow(y_center - y);
    }

    private double pow(double n) {
        return n * n;
    }
}
