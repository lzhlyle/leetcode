package com.lzhlyle.contest.weekly.weekly189;

public class Contest1 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0, n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {
            
        }
    }
}
