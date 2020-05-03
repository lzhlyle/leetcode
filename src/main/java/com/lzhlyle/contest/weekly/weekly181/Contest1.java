package com.lzhlyle.contest.weekly.weekly181;

import java.util.ArrayList;
import java.util.List;

public class Contest1 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {

        }
    }
}
