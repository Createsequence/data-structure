package com.huang.example.tree;

/**
 * @Author：黄成兴
 * @Date：2020-07-11 17:30
 * @Description：二叉树
 */
public class BinaryTreeNode {

    private int nodeNum;

    /**
     * 右子节点
     */
    private BinaryTreeNode right;

    /**
     * 左子节点
     */
    private BinaryTreeNode left;

    public BinaryTreeNode(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "nodeNum=" + nodeNum +
                '}';
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
}
