package com.lzhlyle.leetcode.self.no109;

public class ConvertSortedListToBinarySearchTree_FastSlow {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode l = head, r = slow.next;
        prev.next = slow.next = null; // disconnect: l...prev, slow, r...fast
        return new TreeNode(slow.val, sortedListToBST(l), sortedListToBST(r));
    }
}
