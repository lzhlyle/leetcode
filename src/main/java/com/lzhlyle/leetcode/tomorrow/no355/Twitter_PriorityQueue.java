package com.lzhlyle.leetcode.tomorrow.no355;

import java.util.*;

public class Twitter_PriorityQueue {
    private Map<Integer, Set<Integer>> userFollowsMap;
    private Map<Integer, List<Tweet>> userTweetsMap; // 个人所有推文都存

    /**
     * Initialize your data structure here.
     */
    public Twitter_PriorityQueue() {
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

    public List<Integer> getNewsFeed(int userId) {
        reg(userId);

        Queue<Tweet> queue = new PriorityQueue<>((t1, t2) -> t2.sort - t1.sort);
        queue.addAll(userTweetsMap.get(userId));
        for (Integer followeeId : userFollowsMap.get(userId)) {
            queue.addAll(userTweetsMap.get(followeeId));
        }

        List<Integer> res = new ArrayList<>(10);
        for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
            res.add(queue.remove().id);
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
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

    private void reg(int userId) {
        if (userFollowsMap.containsKey(userId)) return;
        userFollowsMap.put(userId, new HashSet<>());
        userTweetsMap.put(userId, new ArrayList<>());
    }
}
