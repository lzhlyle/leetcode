package com.lzhlyle.contest.weekly.weekly200;

public class Contest1 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int cnt = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a)
                        if (Math.abs(arr[j] - arr[k]) <= b)
                            if (Math.abs(arr[i] - arr[k]) <= c)
                                cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
