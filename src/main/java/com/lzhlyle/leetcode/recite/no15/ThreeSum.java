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
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);

                        // check duplicate
                        l.sort(Integer::compare);
                        Integer[] arr = l.toArray(new Integer[0]);
                        String str = Arrays.toString(arr);
                        if (!set.contains(str)) {
                            set.add(str);
                            list.add(l);
                        }
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

