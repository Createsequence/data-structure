package com.huang.example.tree;

/**
 * @Author：CreateSequence
 * @Date：2020-07-20 11:27
 * @Description：二叉排序树节点
 */
public class BinarySortTreeNode {
    int val;
    BinarySortTreeNode left;
    BinarySortTreeNode right;

    public BinarySortTreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                '}';
    }
}
