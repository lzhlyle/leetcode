package com.lzhlyle.leetcode.self.no109;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree_Array {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(list.get(l));
        int mid = l + (r - l) / 2;
        TreeNode ln = build(list, l, mid - 1), rn = build(list, mid + 1, r);
        return new TreeNode(list.get(mid), ln, rn);
    }
}
