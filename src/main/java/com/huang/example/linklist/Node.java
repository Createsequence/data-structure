package com.huang.example.linklist;

/**
 * @Author：huang
 * @Date：2020-06-20 10:19
 * @Description：节点
 */
public class Node {

    //节点序号
    int num;

    //数据
    Object data;

    //下一个节点
    Node next;

    //上一节点
    Node prev;

    public Node(int num, Object data) {
        this.num = num;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", data=" + data +
                '}';
    }
}
