package com.lzhlyle.contest.weekly177;

import java.util.Arrays;

public class Contest3_2 {

    public int[] closestDivisors(int num) {
        if (num == 1) return new int[]{1, 2};
        if (num == 2) return new int[]{2, 2};

        int left, right;
        left = right = (num + 2) >> 1;
        while (left >= 1 && right <= num + 2) {
            long multi = left * right;
            if (multi == num + 1 || multi == num + 2) return new int[]{left, right};

            if (multi > num + 2) left--;
            else if (multi < num + 1) right++;
        }

        return new int[2];
    }

    public static void main(String[] args) {
//        {
//            Contest3_2 contest = new Contest3_2();
//            int[] res = contest.closestDivisors(688427155);
//            System.out.println(Arrays.toString(res));
//        }
        {
            Contest3_2 contest = new Contest3_2();
            int[] res = contest.closestDivisors(8);
            System.out.println(Arrays.toString(res));
        }
        {
            Contest3_2 contest = new Contest3_2();
            int[] res = contest.closestDivisors(123);
            System.out.println(Arrays.toString(res));
        }
        {
            Contest3_2 contest = new Contest3_2();
            int[] res = contest.closestDivisors(999);
            System.out.println(Arrays.toString(res));
        }
    }
}
