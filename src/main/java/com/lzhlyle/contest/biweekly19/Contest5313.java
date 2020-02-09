package com.lzhlyle.contest.biweekly19;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/angle-between-hands-of-a-clock/
 *
 * 5313. 时钟指针的夹角
 *
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 *
 * 提示：
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 *
 */

public class Contest5313 {
    public double angleClock(int hour, int minutes) {
        if (hour >= 12) hour -= 12;
        double minAngle = (360 / 60) * minutes;
        double hourAngle = (360 * 1.0 / 12) * (hour + minutes * 1.0 / 60);
        double res = Math.abs(hourAngle - minAngle);
        return res < 180 ? res : 360 - res;
    }

    public static void main(String[] args) {
        Contest5313 contest3 = new Contest5313();
        {
            double res = contest3.angleClock(1, 57);
            System.out.println(res);
        }
        {
            double res = contest3.angleClock(12, 30);
            System.out.println(res);
        }
        {
            double res = contest3.angleClock(3, 30);
            System.out.println(res);
        }
        {
            double res = contest3.angleClock(3, 15);
            System.out.println(res);
        }
        {
            double res = contest3.angleClock(4, 50);
            System.out.println(res);
        }
        {
            double res = contest3.angleClock(12, 0);
            System.out.println(res);
        }
    }
}
