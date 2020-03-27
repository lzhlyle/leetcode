package com.lzhlyle.leetcode.recite.no136;

public class SingleNumber_DC {
    public int singleNumber(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    // T(n) = T(n/2) + O(n) + O(n/2)
    private int search(int[] arr, int l, int r) {
        // base case
        if (l >= r) return arr[r];
        // O(n) 快排分区
        int p = quickPartition(arr, l, r);

        // T(n/2) 若左侧奇数，则肯定在左侧，递归搜左侧
        if ((p - l) % 2 == 1) return search(arr, l, p - 1);

        // O(n/2) 相同的一定在右侧
        for (int i = p + 1; i < r + 1; i++) {
            if (arr[i] == arr[p]) {
                // 换到p旁边，下次搜右侧时可排除
                int swap = arr[i];
                arr[i] = arr[p + 1];
                arr[p + 1] = swap;
                break;
            }
        }
        // lucky，右侧没有相同的
        if (p + 1 > r || arr[p] != arr[p + 1]) return arr[p];

        // T(n/2) unlucky, 右侧有相同的，递归搜右侧
        return search(arr, p + 2, r); // p + 2 排除了 arr[p], arr[p+1]
    }

    // 分区，同快速排序的分区
    private int quickPartition(int[] arr, int l, int r) {
        int pivot = r, counter = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[pivot]) { // 小的都在左侧，相等的在右侧
                int swap = arr[i];
                arr[i] = arr[counter];
                arr[counter++] = swap;
            }
        }
        int swap = arr[counter];
        arr[counter] = arr[pivot];
        arr[pivot] = swap;
        return counter;
    }
}
