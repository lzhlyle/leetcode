package com.lzhlyle.leetcode.self.no1103;

public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 0, next = 1;
        while (candies > next) {
            i %= num_people;
            res[i++] += next;
            candies -= next++;
        }
        res[i % num_people] += candies;
        return res;
    }
}
