package com.huang.example.tree;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-07-11 17:54
 * @Description：二叉树测试
 */
public class BinaryTreeTest {

    static BinaryTree tree;

    @BeforeClass
    public static void createTree() {
        BinaryTreeNode rootNode = new BinaryTreeNode(1);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(7);

        //第二层节点
        rootNode.setLeft(treeNode2);
        rootNode.setRight(treeNode3);

        //第三层节点
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        treeNode3.setRight(treeNode7);

        tree = new BinaryTree(rootNode);
    }

    @Test
    public void testOrder(){
        System.out.println("前序遍历：");
        tree.preOrder();
        System.out.println("中序遍历：");
        tree.inOrder();
        System.out.println("后序遍历：");
        tree.postOrder();
    }

    @Test
    public void testSearch() {
        System.out.println("前序查找：");
        System.out.println(tree.preSearch(4));
        System.out.println("中序查找：");
        System.out.println(tree.inSearch(2));
        System.out.println("前序查找：");
        System.out.println(tree.postSearch(1));
    }

    @Test
    public void testDelete() {
        System.out.println("前序遍历：");
        tree.preOrder();

        System.out.println("删除2");
        tree.delete(2);
        System.out.println("前序遍历：");
        tree.preOrder();

        System.out.println("删除7");
        tree.delete(7);
        System.out.println("前序遍历：");
        tree.preOrder();


    }

}
