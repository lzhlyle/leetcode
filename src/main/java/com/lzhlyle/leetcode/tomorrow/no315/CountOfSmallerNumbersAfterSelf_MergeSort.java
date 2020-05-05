package com.lzhlyle.leetcode.tomorrow.no315;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_MergeSort {
    public List<Integer> countSmaller(int[] nums) {
        // 转型
        int n = nums.length;
        Ele[] arr = new Ele[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Ele(nums[i], i);
        }

        // 归并
        mergeSort(arr, 0, n - 1);

        // 输出
        Integer[] res = new Integer[n];
        for (Ele e : arr) {
            res[e.index] = e.cnt;
        }
        return Arrays.asList(res);
    }

    private void mergeSort(Ele[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(Ele[] arr, int l, int mid, int r) {
        Ele[] temp = new Ele[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        // counting without merging
        while (i <= mid && j <= r) {
            if (arr[i].val <= arr[j].val) {
                arr[i].cnt += j - mid - 1; // meet the larger one
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }

        while (i <= mid) {
            arr[i].cnt += j - mid - 1; // 补充剩下的
            temp[k++] = arr[i++];
        }
        while (j <= r) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, l, r - l + 1);
    }

    class Ele {
        int val, index, cnt;

        Ele(int val, int index) {
            this.val = val;
            this.index = index;
            cnt = 0;
        }
    }
}
