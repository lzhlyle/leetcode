package com.lzhlyle.leetcode.week.no297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_Recursion {
    private static final String _NULL = "#", _SPLITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        _buildString(root, builder);
        return builder.toString();
    }

    private void _buildString(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(_NULL).append(_SPLITER);
            return;
        }
        builder.append(node.val).append(_SPLITER);
        _buildString(node.left, builder);
        _buildString(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(_SPLITER)));
        return _buildTree(queue);
    }

    private TreeNode _buildTree(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        String val = queue.remove();
        if (val.equals(_NULL)) return null;
        TreeNode res = new TreeNode(Integer.valueOf(val));
        res.left = _buildTree(queue);
        res.right = _buildTree(queue);
        return res;
    }
}
