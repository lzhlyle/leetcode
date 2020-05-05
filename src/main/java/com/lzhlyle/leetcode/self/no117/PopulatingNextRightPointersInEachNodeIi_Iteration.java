package com.lzhlyle.leetcode.self.no117;

public class PopulatingNextRightPointersInEachNodeIi_Iteration {
    // curr 为上一层
    // head, tail 为下一层，每次都新开
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node head = new Node(), tail = head;
            while (curr != null) {
                if (curr.left != null) tail = tail.next = curr.left;
                if (curr.right != null) tail = tail.next = curr.right;
                curr = curr.next; // curr 当前层的下一个
            }
            curr = head.next; // curr 的下一层
        }
        return root;
    }
}
