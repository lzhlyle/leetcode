package com.lzhlyle.templates.algorithm.traverse;

/**
 * 二叉树遍历
 */
public class BinaryTreeOrder {

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(Object root) {
        // terminator
        if (root == null) return;

        // process
        this._process(root);

        // drill down
        this.preOrder(this._getLeftNode(root));
        this.preOrder(this._getRightNode(root));

        // reverse state
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(Object root) {
        // terminator
        if (root == null) return;

        // process, drill down
        this.inOrder(this._getLeftNode(root));
        this._process(root);
        this.inOrder(this._getRightNode(root));

        // reverse state
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(Object root) {
        // terminator
        if (root == null) return;

        // drill down
        this.postOrder(this._getLeftNode(root));
        this.postOrder(this._getRightNode(root));

        // process
        this._process(root);

        // reverse state
    }

    private Object _getRightNode(Object root) {
        return null;
    }

    private Object _getLeftNode(Object root) {
        return null;
    }

    private void _process(Object root) {

    }
}
