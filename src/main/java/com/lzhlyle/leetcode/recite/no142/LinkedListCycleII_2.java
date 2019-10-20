package com.lzhlyle.leetcode.recite.no142;

public class LinkedListCycleII_2 {
//    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        ListNode second = new ListNode(2);
//        head.next = second;
//        ListNode third = new ListNode(0);
//        second.next = third;
//        ListNode last = new ListNode(-4);
//        third.next = last;
//        last.next = second;
//
//        ListNode res = new LinkedListCycleII_2().detectCycle(head);
//        System.out.println(res);
//    }

    // 快慢指针，F=b
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode meet = this._getMeetNode(head);
        if (meet == null) return null; // no cycle

        ListNode again = head;
        while (again != meet) {
            // F=b, same speed to meet at the entrance
            again = again.next;
            meet = meet.next;
        }
        return again;
    }

    private ListNode _getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return slow;
    }
}
