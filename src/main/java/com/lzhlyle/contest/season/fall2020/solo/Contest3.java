package com.lzhlyle.contest.season.fall2020.solo;

public class Contest3 {
    public int minimumOperations(String leaves) {
        char[] arr = leaves.toCharArray();
        int n = arr.length;

        int[][] dp = new int[n][3];

        dp[0][0] = arr[0] == 'r' ? 0 : 1;
        for (int i = 1; i < n - 2; i++) {
            dp[i][0] = (arr[i] == 'r' ? 0 : 1)
                    + dp[i - 1][0];
        }

        dp[1][1] = (arr[1] == 'y' ? 0 : 1) + dp[0][0];
        for (int i = 2; i < n - 1; i++) {
            dp[i][1] = (arr[i] == 'y' ? 0 : 1)
                    + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        dp[2][2] = (arr[2] == 'r' ? 0 : 1) + dp[1][1];
        for (int i = 3; i < n; i++) {
            dp[i][2] = (arr[i] == 'r' ? 0 : 1)
                    + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }

        return dp[n - 1][2];
    }

//    // wa
//    // "ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy"
//    public int minimumOperations(String leaves) {
//        char[] arr = leaves.toCharArray();
//        int n = arr.length;
//        int cnt = 0;
//        cnt += arr[0] == 'r' ? 0 : 1;
//        cnt += arr[n - 1] == 'r' ? 0 : 1;
//
//        arr[0] = arr[n - 1] = 'r';
//
//        // System.out.println(cnt);
//
//        int l = 1, r = n - 2;
//        while (l <= r && arr[l] == 'r') l++;
//        while (r >= l && arr[r] == 'r') r--;
//
//        if (l == r) {
//            if (arr[l] == 'r') return cnt + 1;
//            else return cnt;
//        }
//
//        // System.out.println("l: " + l + ", r: " + r);
//
//        // 求最长连续 'y'
//        int rCnt = 0, yCnt = 0, len = 1, max = 0;
//        for (int i = l; i <= r; i++) {
//            if (arr[i] == 'r') rCnt++;
//            else {
//                yCnt++;
//                if (i > l && arr[i - 1] == 'y') len++;
//                else len = 1;
//                max = Math.max(max, len);
//            }
//        }
//        max = Math.max(max, len);
//        // System.out.println("rCnt: " + rCnt + ", yCnt: " + yCnt + ", max: " + max);
//
//        if (yCnt == 0) return cnt + 1;
//        return cnt + Math.min(rCnt, yCnt - max);
//    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
