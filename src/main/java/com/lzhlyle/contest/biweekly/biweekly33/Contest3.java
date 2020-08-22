package com.lzhlyle.contest.biweekly.biweekly33;

public class Contest3 {
    // O(nlog(max))
    // T(n) = T(n/2) + O(n)
    // 指定数 +1 或 所有数翻倍
    // 即：指定数 -1 或 所有数减半
    public int minOperations(int[] nums) {
        int cnt = 0, zero = 0, move = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            else {
                cnt += nums[i] & 1;
                if (nums[i] > 1) {
                    nums[i] >>>= 1;
                    move = 1;
                } else nums[i] = 0;
            }
        }
        if (zero == nums.length) return 0;
        return cnt + move + minOperations(nums);
    }

    // O(32n)
//    public int minOperations(int[] nums) {
//        int cnt = 0, max = nums[0];
//        // 共多少个 1
//        for (int v : nums) {
//            max = Math.max(max, v);
//            while (v != 0) {
//                cnt++;
//                v &= v - 1;
//            }
//        }
//        // 最大多少位
//        while (max != 0) {
//            cnt++;
//            max >>>= 1;
//        }
//        return cnt - 1;
//    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            
        }
    }
}
