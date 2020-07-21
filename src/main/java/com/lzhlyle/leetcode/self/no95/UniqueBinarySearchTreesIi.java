package com.lzhlyle.leetcode.self.no95;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesIi {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        return build(1, n);
    }

    private List<TreeNode> build(int l, int r) {
        if (l > r) return Collections.singletonList(null);
        List<TreeNode> list = new ArrayList<>();
        for (int i = l; i <= r; i++)
            for (TreeNode ln : build(l, i - 1))
                for (TreeNode rn : build(i + 1, r))
                    list.add(new TreeNode(i, ln, rn));
        return list;
    }
}
