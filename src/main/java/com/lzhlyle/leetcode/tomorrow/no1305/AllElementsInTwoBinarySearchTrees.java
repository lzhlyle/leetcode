package com.lzhlyle.leetcode.tomorrow.no1305;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) res.add(list1.get(i++));
            else res.add(list2.get(j++));
        }
        while (i < list1.size()) res.add(list1.get(i++));
        while (j < list2.size()) res.add(list2.get(j++));
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
