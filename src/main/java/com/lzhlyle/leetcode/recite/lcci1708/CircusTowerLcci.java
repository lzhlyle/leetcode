package com.lzhlyle.leetcode.recite.lcci1708;

import java.util.Arrays;

public class CircusTowerLcci {
    // sort + lis
    // dp + bs
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] people = new int[len][2];
        for (int i = 0; i < len; i++) {
            people[i][0] = height[i];
            people[i][1] = weight[i];
        }
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] groups = new int[len];
        int cnt = 0;
        for (int[] p : people) {
            int i = bs(groups, p[1], 0, cnt);
            groups[i] = p[1];
            if (i == cnt) cnt++;
        }
        return cnt;
    }

    // binary search: first larger than
    private int bs(int[] arr, int target, int l, int r) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
