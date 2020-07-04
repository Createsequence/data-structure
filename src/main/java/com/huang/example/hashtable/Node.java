package com.huang.example.hashtable;

/**
 * @Author：huang
 * @Date：2020-06-20 10:19
 * @Description：节点
 */
public class Node {

    //节点序号
    int num;

    //下一个节点
    Node next;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node{" + "num=" + num + '}';
    }
}
