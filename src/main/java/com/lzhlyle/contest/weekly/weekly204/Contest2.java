package com.lzhlyle.contest.weekly.weekly204;

public class Contest2 {
    // 不含 0：以 0 间隔，偶数个负数
    public int getMaxLen(int[] nums) {
        int max = 0, len = 0, negCnt = 0, first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                len++;
            } else if (nums[i] < 0) {
                if (first == -1) first = last = i;
                else last = i;
                negCnt++;
                len++;
            } else {
                int curr = len;
                if ((negCnt & 1) != 0)
                    curr = Math.max(i - 1 - first, len - (i - 1 - last + 1));
                max = Math.max(max, curr);

                len = 0;
                negCnt = 0;
                first = last = -1;
            }
        }
        int curr = len;
        if ((negCnt & 1) != 0)
            curr = Math.max(nums.length - 1 - first, len - (nums.length - 1 - last + 1));
        max = Math.max(max, curr);
        return max;
    }

    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {

        }
    }
}
