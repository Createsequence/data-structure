package com.huang.example.tree;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：CreateSequence
 * @Date：2020-07-23 19:04
 * @Description：<描述>
 */
public class AVLTreeTest {

    //static int[] arr = {3, 6, 5, 7, 8};
    //static AVLTree tree = new AVLTree(new BinarySortTreeNode(4));
    static int[] arr = {12, 8, 9, 7, 6};
    static AVLTree tree = new AVLTree(new BinarySortTreeNode(10));

    @BeforeClass
    public static void testAdd() {
        for (int i : arr) {
            tree.add(new BinarySortTreeNode(i));
        }
    }

    @AfterClass
    public static void testOrder() {
        System.out.println();
        System.out.println("展示结果：");
        tree.show();
    }

    @Test
    public void testGetHeight() {
        System.out.println("树高度：" + tree.getHeight(tree.root));
        System.out.println("左子树高度：" + tree.getLeftHeight(tree.root));
        System.out.println("右子树高度：" + tree.getRightHeight(tree.root));
    }

}
