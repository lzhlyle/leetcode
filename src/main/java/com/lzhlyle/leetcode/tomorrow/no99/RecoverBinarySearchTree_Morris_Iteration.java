package com.lzhlyle.leetcode.tomorrow.no99;

public class RecoverBinarySearchTree_Morris_Iteration {
    // Morris Traversal
    public void recoverTree(TreeNode root) {
        TreeNode prev = null, bad1 = null, bad2 = null;

        // traversal
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                // process
                if (prev != null && curr.val < prev.val) {
                    bad2 = curr;
                    if (bad1 == null) bad1 = prev;
                    // else break; // cannot break, should disconnect
                }
                prev = curr;

                curr = curr.right; // drill down
            } else {
                // find the last of the left
                TreeNode last = curr.left;
                while (last.right != null && last.right != curr)
                    last = last.right;

                if (last.right == null) {
                    last.right = curr; // connect
                    curr = curr.left; // drill down
                } else {
                    // process
                    if (prev != null && curr.val < prev.val) {
                        bad2 = curr;
                        if (bad1 == null) bad1 = prev;
                        // else break; // cannot break, should disconnect
                    }
                    prev = curr;

                    last.right = null; // disconnect
                    curr = curr.right; // drill down
                }
            }
        }

        int swap = bad1.val;
        bad1.val = bad2.val;
        bad2.val = swap;
    }
}
