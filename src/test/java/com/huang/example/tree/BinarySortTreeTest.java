package com.huang.example.tree;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：CreateSequence
 * @Date：2020-07-20 12:16
 * @Description：<描述>
 */
public class BinarySortTreeTest {

    static int[] arr = {3, 2, 7, 6, 4, 1, 0, 8};
    static BinarySortTree tree = new BinarySortTree(new BinarySortTreeNode(5));

    @BeforeClass
    public static void testAdd() {
        for (int i : arr) {
            tree.add(new BinarySortTreeNode(i));
        }
        tree.show();
        System.out.println();
    }

    @Test
    public void testDelete() {
        tree.deleteNode(5);
        tree.show();
    }

    @Test
    public void search() {
        System.out.println(tree.searchTargetParent(2));
    }
}
