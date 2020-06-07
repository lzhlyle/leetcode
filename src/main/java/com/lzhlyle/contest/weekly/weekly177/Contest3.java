package com.lzhlyle.contest.weekly.weekly177;

import java.util.Arrays;

public class Contest3 {

    public int[] closestDivisors(int num) {
        if (num == 1) return new int[]{1, 2};
        if (num == 2) return new int[]{2, 2};
//        if (num == 3) return new int[]{2, 2};
        // binary search
        int del = Integer.MAX_VALUE;
        int[] res = new int[2];

        int left = 1, right = num;
        while (left < right) {
            int i = left + ((right - left) >> 1);
            if ((num + 1) % i == 0 || (num + 2) % i == 0) {
                //
            }
        }

        for (int i = 1; i < num; i++) {
            int other = 0;
            if ((num + 1) % i == 0) {
                other = (num + 1) / i;
            }
            if ((num + 2) % i == 0) {
                int other2 = (num + 2) / i;
                if (other == 0) other = other2;
                else other = Math.abs(other - i) < Math.abs(other2 - i) ? other : other2;
            }
            if (other == 0) continue;
            int currDel = Math.abs(other - i);
            if (currDel < del) {
                del = currDel;
                res[0] = i;
                res[1] = other;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        {
            Contest3 contest = new Contest3();
            int[] res = contest.closestDivisors(688427155);
            System.out.println(Arrays.toString(res));
        }
//        {
//            BrowserHistory contest = new BrowserHistory();
//            int[] res = contest.closestDivisors(123);
//            System.out.println(Arrays.toString(res));
//        }
//        {
//            BrowserHistory contest = new BrowserHistory();
//            int[] res = contest.closestDivisors(999);
//            System.out.println(Arrays.toString(res));
//        }
    }
}
