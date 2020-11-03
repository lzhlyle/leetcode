package com.lzhlyle.contest.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Huawei20201102 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        String[] params = scanner.nextLine().split(" ");
        String[] datas = scanner.nextLine().split(" ");

        int m = Integer.valueOf(params[0]), t = Integer.valueOf(params[1]), p = Integer.valueOf(params[2]);
        int[] arr = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            arr[i] = Integer.valueOf(datas[i]);
        }

        int res = filter(m, t, p, arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }

    private static int filter(int m, int t, int p, int[] arr) {
        Queue<Integer> mQueue = new LinkedList<>(); // 检测故障
        Queue<Integer> pQueue = new LinkedList<>(); // 故障恢复

        boolean state = true; // true:NORMAL, false:BAD
        Integer last = null;
        int i = 0;

        // 过滤开头错误值
        while (i < arr.length && !valid(arr[i], null)) {
            i++;
        }

        int cnt = 0, max = 0;
        for (; i < arr.length; i++) {
            if (state) {
                // 无故障
                if (valid(arr[i], last)) {
                    // 正常值
                    cnt++;
                } else {
                    // 错误值
                    mQueue.add(i); // add index
                    arr[i] = last; // 不可能为上一个还是错误值
                }

                // 判断是否故障
                if (mQueue.size() >= t) {
                    // 出现故障
                    state = false;
                    cnt += t - 1;
                    max = Math.max(max, cnt);
                    mQueue.clear();
                    cnt = 0;
                } else {
                    // 未故障
                    if (!mQueue.isEmpty() && mQueue.element() <= i - m + 1) {
                        mQueue.remove();
                        cnt++;
                    }
                }
            } else {
                // 故障期
                if (valid(arr[i], last)) {
                    // 正常值
                    pQueue.add(i);
                } else {
                    // 错误值
                    pQueue.clear(); // 要求故障期一直正常才能恢复
                }

                // 判断故障恢复
                if (pQueue.size() >= p) {
                    // 已恢复
                    state = true;
                    cnt = 1;
                    pQueue.clear();
                } else {
                    // 未恢复
                    if (!pQueue.isEmpty() && pQueue.element() <= i - p) {
                        pQueue.remove();
                    }
                }
            }
            last = arr[i];
        }
        cnt += mQueue.size();
        max = Math.max(max, cnt);
        return max;
    }

    private static boolean valid(int val, Integer last) {
        if (val <= 0) return false;
        if (last != null) {
            if (val < last) return false;
            if (val - last >= 10) return false;
        }
        return true;
    }
}
