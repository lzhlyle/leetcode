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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class ThreeSum_2 {
    public static void main(String[] args) {
        List<List<Integer>> output = new ThreeSum_2().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(output);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // two-sum: a + b = -c
            int target = nums[i] * -1;
            List<int[]> twoSum = this.twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), target);

            if (twoSum.size() <= 0) continue;

            for (int[] ints : twoSum) {
                // should remove duplicates
                list.add(Arrays.asList(nums[i], ints[0], ints[1]));
            }
        }
        return list;
    }

    /**
     * find two numbers
     *
     * @param nums
     * @param target
     * @return two numbers, not indexes
     */
    private List<int[]> twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                list.add(new int[]{target - nums[i], nums[i]});
            } else {
                map.put(nums[i], i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

