package com.lzhlyle.leetcode.tomorrow.no117;

public class PopulatingNextRightPointersInEachNodeIi_Points {
    // curr 为上一层
    // head, tail 为下一层，每次都新开
    public Node connect(Node root) {
        Node level = root;
        while (level != null) {
            Node head = new Node(), tail = head;
            while (level != null) {
                if (level.left != null) tail = tail.next = level.left;
                if (level.right != null) tail = tail.next = level.right;
                level = level.next; // curr 当前层的下一个
            }
            level = head.next; // curr 的下一层
        }
        return root;
    }
}
