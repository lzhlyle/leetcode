package com.lzhlyle.contest.biweekly24;

import java.util.ArrayList;
import java.util.List;

public class Contest2 {
    public int findMinFibonacciNumbers(int k) {
        if (k == 1) return 1;
        int[] arr = _fib(k);
        int len = arr.length, res = k, cnt = 0;
        while (res > 0) {
            cnt++;
            int l = 0, r = len - 1;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);
                if (arr[mid] > res) r = mid - 1;
                else l = mid;
            }
            res -= arr[l];
        }
        return cnt;
    }

    private int[] _fib(int n) {
        List<Integer> list = new ArrayList<>();
        int a = 1, b = 1;
        list.add(a);
        list.add(b);
        for (int i = 2; b < n; i++) {
            b = b + a;
            a = b - a;
            list.add(b);
        }
        int[] res = new int[list.size()];
        int ri = 0;
        for (Integer num : list) {
            res[ri++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int res = contest.findMinFibonacciNumbers(13);
            System.out.println(res);
        }
    }
}
