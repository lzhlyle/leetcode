package com.lzhlyle.contest.biweekly22;

public class Contest4_BT {
    private int max = 0, len;

    // wrong
    public int maxSizeSlices(int[] slices) {
        len = slices.length;
        for (int i = 0; i < len; i++) {
            bt(0, slices, i, 0);
        }
        return max;
    }

    private void bt(int cnt, int[] arr, int i, int curr) {
        if (cnt + 1 == (len / 3)) {
            if (curr > max) max = curr;
            return;
        }
        if (arr[i % len] != 0) {
            int mine = arr[i % len], a, ai = i, b, bi = i;
            while (arr[(ai + 1) % len] == 0) ai++;
            a = arr[(ai + 1) % len];
            while (arr[(bi - 1 + len) % len] == 0) bi--;
            b = arr[(bi - 1 + len) % len];

            arr[i % len] = 0;
            arr[(ai + 1) % len] = 0;
            arr[(bi - 1 + len) % len] = 0;
            bt(cnt + 1, arr, i + 1, curr + mine); // select

            // back tracking
            arr[i % len] = mine;
            arr[(ai + 1) % len] = a;
            arr[(bi - 1 + len) % len] = b;
        }
        bt(cnt + 1, arr, i + 1, curr); // un-select
    }

    public static void main(String[] args) {
        Contest4_BT contest = new Contest4_BT();
        {
            int[] arr = {10, 1, 1, 2, 1, 10, 3, 10, 2, 8, 4, 10, 8, 8, 2, 9, 9, 9, 10, 10, 7, 6, 5, 6, 3, 8, 2, 6, 8, 10};
            int res = contest.maxSizeSlices(arr);
            System.out.println(res);
        }
    }
}
