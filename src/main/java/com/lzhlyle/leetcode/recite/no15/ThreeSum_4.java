package com.lzhlyle.leetcode.recite.no15;

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_4 {
//    public static void main(String[] args) {
//        new ThreeSum_4().threeSum(new int[]{-2, 0, 0, 2, 2});
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        // no Set

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // 优化
            if (nums[i] > 0) continue;
            if (nums[right] < 0) continue;
            // 对i去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 对left, right去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

