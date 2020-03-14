package com.lzhlyle.leetcode.week.no1103;

public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0, next = 1;
        while (candies > next) {
            res[i++ % num_people] += next;
            candies -= next++;
        }
        res[i % num_people] += candies;
        return res;
    }
}
