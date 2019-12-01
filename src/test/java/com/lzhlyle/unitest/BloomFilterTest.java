package com.lzhlyle.unitest;

import com.lzhlyle.templates.algorithm.BloomFilter;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BloomFilterTest {
    private Random rd;
    private BloomFilter filter;

    @Before
    public void initial() {
        rd = new Random();
        filter = BloomFilter.getInstance();
    }

    @Test
    public void add_should_be_contained() {
        int i = 10000;
        while (i-- > 0) {
            filter.add(i);
            if (!filter.contains(i)) System.out.println("should be contained: " + i);
        }
        System.out.println();
    }

    @Test
    public void falsePositiveRateTest() {
        int numsCnt = 10000;
        int i = numsCnt;
        while (i-- > 0) filter.add(i);

        int testTimes = 10000;
        int falseCount = 0;
        while (testTimes-- > 0) {
            int num = rd.nextInt(numsCnt * 100);
            if (filter.contains(num) != num < numsCnt) {
                falseCount++;
                System.out.println("false num: " + num);
            }
        }
        System.out.println("false positive rate: " + falseCount * 1.0 / 1000);
    }
}
