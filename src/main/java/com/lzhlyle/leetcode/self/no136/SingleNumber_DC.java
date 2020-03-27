package com.lzhlyle.leetcode.self.no136;

public class SingleNumber_DC {
    public int singleNumber(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l >= r) return nums[r];
        int p = partition(nums, l, r);
        if ((p - l) % 2 == 1) return search(nums, l, p - 1);
        for (int i = p + 1; i < r + 1; i++) {
            if (nums[p] == nums[i]) {
                int swap = nums[i];
                nums[i] = nums[p + 1];
                nums[p + 1] = swap;
                break;
            }
        }
        if (nums[p] != nums[p + 1]) return nums[p];
        return search(nums, p + 2, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = r, counter = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[i];
                arr[i] = arr[counter];
                arr[counter++] = swap;
            }
        }
        int swap = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = swap;
        return counter;
    }
}
