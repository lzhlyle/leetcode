package com.lzhlyle.contest.biweekly22;

public class Contest1 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int n1 : arr1) {
            boolean b = true;
            for (int n2 : arr2) {
                if (Math.abs(n1 - n2) <= d) {
                    b = false;
                    break;
                }
            }
            if (b) cnt++;
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
