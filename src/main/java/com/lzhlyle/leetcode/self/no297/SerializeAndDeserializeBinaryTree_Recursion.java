package com.lzhlyle.leetcode.self.no297;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree_Recursion {
    private static final String _SPLITER = ",";
    private static final String _NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        _buildString(root, builder);
        return builder.toString();
    }

    private void _buildString(TreeNode curr, StringBuilder builder) {
        if (curr == null) builder.append(_NULL).append(_SPLITER);
        else {
            builder.append(curr.val).append(_SPLITER);
            _buildString(curr.left, builder);
            _buildString(curr.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new LinkedList<>(Arrays.asList(data.split(_SPLITER)));
        return _buildTree(deque);
    }

    private TreeNode _buildTree(Deque<String> deque) {
        String val = deque.remove();
        if (val.equals(_NULL)) return null;
        TreeNode res = new TreeNode(Integer.valueOf(val));
        res.left = _buildTree(deque);
        res.right = _buildTree(deque);
        return res;
    }
}
