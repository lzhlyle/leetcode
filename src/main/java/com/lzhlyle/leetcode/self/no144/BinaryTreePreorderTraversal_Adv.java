package com.lzhlyle.leetcode.self.no144;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_Adv {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new LinkedList<>();
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
