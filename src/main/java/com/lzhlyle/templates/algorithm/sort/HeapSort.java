package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        // 建立大顶堆 - 通过数组维护
        int length = arr.length;
        // 只需比较一半，heapify中已同时比较左右
        // 堆底 length / 2 - 1
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        // 将堆顶取出，并换到最后
        for (int i = length - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    /**
     * 堆化，调整堆
     *
     * @param arr    用来维护堆的数组
     * @param length 数组中未排序的长度，保证寻找子集时不超出堆范围
     * @param top    堆顶元素在数组中的索引
     */
    private static void heapify(int[] arr, int length, int top) {
        int left = 2 * top + 1, right = 2 * top + 2;
        int largest = top;

        // 同时比较左右
        // largest = max(arr[top], arr[left], arr[right]);
        if (left < length && arr[left] > arr[largest]) largest = left;
        if (right < length && arr[right] > arr[largest]) largest = right;

        // terminator
        // 当前层，堆顶已经最大
        if (largest == top) return;

        // process
        int swap = arr[top];
        arr[top] = arr[largest];
        arr[largest] = swap;

        // drill down
        heapify(arr, length, largest);
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0, 9, 5};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
