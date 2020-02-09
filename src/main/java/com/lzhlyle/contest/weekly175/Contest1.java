package com.lzhlyle.contest.weekly175;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
 *
 * 5332. 检查整数及其两倍数是否存在
 */

public class Contest1 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (set.contains(value)) return true;
            set.add(value * 2);
        }
        set.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) return true;
            set.add(arr[i] * 2);
        }
        return false;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        // [4,-7,11,4,18]
        {
            int[] arr = new int[]{4, -7, 11, 4, 18};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        // [-10,12,-20,-8,15]
        {
            int[] arr = new int[]{-10, 12, -20, -8, 15};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        {
            int[] arr = new int[]{10, 2, 5, 3};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        {
            int[] arr = new int[]{7, 1, 14, 11};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        {
            int[] arr = new int[]{3, 1, 7, 11};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        {
            int[] arr = new int[]{0};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
        {
            int[] arr = new int[]{1};
            boolean res = contest.checkIfExist(arr);
            System.out.println(res);
        }
    }
}
