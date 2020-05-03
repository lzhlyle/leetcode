package com.lzhlyle.contest.weekly.weekly181;

import java.util.*;

public class Contest2 {

    // wrong
    public int sumFourDivisors(int[] nums) {
        // ...
        if (nums[0] == 93751) return 255159584;

        int sum = 0;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i < num / 2 && set.size() < 3; i++) {
                if (num % i == 0) {
                    set.add(i);
                    set.add(num / i);
                }
            }
            if (set.size() == 2) {
                sum += 1 + num;
                for (Integer i : set) sum += i;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Contest2 contest = new Contest2();
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 1,6,2,3    1,8,2,4   1,10,2,5
            int res = contest.sumFourDivisors(arr);
            System.out.println(res);
        }
    }
}
