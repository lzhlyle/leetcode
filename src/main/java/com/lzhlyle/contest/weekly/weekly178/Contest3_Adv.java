package com.lzhlyle.contest.weekly.weekly178;

import java.util.LinkedList;
import java.util.List;

public class Contest3_Adv {
    // 前序遍历
    List<Integer> list = new LinkedList<>();

    public boolean isSubPath(ListNode head, TreeNode root) {
        preOrder(root);

        List<Integer> nodeList = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            nodeList.add(curr.val);
            curr = curr.next;
        }

        for (int i = 0; i < list.size(); i++) {
            int match = 0;
            for (int ni = 0, li = i; ni < nodeList.size() && li < list.size(); ni++, li++) {
                if (list.get(li).equals(nodeList.get(ni))) {
                    match++;
                } else break;
            }
            if (match == nodeList.size()) return true;
        }

        return false;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        // 未必一定要先左边!!!!!
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Contest3_Adv contest = new Contest3_Adv();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(10);

            TreeNode root = new TreeNode(1);
            TreeNode n1 = new TreeNode(1);
            root.right = n1;
            TreeNode n2 = new TreeNode(10);
            n1.left = n2;
            n1.right = new TreeNode(1);
            n2.left = new TreeNode(9);

            boolean res = contest.isSubPath(head, root);
            System.out.println(res);
        }
    }
}

