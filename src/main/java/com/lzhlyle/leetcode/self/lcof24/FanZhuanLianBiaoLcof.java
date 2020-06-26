package com.lzhlyle.leetcode.self.lcof24;

public class FanZhuanLianBiaoLcof {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            // reverse
            curr.next = prev;
            // drill down
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
