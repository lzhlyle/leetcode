package com.lzhlyle.contest.weekly.weekly179;

public class Contest2 {
    public int numTimesAllBlue(int[] light) {
        int count = 0, l = light[0], r = light[0];
        boolean first = false;
        if (l == 1) {
            count++;
            first = true;
        }
        for (int i = 1; i < light.length; i++) {
            int num = light[i];
            if (!first) first = num == 1;
            l = Math.min(l, num);
            r = Math.max(r, num);
            if (r - l + 1 == i + 1 && first) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] light = {2, 1, 3, 5, 4};
            int res = contest.numTimesAllBlue(light);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            int[] light = {3, 2, 4, 1, 5};
            int res = contest.numTimesAllBlue(light);
            System.out.println(res);
            System.out.println(res == 2);
        }
        {
            int[] light = {4, 1, 2, 3};
            int res = contest.numTimesAllBlue(light);
            System.out.println(res);
            System.out.println(res == 1);
        }
        {
            int[] light = {2, 1, 4, 3, 6, 5};
            int res = contest.numTimesAllBlue(light);
            System.out.println(res);
            System.out.println(res == 3);
        }
        {
            int[] light = {1, 2, 3, 4, 5, 6};
            int res = contest.numTimesAllBlue(light);
            System.out.println(res);
            System.out.println(res == 6);
        }
    }
}
