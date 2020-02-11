package com.lzhlyle.leetcode.recite.no515;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow_BFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        bfs(new LinkedList<>(Collections.singleton(root)), res);
        return res;
    }

    private void bfs(Queue<TreeNode> queue, List<Integer> res) {
        if (queue.isEmpty()) return;
        Queue<TreeNode> next = new LinkedList<>();
        boolean hasVal = false;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) continue;
            hasVal = true;
            max = Math.max(max, node.val);
            next.add(node.left);
            next.add(node.right);
        }
        if (hasVal) res.add(max);
        bfs(next, res);
    }
}
