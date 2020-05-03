package com.lzhlyle.contest.biweekly.biweekly25;

public class Contest2 {
    public int maxDiff(int num) {
        int a = toMax(num), b = toMin(num);
        System.out.println(a + ", " + b);
        return a - b;
    }

    private int toMin(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        char from = arr[0], to = '1';
        // 若第一个数不为1，则第一个数改为1
        if (arr[0] == '1') {
            // 若第一个数为1，则找第一个非0的数
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != '1' && arr[i] != '0') {
                    from = arr[i];
                    to = '0';
                    break;
                }
            }
        }

        // 改数字
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == from) arr[i] = to;
        }
        return Integer.valueOf(new String(arr));
    }

    private int toMax(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        char from = arr[0], to = '9';
        // 找第一个非9的数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '9') {
                from = arr[i];
                to = '9';
                break;
            }
        }

        // 改数字
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == from) arr[i] = to;
        }
        return Integer.valueOf(new String(arr));
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int res = contest.maxDiff(1101057);
            System.out.println(res);
        }
    }
}
