package com.huang.example.tree;

import org.junit.Test;

/**
 * @Author：CreateSequence
 * @Date：2020-07-14 19:31
 * @Description：顺序存储二叉树测试
 */
public class ArrBinaryTreeTest {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7};

    @Test
    public void testOrder() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
    }

}
