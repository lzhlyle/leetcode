package com.lzhlyle.leetcode.recite.no493;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int mid = l + ((r - l) >> 1);
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        int[] cache = new int[r - l + 1]; // 结果数组
        int i = l, t = l, c = 0; // 左数组指针，右数组指针，结果数组指针
        for (int j = mid + 1; j <= r; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long) nums[j]) i++;

            // 进行归并
            while (t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];

            count += mid - i + 1; // 更新统计数
        }
        while (t <= mid) cache[c++] = nums[t++]; // 剩余合并
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 5, 1};
        int res = new ReversePairs().reversePairs(nums);
        System.out.println(res);
    }
}
