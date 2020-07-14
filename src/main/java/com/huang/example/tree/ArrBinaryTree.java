package com.huang.example.tree;

/**
 * @Author：CreateSequence
 * @Date：2020-07-14 19:12
 * @Description：顺序存储二叉树
 */
public class ArrBinaryTree {

    private int arr[];

    public ArrBinaryTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("数组需要至少包含一个元素！");
        }
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }
    /**
     * 前序遍历
     * @param index
     */
    public void preOrder(int index) {
        //输出数组
        System.out.println(arr[index]);
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

}
