package com.lzhlyle.leetcode.self.no887;

public class SuperEggDrop_DP_LC_Adv {
    /**
     * 思路：
     * 本题应该逆向思维，若你有 K 个鸡蛋，你最多操作 F 次，求 N 最大值。
     * <p>
     * dp[k][f] = dp[k][f-1] + dp[k-1][f-1] + 1;
     * 解释：
     * 0.dp[k][f]：如果你还剩 k 个蛋，且只能操作 f 次了，所能确定的楼层。
     * 1.dp[k][f-1]：蛋没碎，因此该部分决定了所操作楼层的上面所能容纳的楼层最大值
     * 2.dp[k-1][f-1]：蛋碎了，因此该部分决定了所操作楼层的下面所能容纳的楼层最大值
     * 又因为第 f 次操作结果只和第 f-1 次操作结果相关，因此可以只用一维数组。
     * <p>
     * 时复：O(K*log(N))
     */
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int f = 0;
        while (dp[K] < N) {
            f++;
            int northwest = dp[0];
            for (int k = 1; k < K + 1; k++) {
                int next = dp[k];
                dp[k] += northwest + 1;
                northwest = next;
            }
        }
        return f;
    }
}
