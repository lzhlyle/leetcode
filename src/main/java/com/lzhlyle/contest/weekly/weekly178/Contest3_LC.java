package com.lzhlyle.contest.weekly.weekly178;

public class Contest3_LC {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        // 先判断当前的节点，如果不对，再看左子树和右子树
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(ListNode head, TreeNode node) {
        if (head == null) return true;
        if (node == null) return false;

        // 如果值不同，必定不是啊
        if (head.val != node.val) return false;

        // 如果值相同，继续看，左边和右边有一个满足即可
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }
}
