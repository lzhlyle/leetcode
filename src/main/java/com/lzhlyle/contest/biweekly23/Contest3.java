package com.lzhlyle.contest.biweekly23;

public class Contest3 {
    // wrong
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double x0 = x2 - ((x2 - x1) * 1.0 / 2), y0 = y2 - ((y2 - y1) * 1.0 / 2);
        if (y0 == y_center) return Math.abs(x_center - x0) <= radius + (x0 - x1);
        if (x0 == x_center) return Math.abs(y_center - y0) <= radius + (y0 - y1);

        double sqrtR = pow(radius);
        double delX = Math.abs(x_center - x0);
        double delY = Math.abs(y_center - y0);
        double sqrtL = pow(delX) + pow(delY);

        double sqrtY = sqrtR * pow(delY) * 1.0d / sqrtL;
        double sqrtX = sqrtR * pow(delX) * 1.0d / sqrtL;
        double genY = gen(sqrtY);
        double genX = gen(sqrtX);

        double x = x0 > x_center ? x_center + genX : x_center - genX;
        double y = y0 > y_center ? y_center + genY : y_center - genY;
        return x1 <= x && x <= x2 && y1 <= y && y <= y2;
    }

    private double pow(double n) {
        return n * n;
    }

    private double gen(double n) {
        double l = 0, r = (n / 2) + 3;
        while (l < r) {
            double mid = l + (r - l + 1) / 2;
            if (mid * mid > n) r = mid - 0.5;
            else l = mid + 0.5;
        }
        return l;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1;
            boolean res = contest.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2);
            System.out.println(res);
        }
    }
}
