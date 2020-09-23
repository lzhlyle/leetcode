package com.lzhlyle.leetcode.self.no501;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    private int max, cnt;
    private Integer last;
    private List<Integer> list;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        max = cnt = 1;
        last = null;
        list = new ArrayList<>();

        dfs(root, list);
        if (cnt == max) {
            list.add(last);
        } else if (cnt > max) {
            list.clear();
            list.add(last);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);

        if (last == null) last = node.val;
        else if (node.val == last) {
            cnt++;
        } else {
            if (cnt == max) {
                list.add(last);
            } else if (cnt > max) {
                list.clear();
                list.add(last);
                max = cnt;
            }
            last = node.val;
            cnt = 1;
        }

        dfs(node.right, list);
    }
}
