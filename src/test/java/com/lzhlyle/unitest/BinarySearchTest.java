package com.lzhlyle.unitest;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    // 查找第一个值等于给定值的元素

    @Test
    public void firstEquals_Exist_Mid() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 4;
        int exp = 4; // index

        int res = firstEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstEquals_Exist_Last() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 7;
        int exp = 10; // index

        int res = firstEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstEquals_Exist_First() {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 1;
        int exp = 0; // index

        int res = firstEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstEquals_NotExist() {
        int[] arr = {1, 2, 3, 3, 5, 5, 6, 7};
        int target = 4;
        int exp = -1; // index

        int res = firstEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    private int firstEquals(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) l = mid + 1;
            else r = mid; // 收缩右边界不影响 first equals
        }
        if (arr[l] == target && (l == 0 || arr[l - 1] < target)) return l;
        return -1;
    }

    // 查找最后一个值等于给定值的元素

    @Test
    public void lastEquals_Exist_Mid() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 4;
        int exp = 6; // index

        int res = lastEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastEquals_Exist_Last() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 7};
        int target = 7;
        int exp = 11; // index

        int res = lastEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastEquals_Exist_First() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 1;
        int exp = 0; // index

        int res = lastEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastEquals_NotExist() {
        int[] arr = {1, 2, 3, 3, 5, 5, 6, 7};
        int target = 4;
        int exp = -1; // index

        int res = lastEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    private int lastEquals(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (arr[mid] > target) r = mid - 1;
            else l = mid; // 收缩左边界不影响 last equals
        }
        if (arr[l] == target && (l == arr.length - 1 || arr[l + 1] > target)) return l;
        return -1;
    }

    // 查找第一个大于等于给定值的元素

    @Test
    public void firstLargerOrEquals_Exist_Mid() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 5;
        int exp = 7; // index

        int res = firstLargerOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstLargerOrEquals_Exist_Last() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 7;
        int exp = 10; // index

        int res = firstLargerOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstLargerOrEquals_Exist_First() {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 0;
        int exp = 0; // index

        int res = firstLargerOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void firstLargerOrEquals_NotExist() {
        int[] arr = {1, 2, 3, 3, 5, 5, 6, 7};
        int target = 8;
        int exp = -1; // index

        int res = firstLargerOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    private int firstLargerOrEquals(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) l = mid + 1;
            else r = mid; // 收缩右边界不影响 first equals
        }
        if (arr[l] >= target && (l == 0 || arr[l - 1] < target)) return l;
        return -1;
    }

    // 查找最后一个小于等于给定值的元素

    @Test
    public void lastLessOrEquals_Exist_Mid() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 3;
        int exp = 3; // index

        int res = lastLessOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastLessOrEquals_Exist_Last() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 7};
        int target = 8;
        int exp = 11; // index

        int res = lastLessOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastLessOrEquals_Exist_First() {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7};
        int target = 1;
        int exp = 0; // index

        int res = lastLessOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    @Test
    public void lastLessOrEquals_NotExist() {
        int[] arr = {1, 2, 3, 3, 5, 5, 6, 7};
        int target = 0;
        int exp = -1; // index

        int res = lastLessOrEquals(arr, target);
        Assert.assertEquals(exp, res);
    }

    private int lastLessOrEquals(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (arr[mid] > target) r = mid - 1;
            else l = mid; // 收缩左边界不影响 last equals
        }
        if (arr[l] <= target && (l == arr.length - 1 || arr[l + 1] > target)) return l;
        return -1;
    }
}
