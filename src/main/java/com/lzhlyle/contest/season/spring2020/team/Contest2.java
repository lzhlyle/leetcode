package com.lzhlyle.contest.season.spring2020.team;

public class Contest2 {
    public int minTime(int[] time, int m) {
        if (time.length < m) return 0;

        int sum = 0;
        for (int t : time) sum += t;

        // 每组时间[l, r]
        int l = 0, r = sum;
        while (l < r) {
            int mid = l + ((r - l) >> 1); // 假设每组时间上限 mid
            int cnt = 1, curr = 0, groupMax = 0;
            for (int t : time) {
                groupMax = Math.max(groupMax, t);
                curr += t; // 试着自己做
                if (curr - groupMax > mid) {
                    // 新开一组
                    cnt++;
                    groupMax = curr = t;
                }
            }

            if (cnt > m) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] arr = new int[]{1, 2, 3, 3};
            int res = contest.minTime(arr, 2);
            System.out.println(res);
        }
    }
}
