package com.lzhlyle.leetcode.recite.no355;

import java.util.List;

public class MinHeap {
    private Tweet[] data;
    private int size;

    public MinHeap(int capacity) {
        data = new Tweet[capacity + 1]; // data[0] always null
        size = 1;
    }

    public void addAll(List<Tweet> tweets) {
        for (Tweet tweet : tweets) add(tweet);
    }

    private boolean add(Tweet tweet) {
        if (size == data.length) {
            // full
            if (tweet.sort > data[1].sort) {
                data[1] = tweet;
                heapifyTopDown(1);
            } else return false;
        } else {
            // not full
            data[size] = tweet;
            size++;
            heapifyBottomUp(size - 1);
        }
        return true;
    }

    private void heapifyBottomUp(int bottom) {
        int top = bottom / 2, l = 2 * top, r = l + 1, min = top;
        if (l < size && min > 0 && data[l].sort < data[min].sort) min = l;
        if (r < size && min > 0 && data[r].sort < data[min].sort) min = r;
        if (min == top) return;

        Tweet swap = data[top];
        data[top] = data[min];
        data[min] = swap;
        heapifyBottomUp(top);
    }

    private void heapifyTopDown(int top) {
        int l = 2 * top, r = l + 1, min = top;
        if (l < size && data[l].sort < data[min].sort) min = l;
        if (r < size && data[r].sort < data[min].sort) min = r;
        if (min == top) return;

        Tweet swap = data[top];
        data[top] = data[min];
        data[min] = swap;
        heapifyTopDown(min);
    }

    public Tweet remove() {
        size--;
        Tweet res = data[1];
        data[1] = data[size];
        data[size] = null;
        heapifyTopDown(1);
        return res;
    }

    public boolean isEmpty() {
        return size == 1;
    }
}
