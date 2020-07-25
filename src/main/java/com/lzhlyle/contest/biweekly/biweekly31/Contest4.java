package com.lzhlyle.contest.biweekly.biweekly31;

public class Contest4 {
    public int minNumberOperations(int[] arr) {
        int cnt = arr[0], n = arr.length;
        for (int i = 1; i < n - 1; i++)
            if (arr[i] > arr[i - 1])
                cnt += arr[i] - arr[i - 1];
        if (arr[n - 1] > arr[n - 2])
            cnt += arr[n - 1] - arr[n - 2];
        return cnt;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
