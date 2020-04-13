package com.lzhlyle.leetcode.self.no355;

import java.util.*;

public class Twitter {

    private Map<Integer, Set<Integer>> userFollowsMap;
    private Map<Integer, List<Tweet>> userTweetsMap; // 个人所有推文都存
    private Map<Integer, MinHeap> userHeapMap; // 只保留个人最近10条推文

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userFollowsMap = new HashMap<>();
        userTweetsMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        reg(userId);
        userTweetsMap.get(userId).add(new Tweet(tweetId));
    }

    private void reg(int userId) {
        if (userFollowsMap.containsKey(userId)) return;
        userFollowsMap.put(userId, new HashSet<>());
        userTweetsMap.put(userId, new ArrayList<>());
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        reg(userId);

        MinHeap minHeap = new MinHeap(10);
        minHeap.addAll(userTweetsMap.get(userId));
        for (Integer followeeId : userFollowsMap.get(userId)) {
            if (followeeId == userId) continue;
            minHeap.addAll(userTweetsMap.get(followeeId));
        }

        List<Integer> res = new ArrayList<>(10);
        int i = 0;
        while (i++ < 10) {
            if (minHeap.isEmpty()) break;
            res.add(minHeap.remove().id);
        }
        _reverse(res, 0, i - 2);

        System.out.println(res);
        return res;
    }

    private void _reverse(List<Integer> list, int l, int r) {
        while (l < r) {
            Integer swap = list.get(l);
            list.set(l, list.get(r));
            list.set(r, swap);
            l++;
            r--;
        }
    }

    public List<Integer> _getNewsFeed(int userId) {
        reg(userId);

        Queue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t2.sort - t1.sort);
        queue.addAll(userTweetsMap.get(userId));
        for (Integer followeeId : userFollowsMap.get(userId)) {
            if (followeeId == userId) continue;
            queue.addAll(userTweetsMap.get(followeeId));
        }

        List<Integer> res = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            if (queue.isEmpty()) break;
            res.add(queue.remove().id);
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        reg(followerId);
        reg(followeeId);
        userFollowsMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        reg(followerId);
        reg(followeeId);
        userFollowsMap.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        twitter.getNewsFeed(2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.getNewsFeed(2);
    }
}
