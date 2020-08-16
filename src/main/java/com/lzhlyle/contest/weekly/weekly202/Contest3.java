package com.lzhlyle.contest.weekly.weekly202;

import java.util.Arrays;

public class Contest3 {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int l = 1, r = arr[arr.length - 1] - arr[0];
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // 相距至少 mid，看是否可放下 m 个
            int cnt = 1;
            for (int i = 1, last = arr[0]; i < arr.length; i++) {
                if (arr[i] - last < mid) continue; // 太小不能放

                // 可放
                cnt++;
                last = arr[i];
            }
            // System.out.println(l + ", " + r + ", " + mid + ", cnt: " + cnt);
            // cnt 与 m 比较，调整 mid 取值区间
            if (cnt < m) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            
        }
    }
}
