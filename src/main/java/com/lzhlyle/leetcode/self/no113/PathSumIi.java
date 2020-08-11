package com.lzhlyle.leetcode.self.no113;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
                return res;
            }
        }

        res.addAll(pathSum(root.left, sum - root.val));
        res.addAll(pathSum(root.right, sum - root.val));
        for (List<Integer> list : res)
            list.add(0, root.val);
        return res;
    }
}
