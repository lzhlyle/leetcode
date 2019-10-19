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

import java.util.*;

public class ThreeSum_3 {
//    public static void main(String[] args) {
//        new ThreeSum_3().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            do {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    String setStr = nums[i] + "," + nums[left] + "," + nums[right];
                    if (!set.contains(setStr)) {
                        set.add(setStr);
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            } while (left < right);
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

