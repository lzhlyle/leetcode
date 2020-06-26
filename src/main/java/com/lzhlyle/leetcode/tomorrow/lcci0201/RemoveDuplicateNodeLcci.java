package com.lzhlyle.leetcode.tomorrow.lcci0201;

public class RemoveDuplicateNodeLcci {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        boolean[] arr = new boolean[20001];
        ListNode curr = head, pre = null;
        while (curr != null) {
            if (!arr[curr.val]) {
                arr[curr.val] = true;
                pre = curr;
                curr = curr.next;
            } else {
                curr = pre.next = curr.next;
            }
        }
        return head;
    }
}
