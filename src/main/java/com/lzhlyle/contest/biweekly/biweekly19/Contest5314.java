package com.lzhlyle.contest.biweekly.biweekly19;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-19/problems/jump-game-iv/
 * <p>
 * 5314. 跳跃游戏 IV
 * <p>
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标：
 * <p>
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 * <p>
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * 示例 4：
 * <p>
 * 输入：arr = [6,1,9]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 */
public class Contest5314 {
    // bfs
    public int minJumps(int[] arr) {
        int len = arr.length;
        Map<Integer, Set<Integer>> sameNumMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!sameNumMap.containsKey(arr[i])) sameNumMap.put(arr[i], new HashSet<>());
            sameNumMap.get(arr[i]).add(i);
        }

        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        Queue<Integer> queue = new LinkedList<>(Collections.singleton(0));
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            Set<Integer> sameNumIndexes = sameNumMap.get(arr[curr]);
            for (int i : sameNumIndexes) {
                if (dp[i] == -1) {
                    dp[i] = dp[curr] + 1;
                    queue.add(i);
                }
            }
            sameNumMap.put(arr[curr], Collections.emptySet()); // 已经找过，无需再找

            // calc prev
            if (curr - 1 >= 0 && dp[curr - 1] == -1) {
                dp[curr - 1] = dp[curr] + 1;
                queue.add(curr - 1);
            }

            // calc next
            if (curr + 1 < len && dp[curr + 1] == -1) {
                dp[curr + 1] = dp[curr] + 1;
                queue.add(curr + 1);
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        Contest5314 contest4 = new Contest5314();
        {
            int res = contest4.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
            System.out.println(res);
        }
        {
            int res = contest4.minJumps(new int[]{7});
            System.out.println(res);
        }
        {
            int res = contest4.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7});
            System.out.println(res);
        }
        {
            int res = contest4.minJumps(new int[]{6, 1, 9});
            System.out.println(res);
        }
        {
            int res = contest4.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13});
            System.out.println(res);
        }
    }
}
