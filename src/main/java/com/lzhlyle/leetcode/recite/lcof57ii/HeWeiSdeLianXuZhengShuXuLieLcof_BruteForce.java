package com.lzhlyle.leetcode.recite.lcof57ii;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof_BruteForce {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = (target + 1) / 2; i > 0; i--) {
            List<Integer> list = new LinkedList<>();
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += j;
                list.add(j);
                if (sum > target) break;
                if (sum == target) {
                    Collections.reverse(list);
                    res.add(list);
                    break;
                }
            }
        }
        int[][] result = new int[res.size()][];
        Collections.reverse(res);
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i).stream().mapToInt(n -> n).toArray();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] res = new HeWeiSdeLianXuZhengShuXuLieLcof_BruteForce().findContinuousSequence(9);
        for (int[] ints : res) System.out.println(Arrays.toString(ints));
    }
}
